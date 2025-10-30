object forComp2 {
  def combinations(fruits: List[String], colors: List[String]): List[String] =
    for
      f <- fruits
      c <- colors
    yield s"$c $f"
}
