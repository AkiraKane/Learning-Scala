package lectures.part2oop

object Inheritance extends App{

  // single class inheritance
  class Animal{
    val creatureType = "wild"
    // protected def eat = println("nomnom")
    def eat = println("nomnom")
  }

  class Cat extends Animal{

    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  // Constructors
  class Person(name: String, age: Int){
    def this(name: String) = this(name, 0)  // the better way is class Person(name: String, age: Int = 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  // Overriding
  class Dog(override val creatureType: String) extends Animal{
    // override val creatureType = "domestic"
    override def eat = println("crunch crunch")
  }

  // class Dog(val dogType: String) extends Animal{
  //     override val creatureType = dogType

  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)


  // Type Substitution (Broad: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  // Super
  class Doggy(override val creatureType: String) extends Animal {
    override def eat = {
      super.eat
      println("crunch crunch")
    }
  }
  val dog1 = new Doggy("K10")
  dog1.eat

  // Preventing overriding
  // 1 - use keyword final on member
  // 2 - use keyword final on the entire class to prevent being extended from other subclasses
  // 3 - seal the class = extend classes in This File, prevent extension in Other Files (using keyword sealed)


}
