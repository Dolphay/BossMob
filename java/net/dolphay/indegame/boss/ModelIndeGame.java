package net.dolphay.indegame.boss;

import java.util.HashMap;

import net.dolphay.indegame.boss.EntityIndeGame.Attack;
import net.dolphay.indegame.boss.animations.Animation;
import net.dolphay.indegame.boss.animations.Animation.Part;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelIndeGame extends ModelBase {
	private final ModelRenderer Body;
	private final ModelRenderer Neck;
	private final ModelRenderer Head;
	private final ModelRenderer LegR;
	private final ModelRenderer FootR;
	private final ModelRenderer LegL;
	private final ModelRenderer FootL;
	private final ModelRenderer ShoulderR;
	private final ModelRenderer ArmR;
	private final ModelRenderer ShoulderL;
	private final ModelRenderer ArmL;
	private final float animSpeed = .9F;
	private final float timeDifference = 8;
	private final HashMap<ModelRenderer, Part> map;

	public ModelIndeGame() {
		map = new HashMap<>();
		
		textureWidth = 64;
		textureHeight = 64;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 4.0F, 0.0F);
		Body.cubeList.add(new ModelBox(Body, 0, 0, -5.0F, -8.0F, -3.0F, 10, 16, 6, 0.0F, false));
		map.put(Body, Part.Body);

		Neck = new ModelRenderer(this);
		Neck.setRotationPoint(0.0F, -7.5F, 0.0F);
		Body.addChild(Neck);
		Neck.cubeList.add(new ModelBox(Neck, 32, 10, -2.0F, -2.5F, -2.0F, 4, 4, 4, 0.0F, false));

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, -0.8F, 0.0F);
		Neck.addChild(Head);
		Head.cubeList.add(new ModelBox(Head, 0, 22, -4.0F, -8.2F, -4.0F, 8, 8, 8, 0.0F, false));

		LegR = new ModelRenderer(this);
		LegR.setRotationPoint(-2.4F, 7.0F, 0.3F);
		Body.addChild(LegR);
		LegR.cubeList.add(new ModelBox(LegR, 32, 32, -2.0F, -0.01F, -1.98F, 4, 8, 4, 0.0F, false));
		map.put(LegR, Part.RightLeg);

		FootR = new ModelRenderer(this);
		FootR.setRotationPoint(0.0F, 7.0F, 0.0F);
		LegR.addChild(FootR);
		FootR.cubeList.add(new ModelBox(FootR, 40, 44, -1.45F, 0.0F, -1.5F, 3, 6, 3, 0.0F, false));
		FootR.cubeList.add(new ModelBox(FootR, 0, 25, -1.45F, 3.9F, -2.5F, 3, 2, 1, 0.0F, false));
		map.put(FootR, Part.RightFoot);

		LegL = new ModelRenderer(this);
		LegL.setRotationPoint(2.4F, 7.0F, 0.3F);
		Body.addChild(LegL);
		LegL.cubeList.add(new ModelBox(LegL, 28, 18, -2.0F, 0.0F, -1.98F, 4, 8, 4, 0.0F, false));
		map.put(LegL, Part.LeftLeg);

		FootL = new ModelRenderer(this);
		FootL.setRotationPoint(0.0F, 7.0F, 0.0F);
		LegL.addChild(FootL);
		FootL.cubeList.add(new ModelBox(FootL, 44, 18, -1.35F, 0.0F, -1.5F, 3, 6, 3, 0.0F, false));
		FootL.cubeList.add(new ModelBox(FootL, 0, 22, -1.35F, 3.9F, -2.5F, 3, 2, 1, 0.0F, false));
		map.put(FootL, Part.LeftFoot);

		ShoulderR = new ModelRenderer(this);
		ShoulderR.setRotationPoint(-5.0F, -5.7F, 0.0F);
		Body.addChild(ShoulderR);
		ShoulderR.cubeList.add(new ModelBox(ShoulderR, 0, 38, -4.0F, -2.0F, -2.0F, 4, 6, 4, 0.0F, false));
		map.put(ShoulderR, Part.RightShoulder);

		ArmR = new ModelRenderer(this);
		ArmR.setRotationPoint(-2.3F, 2.7F, -0.1F);
		ShoulderR.addChild(ArmR);
		ArmR.cubeList.add(new ModelBox(ArmR, 28, 44, -1.2F, 0.0F, -1.4F, 3, 10, 3, 0.0F, false));
		map.put(ArmR, Part.RightArm);

		ShoulderL = new ModelRenderer(this);
		ShoulderL.setRotationPoint(5.0F, -5.7F, 0.0F);
		Body.addChild(ShoulderL);
		ShoulderL.cubeList.add(new ModelBox(ShoulderL, 32, 0, 0.0F, -2.0F, -2.0F, 4, 6, 4, 0.0F, false));
		map.put(ShoulderL, Part.LeftShoulder);

		ArmL = new ModelRenderer(this);
		ArmL.setRotationPoint(2.1F, 2.7F, 0.0F);
		ShoulderL.addChild(ArmL);
		ArmL.cubeList.add(new ModelBox(ArmL, 16, 38, -1.5F, 0.0F, -1.5F, 3, 10, 3, 0.0F, false));
		map.put(ArmL, Part.LeftArm);
	
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		Body.render(f5);
	}

	protected float radToDeg(float rad)
    {
        return rad * 180  / (float)Math.PI ;
    }
	
	protected float degToRad(float degrees)
    {
        return degrees * (float)Math.PI / 180 ;
    }
	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	
	public float[] getFrame(EntityIndeGame entity, Animation ani, float time, float[] values, Part part) {
		int curFrame = ani.getFrameFromTick(time);
		if(curFrame > -1) {
			int frameTime = ani.getFrameTime(curFrame)[1] - ani.getFrameTime(curFrame)[0];
			float frameInterval = time - ani.getFrameTime(curFrame)[0];
			float[] partF = ani.getPart(curFrame, part);
			float[] returnValues = new float[6];
			returnValues[0] = getInterval(degToRad(partF[0]), values[0], frameTime, frameInterval <= frameTime ? frameInterval : frameTime);
			returnValues[1] = getInterval(degToRad(partF[1]), values[1], frameTime, frameInterval <= frameTime ? frameInterval : frameTime);
			returnValues[2] = getInterval(degToRad(partF[2]), values[2], frameTime, frameInterval <= frameTime ? frameInterval : frameTime);
			return returnValues;
		}
		
		return new float[] {0F, 0F, 0F};
		
	}
	
	public float getInterval(float finished, float current, int totalIntervals, float frameInterval) {
		return (finished - current) / ((totalIntervals - frameInterval <= 0) ? 1 : totalIntervals - frameInterval);
	}
	
	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		Attack curAttack = ((EntityIndeGame) entityIn).getAttack();
		float curTick = ((EntityIndeGame)entityIn).ticksExisted - ((EntityIndeGame)entityIn).getAttackTime();
		
		for(ModelRenderer key: map.keySet()) {
			float[] rtAngles = getFrame((EntityIndeGame)entityIn, curAttack.getAnimation(), curTick, new float[] {key.rotateAngleX, key.rotateAngleY, key.rotateAngleZ}, map.get(key));
			key.rotateAngleX += rtAngles[0];
			key.rotateAngleY += rtAngles[1];
			key.rotateAngleZ += rtAngles[2];
		}
		
		if(curAttack == Attack.NONE && curTick > 10) {
			this.ShoulderR.rotateAngleX = MathHelper.cos(limbSwing*animSpeed + (float)Math.PI) * .8F * limbSwingAmount;
			this.ShoulderL.rotateAngleX = MathHelper.cos(limbSwing*animSpeed) * .8F * limbSwingAmount;

			this.ArmR.rotateAngleX = MathHelper.cos(limbSwing*animSpeed + (float)Math.PI) * .4F * limbSwingAmount;
			this.ArmL.rotateAngleX = MathHelper.cos(limbSwing*animSpeed) * .4F * limbSwingAmount;

			this.LegR.rotateAngleX = MathHelper.cos(limbSwing*animSpeed) * 1.6F * limbSwingAmount;
			this.LegL.rotateAngleX = MathHelper.cos(limbSwing*animSpeed + (float)Math.PI) * 1.6F * limbSwingAmount;

			this.FootR.rotateAngleX = MathHelper.cos(limbSwing*animSpeed) * .8F * limbSwingAmount;
			this.FootL.rotateAngleX = MathHelper.cos(limbSwing*animSpeed + (float)Math.PI) * .8F * limbSwingAmount;
		}
		
		this.Head.rotateAngleY= netHeadYaw * 0.017453292F;
		this.Neck.rotateAngleX= headPitch * 0.011635528F;
		
	}
}