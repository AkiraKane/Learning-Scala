package lectures.part3fp

object TuplesAndMaps extends App{

  // tuples = finite ordered "lists"
  val aTuple = new Tuple2(2, "hello, scala")  // Tuple2[Int, String] = (Int, String)

  val aTuple2 = (2, "hello, scala")

  println(aTuple._1)
  println(aTuple.copy(_2 = "Goodbye Java"))
  println(aTuple.swap)

  // Maps: keys -> values
  val aMap: Map[String, Int] = Map()

  val phoneBook = Map(("Jim", 555), "Ming" -> 789).withDefaultValue(-1)
  // a -> b is syntax sugar for (a, b)
  println(phoneBook)

  // map operations
  println(phoneBook.contains("Jim"))
  println(phoneBook("Jim"))
  println(phoneBook("Mary"))

  // Add a pairing
  val newPairing = "Mary" -> 345
  val newPhonebook = phoneBook + newPairing
  println(newPhonebook)

  // functionals (map, flatMap, filter) on maps
  println(phoneBook.map(pairs => pairs._1.toLowerCase() -> pairs._2))

  // filterKeys
  println(phoneBook.filterKeys(_.startsWith("J")))

  // mapValues
  println(phoneBook.mapValues(_*10))
  println(phoneBook.mapValues("0235-"+_))

  // conversions to other collections
  println(phoneBook.toList)
  println(List(("Ming", 333)).toMap)

  // groupBy
  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim", "David")
  println(names.groupBy(name => name.charAt(0)))

  // Be careful with mapping keys
  val phoneBook2 = Map(("Jim", 555), "Ming" -> 789, ("JIM", 888))
  println(phoneBook2.map(pairs => pairs._1.toLowerCase() -> pairs._2))



}
