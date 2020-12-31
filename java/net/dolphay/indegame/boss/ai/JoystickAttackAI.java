package net.dolphay.indegame.boss.ai;

import net.dolphay.indegame.boss.EntityIndeGame;
import net.dolphay.indegame.boss.EntityIndeGame.Attack;
import net.dolphay.indegame.boss.animations.AnimationManager;
import net.dolphay.indegame.boss.pets.EntityPet;
import net.dolphay.indegame.boss.pets.ModdedWolf.EntityModdedWolf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.event.entity.player.AttackEntityEvent;

public class JoystickAttackAI extends EntityAIBase{
	
	private final EntityIndeGame entity;
    private final IRangedAttackMob rangedAttackEntityHost;
    private EntityLivingBase attackTarget;
    private int rangedAttackTime;
    private final double entityMoveSpeed;
    private int seeTime;
    private int delay;
    private final int attackIntervalMin;
    private final int maxRangedAttackTime;
    private final float attackRadius;
    private final float maxAttackDistance;

    public JoystickAttackAI(EntityIndeGame attacker, double movespeed, int maxAttackTime, float maxAttackDistanceIn, int delay)
    {
        this(attacker, movespeed, maxAttackTime, maxAttackTime, maxAttackDistanceIn, delay);
    }

    public JoystickAttackAI(EntityIndeGame attacker, double movespeed, int p_i1650_4_, int maxAttackTime, float maxAttackDistanceIn, int delay)
    {
    	super();
        this.rangedAttackTime = -1;

        if (!(attacker instanceof EntityLivingBase))
        {
            throw new IllegalArgumentException("ArrowAttackGoal requires Mob implements RangedAttackMob");
        }
        else
        {
            this.rangedAttackEntityHost = attacker;
            this.entity = attacker;
            this.entityMoveSpeed = movespeed;
            this.attackIntervalMin = p_i1650_4_;
            this.maxRangedAttackTime = maxAttackTime;
            this.attackRadius = maxAttackDistanceIn;
            this.maxAttackDistance = maxAttackDistanceIn * maxAttackDistanceIn;
            this.setMutexBits(3);
            this.delay = delay;
        }
    }

	@Override
	public boolean shouldExecute() {
		return entity.getAttack() == Attack.NONE && this.entity.getAttackTarget() != null &&
				(entity.getDelay(Attack.JOYSTICK) != null ? entity.getDelay(Attack.JOYSTICK).intValue() < entity.ticksExisted : true);
	}

	public void startExecuting() {
		super.startExecuting();
		entity.setAttack(Attack.JOYSTICK);
		this.attackTarget = entity.getAttackTarget();
	}
	
	@Override
	public boolean shouldContinueExecuting()
    {
		int curTick = entity.ticksExisted - entity.getAttackTime();
		boolean returnValue = false;

		if(curTick > -1 && entity.getAttack() == Attack.JOYSTICK && AnimationManager.JoystickAnimation.getTotalTime() >= curTick) {
			returnValue = true;
			int curFrame = AnimationManager.JoystickAnimation.getFrameFromTick(curTick);
			if(curFrame == 1 && (curTick == 10 || curTick == 17)) {
				launchJoystick();
				launchJoystick();
			}
		}

		if(!returnValue) {
			entity.setAttack(Attack.NONE);
			entity.setDelay(Attack.JOYSTICK, this.delay + entity.ticksExisted);
		}

		return returnValue;
    }
	
	private void launchJoystick() {
		double d0 = this.entity.getDistanceSq(this.attackTarget.posX, this.attackTarget.getEntityBoundingBox().minY, this.attackTarget.posZ);
        boolean flag = this.entity.getEntitySenses().canSee(this.attackTarget);

        if (flag)
        {
            ++this.seeTime;
        }
        else
        {
            this.seeTime = 0;
        }

        if (d0 <= (double)this.maxAttackDistance && this.seeTime >= 20)
        {
            this.entity.getNavigator().clearPath();
        }
        else
        {
            this.entity.getNavigator().tryMoveToEntityLiving(this.attackTarget, this.entityMoveSpeed);
        }

        this.entity.getLookHelper().setLookPositionWithEntity(this.attackTarget, 30.0F, 30.0F);

        if (--this.rangedAttackTime == 0)
        {
            if (!flag)
            {
                return;
            }

            float f = MathHelper.sqrt(d0) / this.attackRadius;
            float lvt_5_1_ = MathHelper.clamp(f, 0.1F, 1.0F);
            this.rangedAttackEntityHost.attackEntityWithRangedAttack(this.attackTarget, lvt_5_1_);
            this.rangedAttackTime = MathHelper.floor(f * (float)(this.maxRangedAttackTime - this.attackIntervalMin) + (float)this.attackIntervalMin);
        }
        else if (this.rangedAttackTime < 0)
        {
            float f2 = MathHelper.sqrt(d0) / this.attackRadius;
            this.rangedAttackTime = MathHelper.floor(f2 * (float)(this.maxRangedAttackTime - this.attackIntervalMin) + (float)this.attackIntervalMin);
        }
	}
	
	

}
