package lectures.part2oop

object CaseClasses extends App{

  case class Person(name: String, age: Int)

  // 1. class parameters are auto-promoted to fields
  val jim = new Person("Jim", 34)
  println(jim.name)

  // 2. sensible toString, hashCode, equals
  // println(instance) = println(instance.toString)    // syntax sugar
  println(jim.toString)
  println(jim)

  // 3. equals and hashCode implemented out of box
  val jim2 = new Person("Jim", 34)
  println(jim == jim2)

  // 4. have handy copy method
  val jim3 = jim.copy(age=45)
  println(jim3)

  // 5. have companion objects
  val thePerson = Person

  val mary = Person("Mary", 23)

  // 6. are serializable (Akka)

  // 7. have extractor patterns = can be used in Pattern Matching

  case object UnitedKingdom{
    def name: String = "The UK of GB and NI"
  }

  // Expand the MyList - use case classes or case objects



}
