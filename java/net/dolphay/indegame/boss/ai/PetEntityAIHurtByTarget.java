package net.dolphay.indegame.boss.ai;

import net.dolphay.indegame.boss.EntityIndeGame;
import net.dolphay.indegame.boss.pets.EntityPet;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;

public class PetEntityAIHurtByTarget extends EntityAIHurtByTarget {

	public PetEntityAIHurtByTarget(EntityCreature creatureIn, boolean entityCallsForHelpIn,
			Class<?>... excludedReinforcementTypes) {
		super(creatureIn, entityCallsForHelpIn, excludedReinforcementTypes);
	}

	@Override
	public boolean shouldExecute() {
		return super.shouldExecute() && !(this.taskOwner instanceof EntityIndeGame || this.taskOwner instanceof EntityPet);
	}

}
