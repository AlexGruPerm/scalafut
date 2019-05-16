package pkg

import org.slf4j.LoggerFactory

object Main extends App {
  val logger = LoggerFactory.getLogger(getClass.getName)
  logger.info(" >>>>>>>>>>>>>>>> ")

  val ft = new FutsTest
  ft.run

  logger.info(" <<<<<<<<<<<<<<<< ")
}
