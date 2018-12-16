package lectures.part1basics

object Functions extends App{

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())
  println(aParameterlessFunction)

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }

  println(aRepeatedFunction("Hello", 3))

  // When you need loops, use recursion. Recursive functions need return types.

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aGreetingFunction(name: String, age: Int): String = "Hi, my name is $name and I am $age years old."

  // Factorial function
  def aFactorialFunction(n: Int): Int = {
    if (n <= 0) 1
    else n * aFactorialFunction(n-1)
  }

  println(aFactorialFunction(5))

  // A Fibonacci Function
  def aFibonacciFunction(n: Int): Int = {
    if (n <= 2) 1
    else aFibonacciFunction(n-1) + aFibonacciFunction(n-2)
  }

  println(aFactorialFunction(8))


// Test if a number is prime
  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t-1)
    }

    isPrimeUntil(n / 2)
  }

  println(isPrime(37))
  println(isPrime(2003))
  println(isPrime(37 * 17))
}
