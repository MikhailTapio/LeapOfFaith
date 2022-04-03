package committee.nova.lofaith.common.proxy

import committee.nova.lofaith.common.config.CommonConfig
import committee.nova.lofaith.common.handler.FallHandler
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.event.{FMLInitializationEvent, FMLPreInitializationEvent}

class CommonProxy {
  def preInit(event: FMLPreInitializationEvent): Unit = new CommonConfig(event)

  def init(event: FMLInitializationEvent): Unit = MinecraftForge.EVENT_BUS.register(new FallHandler)
}
