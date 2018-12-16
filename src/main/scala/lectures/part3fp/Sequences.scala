package lectures.part3fp

import scala.util.Random

object Sequences extends App{

/*
  trait Seq[+A]{
    def head: A
    def tail: Seq[A]
  }
*/


  // Sequences ///////////////////////////////////////////////////////
  // : A (very) general interface for data structure that
  // 1. have well defined order
  // 2. can be indexed

  // Supports various operations:
  // apply, iterator, length, reverse for indexing and iterating
  // concatenation, appending, prepending
  // a lot of others: grouping, sorting, zipping, searching, slicing

  val aSequence = Seq(1, 3, 2, 4)

  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(5,7,6))
  println(aSequence.sorted)

  // Ranges ////////////////////////////////////////////////////////
  val aRange: Seq[Int] = 1 to 10
  aRange.foreach(println)

  val aRange1: Seq[Int] = 1 until 10
  aRange1.foreach(println)

  (1 to 10).foreach(x => println("Hello"))

  // List //////////////////////////////////////////////////////////
  /*
  sealed abstract class List[+A]
  case object Nil extends List[Nothing]
  case class ::[A](val hd: A, val tl: List[A]) extends List[A]
  */

  // A LinearSeq immutable linked list
  // 1. head, tail, isEmpty methods are fast: o(1)
  // most operations are o(h)

  // Sealed - has two subtypes
  // 1. object Nil (empty)
  // 2. class ::

  val aList = List(1, 2, 3)
  val prepended = 42 :: aList
  println(prepended)

  val prepended1 = 42 +: aList :+ 78
  println(prepended1)

  val apple5 = List.fill(5)("apple")
  println(apple5)
  println(aList.mkString("-|-"))

  // Arrays /////////////////////////////////////////////
  /*
  final class Array[T]
    extends java.io.Serializable
    with java.lang.Cloneable
  */

  // The equivalent of simple Java arrays
  // 1. can be manually constructed with predefined lengths
  // 2. can be mutated (updated in place)
  // 3. are interoperable with Java's T[] arrays
  // 4. indexing is fast

  val numbers = Array(1, 2, 3, 4)
  val threeElements = Array.ofDim[Int](3)
  threeElements.foreach(println)

  // mutation
  numbers(2) = 0  // syntax sugar for numbers.update(2, 0)
  println(numbers.mkString(" "))

  // arrays and seq
  val numbersSeq: Seq[Int] = numbers // implicit conversion
  println(numbersSeq)

  // Vectors //////////////////////////////////////////////////////////
  /*
  final class Vector[+A]
  */

  // Important: The default implementation for immutable sequences
  // 1. effectively constant indexed read and write: O(log32(n))
  // 2. fast element addition: append / prepend
  // 3. implemented as a fixed-branched trie (branch factor 32)
  // 4. good performance for large sizes
  val noElements = Vector.empty
  val numbers1 = noElements :+ 1 :+ 2 :+ 3
  val modified = numbers1 updated (0, 7)
  println(numbers1)
  println(modified)

  val vector: Vector[Int] = Vector(1, 2, 3)
  println(vector)

  // vectors vs lists
  val maxRuns = 1000
  val maxCapacity = 1000000

  def getWriteTime(collection: Seq[Int]):Double = {
    val r = new Random
    val time = for{
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }

    time.sum * 1.0 / maxRuns
  }

  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  // List: advantages: Keeps reference to tail
  // disadvantages: updating an element in the middle takes long time
  println(getWriteTime(numbersList))

  // Vector: advantages: depth of the tree is small
  // disadvantages: needs to replace an entire 32-element chunk
  println(getWriteTime(numbersVector))

  // Vector takes much less time than List, which prove that vector is default implementation for immutable sequences

}
