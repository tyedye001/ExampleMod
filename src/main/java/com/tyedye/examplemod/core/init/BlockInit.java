package com.tyedye.examplemod.core.init;

import com.tyedye.examplemod.ExampleMod;
import com.tyedye.examplemod.common.blocks.PowerBlock;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			ExampleMod.MOD_ID);

	public static final RegistryObject<Block> STEEL_BLOCK = BLOCKS.register("steel_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_LIGHT_GRAY)
					.sound(SoundType.METAL).strength(5f, 6f).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> STEEL_ORE = BLOCKS.register("steel_ore", () -> new DropExperienceBlock(
			BlockBehaviour.Properties.copy(Blocks.IRON_ORE).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> DEEPSLATE_STEEL_ORE = BLOCKS.register("deepslate_steel_ore",
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> POWER_BLOCK = BLOCKS.register("power_block",
			() -> new PowerBlock(BlockBehaviour.Properties.copy(STEEL_BLOCK.get()).requiresCorrectToolForDrops()));
}
