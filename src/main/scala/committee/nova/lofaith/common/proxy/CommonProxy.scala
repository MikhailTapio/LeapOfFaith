package committee.nova.lofaith.common.proxy

import committee.nova.lofaith.common.config.CommonConfig
import committee.nova.lofaith.common.handler.FallHandler
import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPreInitializationEvent}
import net.minecraftforge.common.MinecraftForge

class CommonProxy {
  def preInit(event: FMLPreInitializationEvent): Unit = new CommonConfig(event)

  def init(event: FMLInitializationEvent): Unit = MinecraftForge.EVENT_BUS.register(new FallHandler)
}
