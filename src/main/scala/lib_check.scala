//import _root_.scala.scalanative.unsafe.*
//import _root_.scala.scalanative.unsigned.*
//import _root_.scala.scalanative.libc.*
//import _root_.scala.scalanative.*
//
//object structs:
//  import _root_.lib_check.structs.*
//  /**
//   * [bindgen] header: E:\code\scala-native-muller\src\main\resources\scala-native\header.h
//  */
//  opaque type Hello = CStruct2[CInt, Float]
//  object Hello:
//    given _tag: Tag[Hello] = Tag.materializeCStruct2Tag[CInt, Float]
//    def apply()(using Zone): Ptr[Hello] = scala.scalanative.unsafe.alloc[Hello](1)
//    def apply(field1 : CInt, field2 : Float)(using Zone): Ptr[Hello] =
//      val ____ptr = apply()
//      (!____ptr).field1 = field1
//      (!____ptr).field2 = field2
//      ____ptr
//    extension (struct: Hello)
//      def field1 : CInt = struct._1
//      def field1_=(value: CInt): Unit = !struct.at1 = value
//      def field2 : Float = struct._2
//      def field2_=(value: Float): Unit = !struct.at2 = value
//
//
//@extern
//private[lib_check] object extern_functions:
//  import _root_.lib_check.structs.*
//  private[lib_check] def __sn_wrap_lib_check_resolve(h : Ptr[Hello], i : CInt): CUnsignedInt = extern
//
//  private[lib_check] def __sn_wrap_lib_check_resolveMuller(h : Ptr[Hello], i : CInt): CUnsignedInt = extern
//
//
//object functions:
//  import _root_.lib_check.structs.*
//  import extern_functions.*
//  export extern_functions.*
//
//  /**
//   * [bindgen] header: E:\code\scala-native-muller\src\main\resources\scala-native\header.h
//  */
//  def resolve(h : Ptr[Hello], i : CInt): CUnsignedInt =
//    __sn_wrap_lib_check_resolve(h, i)
//
//  /**
//   * [bindgen] header: E:\code\scala-native-muller\src\main\resources\scala-native\header.h
//  */
//  def resolve(h : Hello, i : CInt)(using Zone): CUnsignedInt =
//    val __ptr_0: Ptr[Hello] = alloc[Hello](1)
//    !(__ptr_0 + 0) = h
//    __sn_wrap_lib_check_resolve((__ptr_0 + 0), i)
//
//  /**
//   * [bindgen] header: E:\code\scala-native-muller\src\main\resources\scala-native\header.h
//  */
//  def resolveMuller(h : Ptr[Hello], i : CInt): CUnsignedInt =
//    __sn_wrap_lib_check_resolveMuller(h, i)
//
//  /**
//   * [bindgen] header: E:\code\scala-native-muller\src\main\resources\scala-native\header.h
//  */
//  def resolveMuller(h : Hello, i : CInt)(using Zone): CUnsignedInt =
//    val __ptr_0: Ptr[Hello] = alloc[Hello](1)
//    !(__ptr_0 + 0) = h
//    __sn_wrap_lib_check_resolveMuller((__ptr_0 + 0), i)
//
//object types:
//  export _root_.lib_check.structs.*
//
//object all:
//  export _root_.lib_check.structs.Hello
//  export _root_.lib_check.functions.resolve
//  export _root_.lib_check.functions.resolveMuller