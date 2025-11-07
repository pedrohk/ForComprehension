object forComp10 {
  sealed trait Result[+A]

  case class SRight[A](value: A) extends Result[A]

  case class RLeft(error: String) extends Result[Nothing]

  def step1: Result[String] = SRight("Hello")

  def step2: Result[String] = SRight("World")

  def step3: Result[String] = RLeft("ForComp10: Failure")

  def process: Result[String] = {
    for {
      a <- step1
      b <- step2
    } yield a + " " + b
  }

  def processWithFailure: Result[String] = {
    for {
      a <- step1
      b <- step3
    } yield a + " " + b
  }

  extension [A](res: Result[A])
    def flatMap[B](f: A => Result[B]): Result[B] = {
      res match {
        case SRight(v) => f(v)
        case RLeft(e) => RLeft(e)
      }
    }
    def map[B](f: A => B): Result[B] = {
      res match {
        case SRight(v) => SRight(f(v))
        case RLeft(e) => RLeft(e)
      }
    }
}
