package be.spyproof.mystics.item.armor;

import be.spyproof.mystics.item.bases.BoundArmor;
import be.spyproof.mystics.reference.Names;
import be.spyproof.mystics.reference.Textures;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Spyproof.
 */
public class ZeusArmor extends BoundArmor
{
    public ZeusArmor(ItemArmor.ArmorMaterial material, int armorType)
    {
        super(material, armorType);
        switch (armorType)
        {
            case 0:
                this.setUnlocalizedName(Names.Items.ZEUS_HELMET);
                break;
            case 1:
                this.setUnlocalizedName(Names.Items.ZEUS_CHESTPLATE);
                break;
            case 2:
                this.setUnlocalizedName(Names.Items.ZEUS_LEGGINGS);
                break;
            case 3:
                this.setUnlocalizedName(Names.Items.ZEUS_BOOTS);
                break;
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean b)
    {
        super.addInformation(itemStack, player, list, b);
        addHiddenTooltip(list, "\u00A7fSet bonus:");
        addHiddenTooltip(list, Names.Colors.ZEUS + "Knock back enemies");
        addHiddenTooltip(list, Names.Colors.ZEUS + "when being hit");
    }

    @Override
    public String getItemStackDisplayName(ItemStack itemStack)
    {
        return Names.Colors.ZEUS + super.getItemStackDisplayName(itemStack);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        if (armorType == 2)
            return Textures.RESOURCE_PREFIX + "textures/armor/ZeusArmor2.png";
        else
            return Textures.RESOURCE_PREFIX + "textures/armor/ZeusArmor1.png";
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {
        super.onArmorTick(world, player, itemStack);
    }
}
