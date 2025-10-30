object forComp1 { 
    def evensSquared(nums: List[Int]): List[Int] =
      for
        n <- nums if n % 2 == 0
      yield n * n
}
