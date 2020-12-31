package net.dolphay.indegame.boss.ai;

import net.dolphay.indegame.boss.EntityIndeGame;
import net.dolphay.indegame.boss.EntityIndeGame.Attack;
import net.dolphay.indegame.boss.animations.AnimationManager;
import net.dolphay.indegame.boss.pets.ModdedWolf.EntityModdedWolf;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.math.BlockPos;

public class WolfSummonAI extends EntityAIBase{

	EntityIndeGame entity;
	int delay;

	public WolfSummonAI(EntityIndeGame entity, int delay) {
		this.entity = entity;
		this.delay = delay;
	}

	@Override
	public boolean shouldExecute() {
		return entity.getAttack() == Attack.NONE && 
				entity.getAttackTarget() != null &&
				entity.getEntityCount(Attack.WOLF) < 2 &&
				(entity.getDelay(Attack.WOLF) != null ? entity.getDelay(Attack.WOLF).intValue() < entity.ticksExisted : true);
	}

	@Override
	public void startExecuting() {
		entity.setAttack(Attack.WOLF);
	}

	@Override
	public boolean shouldContinueExecuting() {
		int curTick = entity.ticksExisted - entity.getAttackTime();
		boolean returnValue = false;

		if(entity.getAttack() == Attack.WOLF) {
			if(AnimationManager.WolfAnimation.getTotalTime() >= curTick) {
				returnValue = true;

				if(AnimationManager.WolfAnimation.getFrameTime(0)[1] - 1 == curTick) {
					for(int i = 0; i < 2; i++) {
						float[] location = {(float) (entity.posX + (Math.random()*10-5F)),(float) (entity.posY + (Math.random()*5)), (float) (entity.posZ + (Math.random()*10-5F))};

						if(entity.world.isAirBlock(new BlockPos(location[0], location[1], location[2]))) {
							EntityModdedWolf wolf = new EntityModdedWolf(entity.world);
							wolf.setParrent(entity);
							wolf.setPosition(location[0], location[1], location[2]);
							entity.world.spawnEntity(wolf);
							entity.addEntity(Attack.WOLF, wolf);
						}
					}
				}
			}
		}

		if(!returnValue) {
			entity.setAttack(Attack.NONE);
			entity.setDelay(Attack.WOLF, this.delay + entity.ticksExisted);
		}

		return returnValue;
	}

}