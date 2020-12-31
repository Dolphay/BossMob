package net.dolphay.indegame.proxies;

import net.dolphay.indegame.boss.EntityIndeGame;
import net.dolphay.indegame.boss.RenderIndeGame;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ServerProxy extends CommonProxy{
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
	}
}
