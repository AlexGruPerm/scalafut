package pkg

import org.slf4j.LoggerFactory

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

class FutsTest {
  val logger = LoggerFactory.getLogger(getClass.getName)

  def job(n: Int,seq :Seq[Int]) = Future {
    val res = seq.sum
    println("JOB n="+n+" - "+res)
    res
  }

  def run = {
   logger.info(getClass.getName+".run")
    val numParallFut :Int = 6

    val testData :Seq[Int] = 1.to(10000000).by(1)

    val parts :List[Seq[Int]] = testData.grouped(testData.size/(numParallFut)).toList

    println("parts.size="+parts.size+" parts(1).size="+parts(1).size)

    //For List of Futures
    val fs = Future.sequence(1.to(numParallFut).by(1).map(elm => job(elm,parts(elm-1))))

    fs onComplete {
      case Success(listOfResults) => println("TotalSum = "+listOfResults.sum)
      case Failure(t) => println("An error has occurred: " + t.getMessage)
    }

    //For single Future
    val f1 = job(1,parts(0))

    f1 onComplete {
      case Success(listOfResults) => println("TotalSum = "+listOfResults)
      case Failure(t) => println("An error has occurred: " + t.getMessage)
    }


    logger.info(getClass.getName+".run END totalSum=X")
  }

}

/*

TotalSum = 2044260026

*/

