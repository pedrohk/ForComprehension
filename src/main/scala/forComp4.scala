object forComp4 {
  def multiply(rightA: Either[String, Int], rightB: Either[String, Int]): Either[String, Int] =
    for
      x <- rightA
      y <- rightB
    yield x * y
}
