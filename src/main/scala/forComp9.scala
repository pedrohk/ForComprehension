object forComp9 {
  def process(xs: List[String]): Either[String, List[String]] = {
    for {
      valid <- Right(xs.map(validate))
      combined <- Right(valid.collect { case Right(v) => v })
    } yield combined
  }

  def validate(x: String): Either[String, String] = {
    if x.nonEmpty then Right(x) else Left("empty")
  }
}
