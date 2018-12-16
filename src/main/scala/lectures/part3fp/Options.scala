package lectures.part3fp

import scala.util.Random

object Options extends App{
/*
  // An option is a wrapper for a value that might be present or not
  sealed abstract class Option[+A]
  case class Some[+A](x: A) extends Option[A]  // Some wraps a concrete value
  case object None extends Option[Nothing]   // None is a singleton for absent values

  */

  // Options are present in many places
  val map = Map("key" -> "value")
  println(map.get("key"))
  println(map.get("other"))

  val numbers = List(1, 2, 3)
  println(numbers.headOption)
  println(numbers.find(_ % 2 == 0))

  // Declare an Option
  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None

  println(myFirstOption)
  println(noOption)

  // work with unsafe API
  def unsafeMethod(): String = null
  // val result = Some(unsafeMethod())   // Wrong !
  val result = Option(unsafeMethod())  // Some or None
  println(result)

  // chained method
  def backupMethod(): String = "A valid result"
  val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod()))

  // Design unsafe API
  def betterUnsafeMethod(): Option[String] = None
  def betterBackupMethod(): Option[String] = Some("A valid result")

  val betterChainedResult = betterUnsafeMethod() orElse betterBackupMethod()

  // function on Options
  println(myFirstOption.isEmpty)
  println(noOption.isEmpty)

  println(myFirstOption.get)  // UNSAFE - Do not use this

  // map, flatMap, filter
  println(myFirstOption.map(_*2))
  println(myFirstOption.filter(_ > 10))
  println(myFirstOption.flatMap(x => Option(x * 10)))

  // for- comprehensions
  val config: Map[String, String] = Map(
    "host" -> "176.45.36.1",
    "port" -> "80"
  )

  class Connection{
    def connect = "connected"  // connect to some server
  }

  object Connection{
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] =
      if (random.nextBoolean()) Some(new Connection)
      else None
  }

  val host = config.get("host")
  val port = config.get("port")

  val connection = host.flatMap(h => port.flatMap(p => Connection.apply(h, p)))
  val connectionStatus = connection.map(c => c.connect)
  println(connectionStatus)
  connectionStatus.foreach(println)

  // chained calls
  config.get("host")
    .flatMap(host => config.get("port")
      .flatMap(port => Connection(host, port))
      .map(connection => connection.connect))
    .foreach(println)

  // for-comprehensions
  val forConnectionStatus = for{
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host, port)
  } yield connection.connect
  forConnectionStatus.foreach(println)




}
