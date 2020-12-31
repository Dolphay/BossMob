package net.dolphay.indegame.proxies;

import net.dolphay.indegame.IndeGameBoss;
import net.dolphay.indegame.Reference;
import net.dolphay.indegame.boss.EntityIndeGame;
import net.dolphay.indegame.boss.pets.ModdedParrot.EntityModdedParrot;
import net.dolphay.indegame.boss.pets.ModdedWolf.EntityModdedWolf;
import net.dolphay.indegame.boss.ranged.controller.EntityController;
import net.dolphay.indegame.boss.ranged.joystick.EntityJoystick;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class CommonProxy{
	public void preInit(FMLPreInitializationEvent event) {
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID +":IndeGame"), EntityIndeGame.class, "IndeGame", Reference.ENTITY_INDEGAME, IndeGameBoss.instance, 64, 1, true, 1, 20);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID +":ModdedParrot"), EntityModdedParrot.class, "ModdedParrot", Reference.ENTITY_MODDEDPARROT, IndeGameBoss.instance, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID +":ModdedWolf"), EntityModdedWolf.class, "ModdedWolf", Reference.ENTITY_MODDEDWOLF, IndeGameBoss.instance, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID +":Joystick"), EntityJoystick.class, "Joystick", Reference.ENTITY_JOYSTICK, IndeGameBoss.instance, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID +":Controller"), EntityController.class, "Controller", Reference.ENTITY_CONTROLLER, IndeGameBoss.instance, 64, 1, true);
	}
}
