object forComp3 {
  def sumOptions(a: Option[Int], b: Option[Int]): Option[Int] =
    for
      x <- a
      y <- b
    yield x + y
}
