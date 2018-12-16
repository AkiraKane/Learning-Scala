package lectures.part2oop

object AnonymousClasses extends App{
  // We can instantiate types and override fields oe methods on the spot
  // pass in required constructor arguments if needed
  // implement all abstract fields/methods
  // works for traits and classes (abstract or not)

  abstract class Animal{
    def eat: Unit
  }

  // Anonymous class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("hahhaha")
  }

  /*
  equivalent with

  class AnonymousClasses$$anon$1 extends Animal{
    override def eat: Unit = println("hahhaha")
    }

    val funnyAnimal: Animal = new AnonymousClasses$$anon$1
   */

  println(funnyAnimal.getClass)


  class Person(name: String){

    def sayHi: Unit = print(s"Hi, my name is $name, how can I help you?")
  }

  val jim = new Person("Jim"){
    override def sayHi: Unit = println(s"Hi, my name is Jim, how can I be of service?")
  }
}



