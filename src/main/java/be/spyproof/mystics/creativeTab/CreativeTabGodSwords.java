package be.spyproof.mystics.creativeTab;

import be.spyproof.mystics.init.RegisterGodItems;
import be.spyproof.mystics.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by Spyproof.
 */
public class CreativeTabGodSwords
{
    public static final CreativeTabs GS_Tab = new CreativeTabs(Reference.MOD_ID) {
        @Override
        public Item getTabIconItem()
        {
            return RegisterGodItems.zeusSword;
        }

        @Override
        public String getTabLabel()
        {
            return Reference.MOD_ID;
        }
    };
}
