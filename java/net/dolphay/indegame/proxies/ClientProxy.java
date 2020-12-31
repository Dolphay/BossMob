package net.dolphay.indegame.proxies;

import net.dolphay.indegame.boss.EntityIndeGame;
import net.dolphay.indegame.boss.ModelIndeGame;
import net.dolphay.indegame.boss.RenderIndeGame;
import net.dolphay.indegame.boss.pets.ModdedParrot.EntityModdedParrot;
import net.dolphay.indegame.boss.pets.ModdedParrot.RenderModdedParrot;
import net.dolphay.indegame.boss.pets.ModdedWolf.EntityModdedWolf;
import net.dolphay.indegame.boss.pets.ModdedWolf.RenderModdedWolf;
import net.dolphay.indegame.boss.ranged.controller.EntityController;
import net.dolphay.indegame.boss.ranged.controller.RenderController;
import net.dolphay.indegame.boss.ranged.joystick.EntityJoystick;
import net.dolphay.indegame.boss.ranged.joystick.RenderJoystick;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		RenderingRegistry.registerEntityRenderingHandler(EntityIndeGame.class, new IRenderFactory<EntityIndeGame>() {

			@Override
			public Render<? super EntityIndeGame> createRenderFor(RenderManager manager) {
				return new RenderIndeGame(manager);
			}
			
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityModdedParrot.class, new IRenderFactory<EntityModdedParrot>() {

			@Override
			public Render<? super EntityModdedParrot> createRenderFor(RenderManager manager) {
				return new RenderModdedParrot(manager);
			}
			
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityModdedWolf.class, new IRenderFactory<EntityModdedWolf>() {

			@Override
			public Render<? super EntityModdedWolf> createRenderFor(RenderManager manager) {
				return new RenderModdedWolf(manager);
			}
			
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityJoystick.class, new IRenderFactory<EntityJoystick>() {

			@Override
			public Render<? super EntityJoystick> createRenderFor(RenderManager manager) {
				return new RenderJoystick(manager);
			}
			
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityController.class, new IRenderFactory<EntityController>() {

			@Override
			public Render<? super EntityController> createRenderFor(RenderManager manager) {
				return new RenderController(manager);
			}
			
		});
	}
}
