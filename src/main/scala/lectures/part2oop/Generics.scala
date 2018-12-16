package lectures.part2oop

object Generics extends App {

  // also work with trait
  class MyList[+A] {
    // use the type A
    def add[B >: A](element: B): MyList[B] = ???

    /*
    A = Cat
    B = Dog = Animal
     */
  }

  class MyMap[Key, Value]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // generic methods
  // object cannot have type parameter
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  class Animal

  class Dog extends Animal

  class Cat extends Animal

  // Q: if Cat extends Animal, should List[Cat] extends List[Animal]?

  // 1. Yes, List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]

  val animal: Animal = new Cat // polymorphism
  val animalList: CovariantList[Animal] = new CovariantList[Cat]

  // 2. No, Invariance
  class InvariantList[A]

  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. Hell, no ! Countravariance
  class Trainer[-A]

  val trainer: Trainer[Cat] = new Trainer[Animal]

  // Bounded types
  class Cage[A <: Animal](animal: A) // class Cage only accept type parameters which are subtypes of animal
  val cage = new Cage(new Dog)
}






