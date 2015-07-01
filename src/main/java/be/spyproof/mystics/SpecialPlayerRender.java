package be.spyproof.mystics;


import be.spyproof.mystics.potions.MysticPotions;
import be.spyproof.mystics.reference.Textures;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Spyproof.
 */
public class SpecialPlayerRender extends RenderPlayer
{
    private static final ResourceLocation stoneTextures = new ResourceLocation(Textures.Entities.STONE);

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityPlayer player)
    {
        if (player.isPotionActive(MysticPotions.freeze))
            return stoneTextures;

        return super.getEntityTexture(player);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return this.getEntityTexture((EntityPlayer)entity);
    }
}
