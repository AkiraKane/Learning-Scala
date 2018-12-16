package lectures.part2oop

object Objects {

  // Scala does not have class-level functionality ("static")
  // Objects have the static like functionality, similar to class
  // but do not receive parameters

  object Person {
    // "static" | "class"-level functionality
    val N_EYES = 2

    def canFly: Boolean = false

    // Factory Method
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }


  class Person(val name: String) {
    // Instance-level functionality
  }

  // COMPANIONS: a pattern of writing classes and objects with the same name in the same scope

  def main(args: Array[String]): Unit = {

    println(Person.N_EYES)
    println(Person.canFly)

    // Scala object = Singleton Instance

    val mary = new Person("Mary")
    val john = new Person("John")

    val bobbie = Person.apply(mary, john)
    // val bobbie = Person(mary, john)

    // Scala Applications = Scala object with
    // def main(args: Array[String]): Unit
  }
}
