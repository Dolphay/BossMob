package net.dolphay.indegame.boss.pets.ModdedParrot;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelModdedParrot extends ModelBase
{
    ModelRenderer body;
    ModelRenderer tail;
    ModelRenderer wingLeft;
    ModelRenderer wingRight;
    ModelRenderer head;
    ModelRenderer head2;
    ModelRenderer beak1;
    ModelRenderer beak2;
    ModelRenderer feather;
    ModelRenderer legLeft;
    ModelRenderer legRight;
    private ModelModdedParrot.State state = ModelModdedParrot.State.STANDING;

    public ModelModdedParrot()
    {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.body = new ModelRenderer(this, 2, 8);
        this.body.addBox(-1.5F, 0.0F, -1.5F, 3, 6, 3);
        this.body.setRotationPoint(0.0F, 16.5F, -3.0F);
        this.tail = new ModelRenderer(this, 22, 1);
        this.tail.addBox(-1.5F, -1.0F, -1.0F, 3, 4, 1);
        this.tail.setRotationPoint(0.0F, 21.07F, 1.16F);
        this.wingLeft = new ModelRenderer(this, 19, 8);
        this.wingLeft.addBox(-0.5F, 0.0F, -1.5F, 1, 5, 3);
        this.wingLeft.setRotationPoint(1.5F, 16.94F, -2.76F);
        this.wingRight = new ModelRenderer(this, 19, 8);
        this.wingRight.addBox(-0.5F, 0.0F, -1.5F, 1, 5, 3);
        this.wingRight.setRotationPoint(-1.5F, 16.94F, -2.76F);
        this.head = new ModelRenderer(this, 2, 2);
        this.head.addBox(-1.0F, -1.5F, -1.0F, 2, 3, 2);
        this.head.setRotationPoint(0.0F, 15.69F, -2.76F);
        this.head2 = new ModelRenderer(this, 10, 0);
        this.head2.addBox(-1.0F, -0.5F, -2.0F, 2, 1, 4);
        this.head2.setRotationPoint(0.0F, -2.0F, -1.0F);
        this.head.addChild(this.head2);
        this.beak1 = new ModelRenderer(this, 11, 7);
        this.beak1.addBox(-0.5F, -1.0F, -0.5F, 1, 2, 1);
        this.beak1.setRotationPoint(0.0F, -0.5F, -1.5F);
        this.head.addChild(this.beak1);
        this.beak2 = new ModelRenderer(this, 16, 7);
        this.beak2.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1);
        this.beak2.setRotationPoint(0.0F, -1.75F, -2.45F);
        this.head.addChild(this.beak2);
        this.feather = new ModelRenderer(this, 2, 18);
        this.feather.addBox(0.0F, -4.0F, -2.0F, 0, 5, 4);
        this.feather.setRotationPoint(0.0F, -2.15F, 0.15F);
        this.head.addChild(this.feather);
        this.legLeft = new ModelRenderer(this, 14, 18);
        this.legLeft.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1);
        this.legLeft.setRotationPoint(1.0F, 22.0F, -1.05F);
        this.legRight = new ModelRenderer(this, 14, 18);
        this.legRight.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1);
        this.legRight.setRotationPoint(-1.0F, 22.0F, -1.05F);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        this.body.render(scale);
        this.wingLeft.render(scale);
        this.wingRight.render(scale);
        this.tail.render(scale);
        this.head.render(scale);
        this.legLeft.render(scale);
        this.legRight.render(scale);
    }

    /**
     * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
     * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
     * "far" arms and legs can swing at most.
     */
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {
        float f = ageInTicks * 0.3F;
        this.head.rotateAngleX = headPitch * 0.017453292F;
        this.head.rotateAngleY = netHeadYaw * 0.017453292F;
        this.head.rotateAngleZ = 0.0F;
        this.head.rotationPointX = 0.0F;
        this.body.rotationPointX = 0.0F;
        this.tail.rotationPointX = 0.0F;
        this.wingRight.rotationPointX = -1.5F;
        this.wingLeft.rotationPointX = 1.5F;

        if (this.state != ModelModdedParrot.State.FLYING)
        {

            if (this.state == ModelModdedParrot.State.PARTY)
            {
                float f1 = MathHelper.cos((float)entityIn.ticksExisted);
                float f2 = MathHelper.sin((float)entityIn.ticksExisted);
                this.head.rotationPointX = f1;
                this.head.rotationPointY = 15.69F + f2;
                this.head.rotateAngleX = 0.0F;
                this.head.rotateAngleY = 0.0F;
                this.head.rotateAngleZ = MathHelper.sin((float)entityIn.ticksExisted) * 0.4F;
                this.body.rotationPointX = f1;
                this.body.rotationPointY = 16.5F + f2;
                this.wingLeft.rotateAngleZ = -0.0873F - ageInTicks;
                this.wingLeft.rotationPointX = 1.5F + f1;
                this.wingLeft.rotationPointY = 16.94F + f2;
                this.wingRight.rotateAngleZ = 0.0873F + ageInTicks;
                this.wingRight.rotationPointX = -1.5F + f1;
                this.wingRight.rotationPointY = 16.94F + f2;
                this.tail.rotationPointX = f1;
                this.tail.rotationPointY = 21.07F + f2;
                return;
            }

            this.legLeft.rotateAngleX += MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
            this.legRight.rotateAngleX += MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        }

        this.head.rotationPointY = 15.69F + f;
        this.tail.rotateAngleX = 1.015F + MathHelper.cos(limbSwing * 0.6662F) * 0.3F * limbSwingAmount;
        this.tail.rotationPointY = 21.07F + f;
        this.body.rotationPointY = 16.5F + f;
        this.wingLeft.rotateAngleZ = -0.0873F - ageInTicks;
        this.wingLeft.rotationPointY = 16.94F + f;
        this.wingRight.rotateAngleZ = 0.0873F + ageInTicks;
        this.wingRight.rotationPointY = 16.94F + f;
        this.legLeft.rotationPointY = 22.0F + f;
        this.legRight.rotationPointY = 22.0F + f;
    }

    /**
     * Used for easily adding entity-dependent animations. The second and third float params here are the same second
     * and third as in the setRotationAngles method.
     */
    public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTickTime)
    {
        this.feather.rotateAngleX = -0.2214F;
        this.body.rotateAngleX = 0.4937F;
        this.wingLeft.rotateAngleX = -((float)Math.PI * 2F / 9F);
        this.wingLeft.rotateAngleY = -(float)Math.PI;
        this.wingRight.rotateAngleX = -((float)Math.PI * 2F / 9F);
        this.wingRight.rotateAngleY = -(float)Math.PI;
        this.legLeft.rotateAngleX = -0.0299F;
        this.legRight.rotateAngleX = -0.0299F;
        this.legLeft.rotationPointY = 22.0F;
        this.legRight.rotationPointY = 22.0F;

        if (entitylivingbaseIn instanceof EntityModdedParrot)
        {
            EntityModdedParrot EntityModdedParrot = (EntityModdedParrot)entitylivingbaseIn;
            if (EntityModdedParrot.isFlying())
            {
                this.legLeft.rotateAngleX += ((float)Math.PI * 2F / 9F);
                this.legRight.rotateAngleX += ((float)Math.PI * 2F / 9F);
                this.state = ModelModdedParrot.State.FLYING;
            }
            else
            {
                this.state = ModelModdedParrot.State.STANDING;
            }

            this.legLeft.rotateAngleZ = 0.0F;
            this.legRight.rotateAngleZ = 0.0F;
        }
    }

    @SideOnly(Side.CLIENT)
    static enum State
    {
        FLYING,
        STANDING,
        SITTING,
        PARTY;
    }
}