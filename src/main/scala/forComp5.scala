import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global

object forComp5 {
    def sumFutures(a: Future[Int], b: Future[Int]): Future[Int] =
      for
        x <- a
        y <- b
      yield x + y
}
