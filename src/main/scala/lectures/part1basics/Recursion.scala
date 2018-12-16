package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n : Int): Int = {

    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n-1))
      val result = n * factorial(n - 1)
      println("Computed factorial of " + n)
      result
    }
  }

  // println(factorial(10))
  // println(factorial(5000))

  def anotherFactorial(n: Int): Int = {
    @tailrec
    def factHelper(x: Int, accumulator: Int): Int = {
      if (x <= 1) accumulator
      else factHelper(x-1, x*accumulator)  // Tail Recursion = use recursive call as the last expression
    }
    factHelper(n, 1)
  }

  // When you need loops, use tail_recursion

  // Exercise 1. Concatenate a string n times

  // Recursive
  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }

  // Tail Recursive
  @tailrec
  def concatStrings(aString: String, n: Int, accumulator: String): String = {
    if (n <= 0) accumulator
    else concatStrings(aString, n-1, accumulator + aString)
  }

  println(concatStrings("hello", 3, ""))


  // Exercise 2. Fibonacci function
  def fibonacciNumber(n: Int): Int = {
    if (n <= 2) 1
    else fibonacciNumber(n-2) + fibonacciNumber(n-1)
  }

  def fibonacciNumberTailRecursive(n: Int): Int = {
    def fiboTailrec(i: Int, last: Int, nextToLast: Int): Int = {
      if(i >= n) last
      else fiboTailrec(i+1, last+nextToLast, last)
    }

    if (n <= 2) 1
    else fiboTailrec(2, 1, 1)
  }

  println(fibonacciNumberTailRecursive(8))

  // Exercise 3. isPrime function

  def isPrime0(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t-1)
    }

    isPrimeUntil(n / 2)
  }



  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean = {
      if(!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailrec(t-1, n % t != 0 && isStillPrime)
    }

    isPrimeTailrec(n/2, true)
  }

  println(isPrime(2003))
  println(isPrime(629))

}
