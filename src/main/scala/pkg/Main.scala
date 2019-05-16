package pkg

import org.slf4j.LoggerFactory
import scala.concurrent.ExecutionContext.Implicits.global

object Main extends App {
  val logger = LoggerFactory.getLogger(getClass.getName)
  logger.info(" >>>>>>>>>>>>>>>> ")
  val t1 = System.currentTimeMillis
  val ft = new FutsTest
  ft.run
  val t2 = System.currentTimeMillis
  logger.info("Duration - "+(t2 - t1) + " msecs.")
  logger.info(" <<<<<<<<<<<<<<<< ")
  Thread.sleep(7000)
}
