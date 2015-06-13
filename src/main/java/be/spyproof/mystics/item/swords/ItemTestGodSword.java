package be.spyproof.mystics.item.swords;

import be.spyproof.mystics.item.bases.BoundSword;
import be.spyproof.mystics.reference.Names;
import be.spyproof.mystics.util.NBTHelper;
import be.spyproof.mystics.util.PlayerHelper;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

/**
 * Created by Spyproof.
 */
public class ItemTestGodSword extends BoundSword
{
    public ItemTestGodSword()
    {
        super();
        this.setUnlocalizedName(Names.Items.TEST_SWORD);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        try {
            super.onItemRightClick(itemStack, world, player);
        } catch (IllegalArgumentException e) {
            return itemStack;
        }

        MovingObjectPosition mop = PlayerHelper.getLookPos(player);

        if (!player.isSneaking() && NBTHelper.getBoolean(itemStack, "isActive") && NBTHelper.isOwner(itemStack, player))
            world.spawnEntityInWorld(new EntityLightningBolt(world, mop.blockX, mop.blockY, mop.blockZ));

        return itemStack;
    }
}
