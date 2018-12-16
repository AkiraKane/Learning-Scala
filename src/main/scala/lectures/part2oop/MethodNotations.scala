package lectures.part2oop

object MethodNotations extends App{

  class Person(val name: String, favoriteMovie: String, val age: Int = 0){

    def likes(movie: String): Boolean = movie == favoriteMovie

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    // Overload + method
    def +(nickname: String): Person = new Person(s"$name ($nickname)", favoriteMovie)

    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)

    def unary_! : String = s"$name, what the heck?!"

    def isAlive: Boolean = true

    def apply(): String = s"Hi, my name is $name, and I like $favoriteMovie"

    // overload apply method
    def apply(num: Int): String = s"$name watched $favoriteMovie $num times"

    def learns(thing: String): String = s"$name is learning $thing"

    def learnScala: String = this learns "Scala"

  }

  val mary = new Person("Mary", "Inception")

  println(mary.likes("Inception"))
  println(mary likes "Inception")  // Infix notation = operator notation

  // "operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary + tom)
  println(mary.+(tom))

  println(1 + 2)
  println(1.+(2))

  // All Operators are Methods
  // Akka actors have ! ?

  // Prefix notation
  val x = -1  // equivalent with 1.unary_-
  // unary_ prefix only works with - + ~ !
  println(!mary)
  println(mary.unary_!)

  // Postfix notation (method without parameters)
  println(mary.isAlive)
  println(mary isAlive)

  // Apply
  println(mary.apply())
  println(mary())  // equivalent


  println((mary + "the RockStar")())
  println((mary + "the RockStar").apply())
  println((+mary).age)
  println(mary learnScala)
  println(mary(10))

}
