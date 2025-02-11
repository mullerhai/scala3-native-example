

import scalanative.unsafe._
//import scalanative.llvm._
@extern
object myapi {
  def add3(in: CLongLong): CLongLong = extern
}

object Main {
  import myapi._
  def main(args: Array[String]): Unit = {
    val res = add3(-3L)
    assert(res == 0L)
    println(s"Add3 to -3 = $res")
  }
}
@main
def main(): Unit =
  println("Hello world!")
//  println(s"Is Windows: ${Platform.isWindows}")
//  println(s"Is Linux: ${Platform.isLinux}")
//  println(s"Is macOS: ${Platform.isMac}")

