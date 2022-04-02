package committee.nova.lofaith.common.handler

import committee.nova.lofaith.common.config.CommonConfig
import net.minecraft.util.BlockPos
import net.minecraftforge.event.entity.living.LivingFallEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

import scala.math.round

class FallHandler {
  @SubscribeEvent
  def onLivingFallEvent(event: LivingFallEvent): Unit = {
    val entity = event.entityLiving
    if (entity == null) return
    val world = entity.worldObj
    if (world.isRemote) return
    val pos = new BlockPos(round(entity.posX).intValue(), entity.posY, round(entity.posZ)).down()
    val blocks = Array(
      world.getBlockState(pos).getBlock,
      world.getBlockState(pos.west()).getBlock,
      world.getBlockState(pos.north()).getBlock,
      world.getBlockState(pos.west().north()).getBlock
    )
    for (block <- blocks if CommonConfig.blocks.contains(block.getUnlocalizedName.substring(5))) event.setCanceled(true)
  }
}
