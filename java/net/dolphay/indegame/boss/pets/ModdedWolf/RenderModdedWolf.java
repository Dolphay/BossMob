package net.dolphay.indegame.boss.pets.ModdedWolf;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelWolf;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerWolfCollar;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderModdedWolf extends RenderLiving<EntityModdedWolf>
{
    private static final ResourceLocation TAMED_WOLF_TEXTURES = new ResourceLocation("textures/entity/wolf/wolf_tame.png");

    public RenderModdedWolf(RenderManager p_i47187_1_)
    {
        super(p_i47187_1_, new ModelModdedWolf(), 0.5F);
        this.addLayer(new RenderModdedWolfCollar(this));
    }

    /**
     * Defines what float the third param in setRotationAngles of ModelBase is
     */
    protected float handleRotationFloat(EntityModdedWolf livingBase, float partialTicks)
    {
        return livingBase.getTailRotation();
    }

    /**
     * Renders the desired {@code T} type Entity.
     */
    public void doRender(EntityModdedWolf entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        if (entity.isWolfWet())
        {
            float f = entity.getBrightness() * entity.getShadingWhileWet(partialTicks);
            GlStateManager.color(f, f, f);
        }

        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityModdedWolf entity)
    {
    	return TAMED_WOLF_TEXTURES;
    }

}