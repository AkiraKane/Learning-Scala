package lectures.part4pm

import exercises.MyList

object Cons {
  def unapply(value: MyList.MyList[Int]): Option[(Int, Any)] = ???
}
