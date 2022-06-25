object TestData {
  case class Person(name: String, age: Int)
}

class Test1 {

  import TestData.*  

  def in(fun: => Any): Any = fun

  in {
    Wrapper(Person("a", 1)).showTypeRepr 
  }
}