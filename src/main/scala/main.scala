

import scalanative.unsafe._
import scalanative.unsafe.CQuote
import scalanative.libc.stdio.printf

//import scalanative.llvm._
@extern
case class Hello(field1: CInt, field2: Float) //extends CStruct2[CInt, CFloat] {

//opaque type Hello = CStruct2[CInt, Float]
//
//object Hello:
//  given _tag: Tag[Hello] = Tag.materializeCStruct2Tag[CInt, Float]
//
//  def apply()(using Zone): Ptr[Hello] = scala.scalanative.unsafe.alloc[Hello](1)
//
//  def apply(field1: CInt, field2: Float)(using Zone): Ptr[Hello] =
//    val ____ptr = apply()
//    (!____ptr).field1 = field1
//    (!____ptr).field2 = field2
//    ____ptr
//
//  extension (struct: Hello)
//    def field1: CInt = struct._1
//    def field1_=(value: CInt): Unit = !struct.at1 = value
//    def field2: Float = struct._2
//    def field2_=(value: Float): Unit = !struct.at2 = value
@extern
object myapi {
  def add3(in: CLongLong): CLongLong = extern
  def add4(in: CLongLong): CLongLong = extern

  def resolve(h: Hello, i: CInt): CUnsignedInt = extern

  def resolveMuller(h: Hello, i: CInt): CUnsignedInt = extern
}

import myapi._
@main
def main(): Unit =

  printf(c"hello native %s!\n", c"world")
  println("Hello world!")
  val res = add3(-3L)
  assert(res == 0L)
  println(s"Add3 to -3 = $res")
  val hello = Hello(1,2.5)
  val res2 = resolve(hello,1)
  printf(c"res2 = %d\n", res2)
  val res3 = resolveMuller(hello,10)
  printf(c"res3 = %d\n", res3)
  val res4 = add4(-13L)

  println(s"Add3 to -13 = $res4")
  assert(res4 == -10L)
//  println(s"Is Windows: ${Platform.isWindows}")
//  println(s"Is Linux: ${Platform.isLinux}")
//  println(s"Is macOS: ${Platform.isMac}")

//
//@extern
//object meapi {
//  def add4(in: CLongLong): CLongLong = extern
//}

//object MainS {
//  import myapi._
//  def main(args: Array[String]): Unit = {
//    val res = add3(-3L)
//    assert(res == 0L)
//    println(s"Add3 to -3 = $res")
//  }
//}
