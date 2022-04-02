package committee.nova.lofaith.common.config

import committee.nova.lofaith.common.config.CommonConfig._
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.common.config.Configuration
import org.apache.logging.log4j.Logger

object CommonConfig {
  var blocks: Array[String] = _
  private var config: Configuration = _
  private var logger: Logger = _

  def getLogger: Logger = logger
}

class CommonConfig(event: FMLPreInitializationEvent) {
  logger = event.getModLog
  config = new Configuration(event.getSuggestedConfigurationFile)
  config.load()
  load()

  def load(): Unit = {
    blocks = config.getStringList("soft_blocks", Configuration.CATEGORY_GENERAL, Array("hayBlock", "exampleBlock"), "blocks which won't hurt the falling players")
    config.save()
  }
}
