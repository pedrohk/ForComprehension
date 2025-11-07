import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global

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


  def testComp5(): Unit = {
    val f1 = Future(10)
    val f2 = Future(20)
    val result = Await.result(forComp5.sumFutures(f1, f2), 1.second)
    assert(result == 30)
  }

  def testComp7(): Unit = {
    val res = forComp7.combine(Right("Hello"), Right("World"))
    assert(res == Right("Hello World"))
  }

  def testComp8(): Unit = {
    val res = forComp8.chain(List(Right("A"), Right("B")))
    assert(res == Right(List("A", "B")))
  }

  def testComp9(): Unit = {
    val res = forComp9.process(List("One", "", "Two"))
    assert(res == Right(List("One", "Two")))
  }

  def testComp10(): Unit = {
    println(forComp10.process)
    println(forComp10.processWithFailure)
  }

}

@main def runTests(): Unit =
  val tests = forCompTests()
  tests.testComp1()
  tests.testComp2()
  tests.testComp3()
  tests.testComp4()
  tests.testComp5()
  tests.testComp7()
  tests.testComp8()
  tests.testComp9()
  tests.testComp10()
  println(forComp6.compute(5, 2))
  println(forComp6.compute(-1, 2))
  println(forComp6.compute(5, 0))

  println("All tests passed.")
