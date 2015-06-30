package be.spyproof.mystics.init;

import be.spyproof.mystics.Mystics;
import be.spyproof.mystics.entity.ItemEntityFireproof;
import be.spyproof.mystics.entity.ItemEntityThrowable;
import be.spyproof.mystics.reference.IDs;
import be.spyproof.mystics.reference.Names;
import cpw.mods.fml.common.registry.EntityRegistry;

/**
 * Created by Spyproof.
 */
public class RegisterGodEntities
{
    public RegisterGodEntities()
    {
        EntityRegistry.registerModEntity(ItemEntityFireproof.class, Names.Entities.ITEM_FIRE_IMMUNE, IDs.Entities.ITEM_FIRE_IMMUNE, Mystics.instance, 16, 20, true);
        EntityRegistry.registerModEntity(ItemEntityThrowable.class, Names.Entities.ITEM_THROWABLE, IDs.Entities.ITEM_THROWABLE, Mystics.instance, 16, 20, true);
    }
}
