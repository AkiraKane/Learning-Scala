package lectures.part3fp

object AnonymousFunctions extends App{

  // Lambda
  val doubler = (x: Int) => x * 2
  val doubler1: Int => Int = x => x * 2

  val adder: (Int, Int) => Int = (x: Int, y: Int) => x + y

  val justDoSomething = () => 3

  // be careful to call the lambda function without parameters
  println(justDoSomething)  // function itself
  println(justDoSomething()) // actual call

  // curly braces with lambdas
  val stringToInt = {
    (s: String) => s.toInt
  }

  // More syntax sugar
  val niceIncrementer: Int => Int = _ + 1 //  equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ // equivalent to (a, b) => a + b

  val superAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]]{
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  // rewrite superAdder function as an anonymous function
  val superAdderAnonymous = (x: Int) => (y: Int) => x + y

  println(superAdderAnonymous(3)(4))


}
