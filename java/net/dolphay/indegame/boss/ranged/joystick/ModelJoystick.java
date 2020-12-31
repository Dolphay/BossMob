package net.dolphay.indegame.boss.ranged.joystick;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class ModelJoystick extends ModelBase {
	private final ModelRenderer Joystick;

	public ModelJoystick() {
		textureWidth = 16;
		textureHeight = 16;

		Joystick = new ModelRenderer(this);
		Joystick.setRotationPoint(0.0F, 0.0F, 0.0F);
		Joystick.cubeList.add(new ModelBox(Joystick, 0, 0, -1.0F, -6.0F, 0.0F, 1, 6, 1, 0.0F, false));
		Joystick.cubeList.add(new ModelBox(Joystick, 4, 0, -1.0F, -7.0F, 0.0F, 1, 1, 1, 0.0F, false));
		Joystick.cubeList.add(new ModelBox(Joystick, 8, 0, 0.0F, -6.0F, 0.0F, 1, 3, 1, 0.0F, false));
		Joystick.cubeList.add(new ModelBox(Joystick, 8, 8, -2.0F, -6.0F, 0.0F, 1, 3, 1, 0.0F, false));
		Joystick.cubeList.add(new ModelBox(Joystick, 0, 7, -1.0F, -6.0F, 1.0F, 1, 3, 1, 0.0F, false));
		Joystick.cubeList.add(new ModelBox(Joystick, 4, 4, -1.0F, -6.0F, -1.0F, 1, 3, 1, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		Joystick.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	
	protected float degToRad(float degrees)
    {
        return degrees * (float)Math.PI / 180 ;
    }
	
	public void setRotationAngles(EntityJoystick entityIn) {
		this.Joystick.rotateAngleX = (float) (Math.cos(entityIn.rotationYaw)*Math.cos(entityIn.rotationPitch));
		this.Joystick.rotateAngleY = (float) (Math.sin(entityIn.rotationYaw)*Math.cos(entityIn.rotationPitch));
		this.Joystick.rotateAngleZ = (float) (Math.sin(entityIn.rotationPitch));
	}
}