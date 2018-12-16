package lectures.part1basics

object Expressions extends App{

  val x = 1 + 2  // Expression
  println(x)

  println(2 + 3 * 4)

  // If Expression
  val aCondition = true
  val aConditionValue = if (aCondition) 5 else 3
  println(aConditionValue)

  // Everything in scala is an expression.
  var aVariable = 3

  val aWeirdValue = (aVariable = 5)
  println(aWeirdValue)

  // Side Effects: println(), while loop, reassigning. those are expressions return unit

  // code blocks

  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "Hello" else "goodbye"
  }


}
