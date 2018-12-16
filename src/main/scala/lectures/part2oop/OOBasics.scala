package lectures.part2oop

object OOBasics extends App{

  val person = new Person("John", 26)
  println(person.age)
  person.greet("Ming")

  val author = new Writer("Charles", "Dickens", 1812)
  val imposter = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  println(novel.authorAge)
  println(novel.isWrittenBy(author))
  println(novel.isWrittenBy(imposter))

  val counter = new Counter
  counter.inc.print
  counter.inc.inc.inc.print

}

class Person(name: String, val age: Int){ // Constructor

  val x = 2

  // method
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  // overloading, same method name but different method signatures
  def greet(): Unit = println(s"Hi, I am $name")

  // Multiple constructors
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")

}

// class parameters are not class FIELDS, convert class parameters to class fields, add var / val

class Writer(firstName: String, surName: String, val year: Int){

  def fullName: String = firstName + " " + surName
}


class Novel(name: String, year: Int, author: Writer){

  def authorAge = year - author.year

  def isWrittenBy(author: Writer) = author == this.author

  def copy(newYear: Int): Novel = new Novel(name, newYear, author)
}


class Counter(val count: Int = 0 ){
  // define a field instead of an argument, has the same effect of defining a getting method to return the value

  def inc = {
    println("incrementing")
    new Counter(count + 1)  // Immutability
  }
  def dec = {
    println("decrementing")
    new Counter(count - 1)
  }

  // overloading
  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n-1)
  }

  def dec(n: Int): Counter = {
    if(n <= 0) this
    else dec.dec(n-1)
  }

  def print = println(count)


}