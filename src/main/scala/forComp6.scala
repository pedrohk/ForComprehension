
sealed trait SResult[+E, +A]

case class SRight[A](value: A) extends SResult[Nothing, A]

case class SLeft[E](error: E) extends SResult[E, Nothing]

object forComp6 {


  extension [E, A](res: SResult[E, A]) {
    def map[B](f: A => B): SResult[E, B] = res match {
      case SRight(value) => SRight(f(value))
      case SLeft(err) => SLeft(err)
    }

    def flatMap[B](f: A => SResult[E, B]): SResult[E, B] = res match {
      case SRight(value) => f(value)
      case SLeft(err) => SLeft(err)
    }
  }

  def compute(x: Int, y: Int): SResult[Throwable, Int] = {
    for {
      a <- if (x > 0) {
        SRight(x * 2)
      } else {
        SLeft(new IllegalArgumentException("x must be positive"))
      }

      b <- if (y != 0) {
        SRight(y + 10)
      } else {
        SLeft(new ArithmeticException("y cannot be zero"))
      }
      result <- SRight(a / y)
    } yield result
  }
}
