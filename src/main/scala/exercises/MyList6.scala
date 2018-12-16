package exercises

object MyList6 extends App{

  // MyList with For Comprehension

  abstract class MyList[+A] {

    def head: A

    def tail: MyList[A]

    def isEmpty: Boolean

    def add[B >: A](element: B): MyList[B]

    def printElements: String

    // polymorpic call
    override def toString: String = "[" + printElements + "]"

    // Higher-order functions
    def map[B](transformer: A => B): MyList[B]

    // Concatenation
    def ++[B >: A](list: MyList[B]): MyList[B]

    def flatMap[B](transformer: A => MyList[B]): MyList[B]

    def filter(predicate: A => Boolean): MyList[A]

    // HOFs: Foreach function
    def foreach(f: A => Unit): Unit

    def sort(compare: (A, A) => Int): MyList[A]

    def zipWith[B,C](list: MyList[B], zip: (A, B) => C): MyList[C]

    def fold[B](start: B)(operator: (B,A) => B): B

  }

  object Empty extends MyList[Nothing] {
    def head: Nothing = throw new NoSuchElementException

    def tail: MyList[Nothing] = throw new NoSuchElementException

    def isEmpty: Boolean = true

    def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)

    def printElements: String = ""

    def map[B](transformer: Nothing => B): MyList[B] = Empty

    def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

    def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty

    def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

    // HOFs
    def foreach(f: Nothing => Unit): Unit = ()

    def sort(compare: (Nothing, Nothing) => Int): MyList[Nothing] = Empty

    def zipWith[B,C](list: MyList[B], zip: (Nothing, B) => C): MyList[C] =
      if(!list.isEmpty) throw new RuntimeException("Lists do not have the same length")
      else Empty

    def fold[B](start: B)(operator: (B, Nothing) => B): B = start
  }

  class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {

    def head: A = h

    def tail: MyList[A] = t

    def isEmpty: Boolean = false

    def add[B >: A](element: B): MyList[B] = new Cons(element, this)

    def printElements: String =
      if (t.isEmpty) "" + h
      else h + " " + t.printElements

    def map[B](transformer: A => B): MyList[B] =
      new Cons(transformer(h), t.map(transformer))

    def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)

    def flatMap[B](transformer: A => MyList[B]): MyList[B] =
      transformer(h) ++ t.flatMap(transformer)

    def filter(predicate: A => Boolean): MyList[A] =
      if (predicate(h)) new Cons(h, t.filter(predicate))
      else t.filter(predicate)

    // HOFs
    def foreach(f: A => Unit): Unit = {
      f(h)
      t.foreach(f)
    }

    def sort(compare: (A, A) => Int): MyList[A] = {
      def insert(x: A, sortedList: MyList[A]): MyList[A] = {
        if(sortedList.isEmpty) new Cons(x, Empty)
        else if(compare(x, sortedList.head) <= 0) new Cons(x, sortedList)
        else new Cons(sortedList.head, insert(x, sortedList.tail))
      }

      val sortedTail = t.sort(compare)
      insert(h, sortedTail)
    }

    def zipWith[B,C](list: MyList[B], zip: (A, B) => C): MyList[C] =
      if(list.isEmpty) throw new RuntimeException("Lists do not have the same length")
      else new Cons(zip(h, list.head), t.zipWith(list.tail, zip))

    def fold[B](start: B)(operator: (B,A) => B): B =
      t.fold(operator(start, h))(operator)
  }

  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val anotherListOfIntegers: MyList[Int] = new Cons(4, new Cons(5, Empty))
  val listOfStrings: MyList[String] = new Cons("hello", new Cons("Scala", Empty))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)

  println(listOfIntegers.map(elem => elem * 2).toString)
  // println(listOfIntegers.map(_ * 2).toString)

  println(listOfIntegers.filter(elem => elem % 2 == 0).toString)
  // println(listOfIntegers.filter(_ % 2 == 0).toString)

  println((listOfIntegers ++ anotherListOfIntegers).toString)

  println(listOfIntegers.flatMap(elem => new Cons(elem, new Cons(elem+1, Empty)))toString)

  listOfIntegers.foreach(println)

  println(listOfIntegers.sort((x, y) => y - x)) // inverse the order
  println(listOfIntegers.sort((x, y) => x - y))

  println(anotherListOfIntegers.zipWith[String, String](listOfStrings, _ + "-" + _ ))

  println(listOfIntegers.fold(0)(_+_))

  // for comprehension works since the implementation of map flatMap and filter match the requirement
  val combinations = for {
    n <- listOfIntegers
    string <- listOfStrings
  } yield n + "-" + string

  println(combinations)
}