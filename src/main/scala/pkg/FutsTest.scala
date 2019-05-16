package pkg

import org.slf4j.LoggerFactory

class FutsTest {
  val logger = LoggerFactory.getLogger(getClass.getName)

  def run = {
   logger.info(getClass.getName+".run")

  }

}
