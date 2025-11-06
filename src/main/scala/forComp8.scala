object forComp8 {
  def chain(values: List[Either[String, String]]): Either[String, List[String]] = {
    for {
      v1 <- values.headOption.getOrElse(Left("empty"))
      rest <- Right(values.tail.flatMap(_.toOption))
    } yield v1 :: rest
  }
}
