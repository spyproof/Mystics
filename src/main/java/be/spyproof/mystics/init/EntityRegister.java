package be.spyproof.mystics.init;

import be.spyproof.mystics.Mystics;
import be.spyproof.mystics.entity.EntityTest;
import be.spyproof.mystics.entity.ItemEntityFireproof;
import be.spyproof.mystics.reference.IDs;
import be.spyproof.mystics.reference.Names;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.EntityList;

/**
 * Created by Spyproof.
 */
public class EntityRegister
{
    public static void mainRegistry()
    {
        registerEntity();
    }

    public static void registerEntity()
    {
        createEntity(ItemEntityFireproof.class, Names.Entities.ITEM_FIRE_IMMUNE, IDs.Entities.ITEM_FIRE_IMMUNE, 1);
        createEgg(createEntity(EntityTest.class, "TestMob", IDs.Mobs.ENTITY_TEST, 1), 0xFFFFFF, 0x000000);
    }

    public static int createEntity(Class entityClass, String name, int id, int updateFreq)
    {
        try
        {
            EntityRegistry.registerGlobalEntityID(entityClass, name, id);
            EntityRegistry.registerModEntity(entityClass, name, id, Mystics.instance, 32, updateFreq, true);
        } catch (IllegalArgumentException e)
        {
            id = EntityRegistry.findGlobalUniqueEntityId();
            EntityRegistry.registerGlobalEntityID(entityClass, name, id);
            EntityRegistry.registerModEntity(entityClass, name, id, Mystics.instance, 32, updateFreq, true);
        }
        return id;
    }

    private static void createEgg(int id, int solidColor, int spotColor)
    {
        EntityList.entityEggs.put(id, new EntityList.EntityEggInfo(id, solidColor, spotColor));
    }
}
