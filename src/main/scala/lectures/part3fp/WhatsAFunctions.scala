package lectures.part3fp

object WhatsAFunctions extends App{

  // Dream: use functions as first class elements

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))

  // function type = Function1[A, B]
  val stringToIntConverter = new Function1[String, Int] {
    override def apply(elem: String): Int = elem.toInt
  }

  println(stringToIntConverter("3") + 4)


  val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }

  // Function types Function2[A, B, C] === (A, B) => C

  // All scala functions are objects

  def concatenator: (String, String) => String = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }

  println(concatenator("Hello", "Scala"))

  // Function1[Int, Function1[Int, Int]]

  val superAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]]{
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  val adder3 = superAdder(3)
  println(adder3(4))
  println(superAdder(3)(4)) // Curried Function
}



trait MyFunction[A, B]{
  def apply(element: A): B
}
