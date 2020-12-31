package net.dolphay.indegame;

import net.dolphay.indegame.boss.EntityIndeGame;
import net.dolphay.indegame.boss.EntityIndeGame.Attack;
import net.dolphay.indegame.boss.pets.EntityPet;
import net.dolphay.indegame.boss.pets.ModdedParrot.EntityModdedParrot;
import net.dolphay.indegame.boss.pets.ModdedWolf.EntityModdedWolf;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class EventHandler {
	
	@SubscribeEvent
    public static void entityDeath(LivingDeathEvent event)
    {
		if (event.getEntity() instanceof EntityPet && !event.getEntity().world.isRemote)
		{
        	((EntityPet)event.getEntity()).removeParrentNode();
	    }
    }
}
