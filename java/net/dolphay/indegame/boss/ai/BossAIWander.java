package net.dolphay.indegame.boss.ai;

import net.dolphay.indegame.boss.EntityIndeGame;
import net.dolphay.indegame.boss.EntityIndeGame.Attack;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIWander;

public class BossAIWander extends EntityAIWander{
	
	EntityIndeGame boss;

	public BossAIWander(EntityCreature creatureIn, double speedIn) {
		super(creatureIn, speedIn);
		
		this.boss = (EntityIndeGame) creatureIn;
		
	}
	
	@Override
	public boolean shouldExecute() {
		return super.shouldExecute() && this.boss.getAttack() == Attack.NONE;
	}
	
}
