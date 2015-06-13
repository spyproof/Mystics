package be.spyproof.mystics.item.craftingcomponents;

import be.spyproof.mystics.item.bases.BaseDamagedItem;
import be.spyproof.mystics.reference.Names;
import net.minecraft.item.ItemStack;

/**
 * Created by Spyproof.
 */
public class Crystals extends BaseDamagedItem
{
    public Crystals()
    {
        super(Names.Items.CRYSTAL, Names.Items.ORE_SUBTYPES);
    }

    @Override
    public String getItemStackDisplayName(ItemStack itemStack)
    {
        return Names.Colors.SUBTYPES[itemStack.getItemDamage()] + super.getItemStackDisplayName(itemStack);
    }
}
