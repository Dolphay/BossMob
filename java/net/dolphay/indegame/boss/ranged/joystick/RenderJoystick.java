package net.dolphay.indegame.boss.ranged.joystick;

import org.lwjgl.opengl.GL11;

import net.dolphay.indegame.Reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderJoystick extends Render<EntityJoystick>{
	
	private static final ResourceLocation texture = new ResourceLocation(Reference.MODID+":textures/entity/joystick.png");
	private ModelJoystick model;

    public RenderJoystick(RenderManager manager)
    {
    	super(manager);
    	model = new ModelJoystick();
    }
  
    protected void preRenderCallbackBoss(EntityJoystick entity, float f)
    {
    	
    }
    
	@Override
	protected ResourceLocation getEntityTexture(EntityJoystick entity) {
		return texture;
	}
	
	@Override
	public void doRender(EntityJoystick entity, double x, double y, double z, float yaw, float partialTick) {
		GL11.glPushMatrix();
		bindTexture(texture);
		GL11.glTranslated(x, y, z);
		model.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
		this.model.setRotationAngles(entity);
	}

}
