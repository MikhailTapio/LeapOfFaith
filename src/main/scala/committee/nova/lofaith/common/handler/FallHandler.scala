package committee.nova.lofaith.common.handler

import committee.nova.lofaith.common.config.CommonConfig
import cpw.mods.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.event.entity.living.LivingFallEvent

import scala.math.round

class FallHandler {
  @SubscribeEvent
  def onLivingFallEvent(event: LivingFallEvent): Unit = {
    val entity = event.entityLiving
    if (entity == null) return
    val world = entity.worldObj
    if (world.isRemote) return
    val pos = Array(round(entity.posX).intValue(), entity.posY.intValue() - 1, round(entity.posZ).intValue())
    val blocks = Array(
      world.getBlock(pos(0), pos(1), pos(2)), world.getBlock(pos(0) - 1, pos(1), pos(2)),
      world.getBlock(pos(0), pos(1), pos(2) - 1), world.getBlock(pos(0) - 1, pos(1), pos(2) - 1)
    )
    for (block <- blocks if CommonConfig.blocks.contains(block.getUnlocalizedName.substring(5))) event.setCanceled(true)
  }
}
