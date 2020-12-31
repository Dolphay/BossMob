package net.dolphay.indegame.boss.ai;

import net.dolphay.indegame.boss.EntityIndeGame;
import net.dolphay.indegame.boss.EntityIndeGame.Attack;
import net.dolphay.indegame.boss.animations.AnimationManager;
import net.dolphay.indegame.boss.pets.ModdedParrot.EntityModdedParrot;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.math.BlockPos;

public class ParrotSummonAI extends EntityAIBase{

	EntityIndeGame entity;
	int delay;

	public ParrotSummonAI(EntityIndeGame entity, int delay) {
		this.entity = entity;
		this.delay = delay;
	}

	@Override
	public boolean shouldExecute() {
		return entity.getAttack() == Attack.NONE && 
				entity.getAttackTarget() != null && 
				entity.getEntityCount(Attack.PARROT) <= 3 &&
				(entity.getDelay(Attack.PARROT) != null ? entity.getDelay(Attack.PARROT).intValue() < entity.ticksExisted : true);
	}

	@Override
	public void startExecuting() {
		entity.setAttack(Attack.PARROT);
	}

	@Override
	public boolean shouldContinueExecuting() {
		int curTick = entity.ticksExisted - entity.getAttackTime();
		boolean returnValue = false;

		if(entity.getAttack() == Attack.PARROT) {
			if(AnimationManager.ParrotAnimation.getTotalTime() >= curTick && !entity.doGroundHit()) {
				returnValue = true;

				if(AnimationManager.ParrotAnimation.getFrameTime(1)[0] + 1 == curTick) {
					jump();
				}
			}
			else if(!entity.doGroundHit() && AnimationManager.ParrotAnimation.getTotalTime()*2.5 > curTick) {
				returnValue = true;
			}
			else if(AnimationManager.ParrotAnimation.getTotalTime()*2.5 <= curTick && !entity.doGroundHit()) {
				entity.groundHit();
			}
		}

		if(entity.doGroundHit()) {
			entity.groundHit();
			for(int i = 0; i < 3; i++) {
				float[] location = {(float) (entity.posX + (Math.random()*10-5F)),(float) (entity.posY + (Math.random()*5)), (float) (entity.posZ + (Math.random()*10-5F))};

				if(entity.world.isAirBlock(new BlockPos(location[0], location[1], location[2]))) {
					EntityModdedParrot parrot = new EntityModdedParrot(entity.world);
					parrot.setParrent(entity);
					parrot.setPosition(location[0], location[1], location[2]);
					entity.world.spawnEntity(parrot);
					entity.addEntity(Attack.PARROT, parrot);
				}
			}
		}

		if(!returnValue) {
			entity.setAttack(Attack.NONE);
			entity.setDelay(Attack.PARROT, this.delay + entity.ticksExisted);
		}

		return returnValue;
	}

	public void jump() {
		entity.addVelocity(0, 1.5, 0);
	}

}