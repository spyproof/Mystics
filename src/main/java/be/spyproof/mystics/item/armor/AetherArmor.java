package be.spyproof.mystics.item.armor;

import be.spyproof.mystics.item.bases.BoundArmor;
import be.spyproof.mystics.potions.MysticPotions;
import be.spyproof.mystics.reference.Names;
import be.spyproof.mystics.reference.Textures;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Spyproof.
 */
public class AetherArmor extends BoundArmor
{
    public AetherArmor(ItemArmor.ArmorMaterial material, int armorType)
    {
        super(material, armorType);
        switch (armorType)
        {
            case 0:
                this.setUnlocalizedName(Names.Items.AETHER_HELMET);
                break;
            case 1:
                this.setUnlocalizedName(Names.Items.AETHER_CHESTPLATE);
                break;
            case 2:
                this.setUnlocalizedName(Names.Items.AETHER_LEGGINGS);
                break;
            case 3:
                this.setUnlocalizedName(Names.Items.AETHER_BOOTS);
                break;
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean b)
    {
        super.addInformation(itemStack, player, list, b);
        addHiddenTooltip(list, "\u00A7fSet bonus:");
        addHiddenTooltip(list, Names.Colors.AETHER + "No fall damage");
        addHiddenTooltip(list, Names.Colors.AETHER + "and can fly");
    }



    @Override
    public String getItemStackDisplayName(ItemStack itemStack)
    {
        return Names.Colors.AETHER + super.getItemStackDisplayName(itemStack);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        if (armorType == 2)
            return Textures.RESOURCE_PREFIX + "textures/armor/AetherArmor2.png";
        else
            return Textures.RESOURCE_PREFIX + "textures/armor/AetherArmor1.png";
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {
        super.onArmorTick(world, player, itemStack);
        int pieces = 0;

        for (int i = 0; i < 4; i++)
        {
            Item armor = null;
            try {
                armor = (player.getCurrentArmor(i).getItem());
                if (armor == null)
                    return;
            } catch (NullPointerException e) {
                return;
            }

            if (armor instanceof AetherArmor)
                pieces++;
        }

        if (pieces == 4)
            MysticPotions.fly.onApply(player, new PotionEffect(MysticPotions.fly.getId(), 5, 0));
    }
}
