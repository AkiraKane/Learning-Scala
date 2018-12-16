package lectures.part4pm

object PatternsEverywhere extends App{

  try{
    // code
  } catch{
    case e: RuntimeException => "runtime"
    case npe: NullPointerException => "npe"
    case _ => "something else"
  }
  // catches are actually matches

  val list = List(1, 2, 3, 4)
  val evenOnes = for{
    x <- list if x % 2 == 0
  } yield 10 * x
  // generators are also based on pattern matching

  val tuples = List((1, 2), (3, 4))
  val filterTuples = for{
    (first, second) <- tuples
  } yield first * second

  val tuple = (1, 2, 3)
  val (a, b, c) = tuple
  println(a)

  val head :: tail = list
  println(head)
  println(tail)

  // partial function based on pattern matching
  val mappedList = list.map {
    case v if v % 2 == 0 => v + " is even"
    case 1 => "the one"
    case _ => "something els"
  } // partial function literal

  val mappedList2 = list.map { x => x match {
    case v if v % 2 == 0 => v + " is even"
    case 1 => "the one"
    case _ => "something els"
    }
  }

  println(mappedList)




}