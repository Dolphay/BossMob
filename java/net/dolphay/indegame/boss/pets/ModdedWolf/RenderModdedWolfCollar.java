package net.dolphay.indegame.boss.pets.ModdedWolf;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderWolf;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderModdedWolfCollar implements LayerRenderer<EntityModdedWolf>
{
    private static final ResourceLocation WOLF_COLLAR = new ResourceLocation("textures/entity/wolf/wolf_collar.png");
    private final RenderModdedWolf wolfRenderer;

    public RenderModdedWolfCollar(RenderModdedWolf renderModdedWolf)
    {
        this.wolfRenderer = renderModdedWolf;
    }

    public void doRenderLayer(EntityModdedWolf entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        if (!entitylivingbaseIn.isInvisible())
        {
            this.wolfRenderer.bindTexture(WOLF_COLLAR);
            float[] afloat = entitylivingbaseIn.getCollarColor().getColorComponentValues();
            GlStateManager.color(afloat[0], afloat[1], afloat[2]);
            this.wolfRenderer.getMainModel().render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        }
    }

    public boolean shouldCombineTextures()
    {
        return true;
    }
}