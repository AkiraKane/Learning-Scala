package lectures.part2oop

object AbstractDataTypes extends App{

  // Abstract class cannot be instantiated
  abstract class Animal{
    val creatureType: String
    def eat: Unit
  }

  class Dog extends Animal{
    val creatureType: String = "Canine"

    def eat: Unit = println("crunch crunch")
  }

  // traits
  trait Carnivore{
    def eat(animal: Animal): Unit
    // val preferredMeal: String = "fresh meat"
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    val creatureType: String = "croc"

    override def eat: Unit = println("nomno nomno")

    override def eat(animal: Animal): Unit = println(s"I am a croc, and I am eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  // traits vs abstract classes
  // 1 - traits do not have constructor parameters
  // 2 - multiple traits may be inherited by the same class
  // 3 - traits = behavior, abstract class = "thing"
  // 4 - both trait and abstract classes have both abstract and non-abstract members

}
