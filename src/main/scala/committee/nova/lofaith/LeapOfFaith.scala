package committee.nova.lofaith

import committee.nova.lofaith.LeapOfFaith.proxy
import committee.nova.lofaith.common.proxy.CommonProxy
import cpw.mods.fml.common.Mod.EventHandler
import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPreInitializationEvent}
import cpw.mods.fml.common.{Mod, SidedProxy}

object LeapOfFaith {
  final val VERSION = "1.0"
  final val MODID = "lofaith"
  @SidedProxy(serverSide = "committee.nova.lofaith.common.proxy.CommonProxy")
  val proxy: CommonProxy = new CommonProxy
  @Mod.Instance(LeapOfFaith.MODID)
  var instance: LeapOfFaith = _
}

@Mod(modid = LeapOfFaith.MODID, version = LeapOfFaith.VERSION)
class LeapOfFaith {
  LeapOfFaith.instance = this

  @EventHandler
  def preInit(event: FMLPreInitializationEvent): Unit = proxy.preInit(event)

  @EventHandler
  def init(event: FMLInitializationEvent): Unit = proxy.init(event)
}