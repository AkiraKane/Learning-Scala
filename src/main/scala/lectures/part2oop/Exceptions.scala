package lectures.part2oop

object Exceptions extends App{
/*
  val x: String = null
  // println(x.length)

  // 1. throwing exceptions
  // val aWeirdValue = throw new NullPointerException

  // throwable classes extend the Throwable class
  // Exception and Error are the major Throwable subtypes

  // 2. catch exceptions
  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int for you!")
    else 42

  val potentialFail = try{
    // code that might throw
    getInt(true)
  } catch{
    case e: RuntimeException => println("caught a Runtime exception")
  } finally{
    // code that will get executed no matter what
    // optional
    // does not influence the return type of this expression
    // use finally only for side effects
    println("finally")
  }

  println(potentialFail)

  // 3. How to define your own exceptions
  class MyException extends Exception
  val exception = new MyException

  throw exception

  // OutOfMemoryError
  val array = Array.ofDim(Int.MaxValue)

  // Stack overflow error
  def infinite: Int = 1 + infinite
  val noLimit = infinite

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by 0")

  object PocketCalculator{

    def add(x: Int, y: Int) = {
      val result = x + y

      if(x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract(x: Int, y: Int) = {
      val result = x - y

      if(x > 0 && y < 0 && result < 0) throw new OverflowException
      else if(x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y: Int) = {
      val result = x * y

      if(x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def divide(x: Int, y: Int) = {
      if(y==0) throw new MathCalculationException
      else x / y
    }
  }

  println(PocketCalculator.add(Int.MaxValue, 10))
  println(PocketCalculator.divide(2, 0))

  // 1. Exceptions crash your program
  // 2. How to throw exceptions: throwing returns Nothing


*/

}
