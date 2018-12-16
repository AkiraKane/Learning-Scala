package lectures.part2oop

object PackagingAndImports {

  // package members are accessible by their simple name

  // import the package

  // package object (same name as the package name where it reside in)

  // 1. Use fully qualified name
  import java.sql.Date

  // 2. Use alias
  import java.sql.{Date => SqlDate}

  // Default Imports
  // java.lang - String, Object, Exception
  // scala - Int, Nothing, Function
  // scala.Predef - println, ???
}
