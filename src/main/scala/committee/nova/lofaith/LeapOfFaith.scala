package committee.nova.lofaith

import committee.nova.lofaith.LeapOfFaith.proxy
import committee.nova.lofaith.common.proxy.CommonProxy
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.event.{FMLInitializationEvent, FMLPreInitializationEvent}
import net.minecraftforge.fml.common.{Mod, SidedProxy}

object LeapOfFaith {
  final val VERSION = "1.0"
  final val MODID = "lofaith"
  @SidedProxy(serverSide = "committee.nova.lofaith.common.proxy.CommonProxy")
  val proxy: CommonProxy = new CommonProxy
  @Mod.Instance(LeapOfFaith.MODID)
  var instance: LeapOfFaith = _
}

@Mod(modid = LeapOfFaith.MODID, version = LeapOfFaith.VERSION, acceptedMinecraftVersions = "[1.9,)")
class LeapOfFaith {
  LeapOfFaith.instance = this

  @EventHandler
  def preInit(event: FMLPreInitializationEvent): Unit = proxy.preInit(event)

  @EventHandler
  def init(event: FMLInitializationEvent): Unit = proxy.init(event)
}