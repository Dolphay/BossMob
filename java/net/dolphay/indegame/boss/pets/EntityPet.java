package net.dolphay.indegame.boss.pets;

import net.dolphay.indegame.boss.EntityIndeGame;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public abstract class EntityPet extends EntityMob{
	
	protected EntityIndeGame parent;

	public EntityPet(World worldIn) {
		super(worldIn);
	}
	
	public void onLivingUpdate()
    {
        super.onLivingUpdate();
        if(this.ticksExisted == 1) {
            if(this.world.isRemote) {
            	for(int i = 0; i < 10; i++) {
            		Minecraft.getMinecraft().world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, this.posX+(Math.random()*0.4)-0.2, this.posY+(Math.random()*0.4)-0.2, this.posZ+(Math.random()*0.4)-0.2, 0, 0, 0, new int[0]);
            	}
            }
        }
    }
	
	public void setParrent(EntityIndeGame parent) {
		this.parent = parent;
	}
	
	public abstract void removeParrentNode();
}
