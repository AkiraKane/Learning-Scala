package lectures.part4pm

import exercises.MyList.{Cons, Empty, MyList}

object AllThePatterns extends App{

  // 1 - Constants
  val x: Any = "scala"
  val constants = x match {
    case 1 => "a number"
    case "scala" => "the scala"
    case true => " the truth"
    case AllThePatterns => "a singleton object "
  }

  // 2 - match everything
  // 2.1 wildcard
  val matchAnything = x match {
    case _ =>
  }

  // 2.2 variable
  val matchVariable = x match {
    case something => s"I've found $something"
  }

  // 3 - tuples
  val aTuple = (1, 2)
  val matchATuple = aTuple match {
    case (1, 1) =>
    case (something, 2) => s"I've found $something"
  }

  val nestedTuple = (1, (2, 3))
  val matchANestedTuple = nestedTuple match {
    case(_, (2, v)) =>
  }
  // PMs can be nested

  // 4 - case classes - construct pattern
  // PMs can be nested with case class as well
  val aList: MyList[Int] = new Cons(1, new Cons(2, Empty))
  val matchAList = aList match {
    case Empty =>
    case Cons(head, Cons(subhead, subtail)) =>
  }

  // 5 - list patterns
  val aStandardList = List(1, 2, 3, 42)
  val standardListMatching = aStandardList match {
    case List(1, _, _, _) =>   // Extractor
    case List(1, _*) =>    // list of arbitrary length
    case 1 :: List()  =>   // infix pattern
    case List(1,2,3) :+ 43 =>  // infix pattern
  }

  // 6 - type specifiers
  val unknown: Any = 2
  val unknownMatch = unknown match {
    case list: List[Int] =>    // explicit type specifier
    case _ =>
  }

  // 7 - name biding
  val nameBindingMatch = aList match {
    case nonEmptyList @ Cons(_,_) =>   // name biding => use the name later (here
    case Cons(1, rest @ Cons(2, _)) => // name binding inside nested patterns
    case Empty =>
  }

  // 8 - multi-patterns
  val multipattern = aList match {
     case Empty | Cons(0, _) =>  // compound pattern (multi-pattern)
  }

  // 9 - if-guards
  val secondElementSpecial = aList match {
    case Cons(_, Cons(specialElement, _ )) if specialElement % 2 == 0 =>
  }


}
