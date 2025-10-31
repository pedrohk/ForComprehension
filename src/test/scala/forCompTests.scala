import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, Future}

class forCompTests {
  def testComp1(): Unit =
    val result = forComp1.evensSquared(List(1, 2, 3, 4, 5, 6))
    assert(result == List(4, 16, 36))

  def testComp2(): Unit =
    val result = forComp2.combinations(List("apple", "banana"), List("red", "yellow"))
    assert(result == List("red apple", "yellow apple", "red banana", "yellow banana"))

  def testComp3(): Unit =
    val result = forComp3.sumOptions(Some(10), Some(5))
    assert(result.contains(15))

  def testComp4(): Unit =
    val result = forComp4.multiply(Right(4), Right(2))
    assert(result == Right(8))


  def testComp5(): Unit =
  val f1 = Future(10)
  val f2 = Future(20)
  val result = Await.result(forComp5.sumFutures(f1, f2), 1.second)
  assert(result == 30)

}

@main def runTests(): Unit =
  val tests = forCompTests()
  tests.testComp1()
  tests.testComp2()
  tests.testComp3()
  tests.testComp4()
  tests.testComp5()
  println("All tests passed.")
