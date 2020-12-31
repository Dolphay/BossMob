package net.dolphay.indegame.boss.ranged.controller;

import org.lwjgl.opengl.GL11;

import net.dolphay.indegame.boss.ranged.joystick.EntityJoystick;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class ModelController extends ModelBase {
	private final ModelRenderer Controller;
	private final ModelRenderer Triggers;
	private final ModelRenderer RHandle;
	private final ModelRenderer LHandle;
	private final ModelRenderer JoySticks;
	private final ModelRenderer RButtons;
	private final ModelRenderer LButtons;

	public ModelController() {
		textureWidth = 16;
		textureHeight = 16;

		Controller = new ModelRenderer(this);
		Controller.setRotationPoint(0.0F, 0.0F, 0.0F);
		Controller.cubeList.add(new ModelBox(Controller, 0, 7, -0.7F, -2.1F, -1.5F, 1, 2, 3, 0.0F, false));
		Controller.cubeList.add(new ModelBox(Controller, 0, 0, -1.0F, -3.0F, -2.0F, 1, 3, 4, 0.0F, false));

		Triggers = new ModelRenderer(this);
		Triggers.setRotationPoint(0.0F, 3.0F, 0.0F);
		setRotationAngle(Triggers, 0.0F, 0.0F, 0.0873F);
		Controller.addChild(Triggers);
		Triggers.cubeList.add(new ModelBox(Triggers, 10, 0, -1.0F, -6.0F, -1.9F, 1, 1, 1, 0.0F, false));
		Triggers.cubeList.add(new ModelBox(Triggers, 10, 2, -1.0F, -6.0F, 0.9F, 1, 1, 1, 0.0F, false));

		RHandle = new ModelRenderer(this);
		RHandle.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(RHandle, -0.0873F, 0.0F, 0.0F);
		Controller.addChild(RHandle);
		RHandle.cubeList.add(new ModelBox(RHandle, 6, 0, -1.0F, -2.0F, -3.0F, 1, 3, 1, 0.0F, false));

		LHandle = new ModelRenderer(this);
		LHandle.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(LHandle, 0.0873F, 0.0F, 0.0F);
		Controller.addChild(LHandle);
		LHandle.cubeList.add(new ModelBox(LHandle, 0, 0, -1.0F, -2.0F, 2.0F, 1, 3, 1, 0.0F, false));

		JoySticks = new ModelRenderer(this);
		JoySticks.setRotationPoint(0.0F, 0.0F, 0.0F);
		Controller.addChild(JoySticks);
		JoySticks.cubeList.add(new ModelBox(JoySticks, 9, 6, -1.3F, -1.2F, -1.8F, 1, 1, 1, 0.0F, false));
		JoySticks.cubeList.add(new ModelBox(JoySticks, 8, 10, -1.3F, -1.2F, 0.8F, 1, 1, 1, 0.0F, false));

		RButtons = new ModelRenderer(this);
		RButtons.setRotationPoint(-0.1F, -2.0F, -1.0F);
		setRotationAngle(RButtons, 0.7854F, 0.0F, 0.0F);
		Controller.addChild(RButtons);
		RButtons.cubeList.add(new ModelBox(RButtons, 5, 7, -1.0F, -0.7F, -0.5F, 1, 1, 1, 0.0F, false));

		LButtons = new ModelRenderer(this);
		LButtons.setRotationPoint(-0.1F, -2.0F, 1.0F);
		setRotationAngle(LButtons, -0.7854F, 0.0F, 0.0F);
		Controller.addChild(LButtons);
		LButtons.cubeList.add(new ModelBox(LButtons, 8, 8, -1.0F, -0.7F, -0.5F, 1, 1, 1, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		Controller.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	
	public void setRotationAngles(EntityController entityIn) {
		this.Controller.rotateAngleX = (float) (Math.cos(entityIn.rotationYaw)*Math.cos(entityIn.rotationPitch));
		this.Controller.rotateAngleY = (float) (Math.sin(entityIn.rotationYaw)*Math.cos(entityIn.rotationPitch));
		this.Controller.rotateAngleZ = (float) (Math.sin(entityIn.rotationPitch));
	}
}