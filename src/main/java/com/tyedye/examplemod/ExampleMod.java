package com.tyedye.examplemod;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import com.tyedye.examplemod.common.datagen.client.ExampleBlockStateProvider;
import com.tyedye.examplemod.common.datagen.client.ExampleItemModelProvider;
import com.tyedye.examplemod.common.datagen.client.languages.ExampleEnUsProvider;
import com.tyedye.examplemod.common.datagen.server.ExampleBlockTagsProvider;
import com.tyedye.examplemod.common.datagen.server.ExampleLootTableProvider;
import com.tyedye.examplemod.common.datagen.server.ExampleRecipeProvider;
import com.tyedye.examplemod.core.init.BlockInit;
import com.tyedye.examplemod.core.init.ItemInit;

import net.minecraft.client.Minecraft;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ExampleMod.MOD_ID)
public class ExampleMod {
	// Directly reference a slf4j logger
	public static final Logger LOGGER = LogUtils.getLogger();
	// Define mod id in a common place for everything to reference
	public static final String MOD_ID = "examplemod";

	public ExampleMod() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		// Register the commonSetup method for modloading
		bus.addListener(this::commonSetup);

		BlockInit.BLOCKS.register(bus);
		ItemInit.ITEMS.register(bus);

		// Register ourselves for server and other game events we are interested in
		MinecraftForge.EVENT_BUS.register(this);
	}

	private void commonSetup(final FMLCommonSetupEvent event) {
		// Some common setup code
		LOGGER.info("HELLO FROM COMMON SETUP");
		LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
	}

	// You can use SubscribeEvent and let the Event Bus discover methods to call
	@SubscribeEvent
	public void onServerStarting(ServerStartingEvent event) {
		// Do something when the server starts
		LOGGER.info("HELLO from server starting");
	}

	// You can use EventBusSubscriber to automatically register all static methods
	// in the class annotated with @SubscribeEvent
	@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class ClientModEvents {
		@SubscribeEvent
		public static void onClientSetup(FMLClientSetupEvent event) {
			// Some client setup code
			LOGGER.info("HELLO FROM CLIENT SETUP");
			LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
		}
	}
}
