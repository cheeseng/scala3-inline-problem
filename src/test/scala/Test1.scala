object TestData {
  case class Person(name: String, age: Int)
}

class Test1 {

  import TestData.*  

  // Notice that without inline does not work also
  inline def in(fun: => Any): Any = fun

  in {
    Wrapper(Person("a", 1)).showTypeRepr 
  }
}