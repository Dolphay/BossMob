package net.dolphay.indegame.boss;

import net.dolphay.indegame.Reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderIndeGame extends RenderLiving<EntityIndeGame>{
	
	private static final ResourceLocation BOSS_TEXTURES = new ResourceLocation(Reference.MODID+":textures/entity/boss.png");

    public RenderIndeGame(RenderManager manager)
    {
        super(manager, new ModelIndeGame(), .8f);   
    }
    
	@Override
	protected ResourceLocation getEntityTexture(EntityIndeGame entity) {
		return BOSS_TEXTURES;
	}

}
