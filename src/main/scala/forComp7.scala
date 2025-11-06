object forComp7 {
  def combine(a: Either[String, String], b: Either[String, String]): Either[String, String] = {
    for {
      x <- a
      y <- b
    } yield s"$x $y"
  }
}
