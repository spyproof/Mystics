package be.spyproof.mystics.item.swords;

import be.spyproof.mystics.item.bases.BoundSword;
import be.spyproof.mystics.potions.MysticPotions;
import be.spyproof.mystics.reference.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

/**
 * Created by Spyproof.
 */
public class ItemTestSword extends BoundSword
{
    public ItemTestSword()
    {
        super();
        this.setUnlocalizedName(Names.Items.TEST_SWORD);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        MysticPotions.freeze.onApply(player, new PotionEffect(MysticPotions.freeze.getId(), 100, 4));

        return itemStack;
    }
}
