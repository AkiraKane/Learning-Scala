package lectures.part1basics

object CBNvsCBV extends App{

  def callByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  def callByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  callByValue(System.nanoTime())
  callByName(System.nanoTime())

  // Call by value:
  // 1. value is computed before call
  // 2. same value used everywhere

  // Call by name:
  // 1. expression is passed literally
  // 2. expression is evaluated at every use within the function definition

}
