package be.spyproof.mystics.item.swords.hilt;

import be.spyproof.mystics.init.RegisterGodBlocks;
import be.spyproof.mystics.init.RegisterGodItems;
import be.spyproof.mystics.item.BaseItem;
import be.spyproof.mystics.item.entity.EntityFluidCrafting;
import be.spyproof.mystics.reference.Names;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by Spyproof.
 */
public class ItemEchidnaHilt extends BaseItem
{
    public ItemEchidnaHilt()
    {
        super();
        this.setUnlocalizedName(Names.Items.ECHIDNA_HILT);
    }

    @Override
    public String getItemStackDisplayName(ItemStack itemStack)
    {
        return "\u00A72" + super.getItemStackDisplayName(itemStack) + "\u00A7r";
    }

    @Override
    public boolean hasCustomEntity(ItemStack stack)
    {
        return true;
    }

    @Override
    public Entity createEntity(World world, Entity location, ItemStack itemstack)
    {
        EntityFluidCrafting entityFluidCrafting = new EntityFluidCrafting(world, location.posX, location.posY, location.posZ, itemstack, new ItemStack(RegisterGodItems.echidnaSword), RegisterGodBlocks.fluidBlockAcid);
        entityFluidCrafting.motionX = location.motionX;
        entityFluidCrafting.motionY = location.motionY;
        entityFluidCrafting.motionZ = location.motionZ;

        return entityFluidCrafting;
    }
}
