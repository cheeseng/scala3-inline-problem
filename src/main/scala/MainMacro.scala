import scala.quoted.*

case class Wrapper[T](t: T) extends MainMacro[T]

trait MainMacro[U] { this: Wrapper[U] => 
  inline def showTypeRepr: String = ${ MainMacro.showTypeReprImpl[U]}
}

object MainMacro {
  def showTypeReprImpl[U: Type](using Quotes): Expr[String] = {
      import quotes.reflect.*

      val tpe = TypeRepr.of[U]

      '{${Expr(tpe.toString)}}
  }
}