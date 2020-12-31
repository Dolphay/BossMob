package net.dolphay.indegame;

import net.dolphay.indegame.boss.EntityIndeGame;
import net.dolphay.indegame.boss.RenderIndeGame;
import net.dolphay.indegame.boss.animations.AnimationManager;
import net.dolphay.indegame.proxies.CommonProxy;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class IndeGameBoss {
	
	@Instance(Reference.MODID)
	public static IndeGameBoss instance;
	@SidedProxy(clientSide="net.dolphay.indegame.proxies.ClientProxy",
            serverSide="net.dolphay.indegame.proxies.ServerProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		AnimationManager.setAnimations();
		proxy.preInit(event);
	}
	
}
