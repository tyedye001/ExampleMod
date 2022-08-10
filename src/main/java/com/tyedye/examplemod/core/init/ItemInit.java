package com.tyedye.examplemod.core.init;

import com.tyedye.examplemod.ExampleMod;
import com.tyedye.examplemod.common.items.OreFinderItem;
import com.tyedye.examplemod.core.util.ModTabs;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			ExampleMod.MOD_ID);

	public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot",
			() -> new Item(new Item.Properties().fireResistant().rarity(Rarity.RARE).tab(ModTabs.EXAMPLE)));
	public static final RegistryObject<Item> STEEL_NUGGET = ITEMS.register("steel_nugget",
			() -> new Item(new Item.Properties().rarity(Rarity.RARE).tab(ModTabs.EXAMPLE)));
	public static final RegistryObject<Item> RAW_STEEL = ITEMS.register("raw_steel",
			() -> new Item(new Item.Properties().fireResistant().rarity(Rarity.RARE).tab(ModTabs.EXAMPLE)));
	public static final RegistryObject<Item> ORE_FINDER = ITEMS.register("ore_finder",
			() -> new OreFinderItem(new Item.Properties().durability(16).rarity(Rarity.UNCOMMON).tab(ModTabs.EXAMPLE)));

	/* BLOCK ITEMS */
	public static final RegistryObject<Item> STEEL_BLOCK = ITEMS.register("steel_block",
			() -> new BlockItem(BlockInit.STEEL_BLOCK.get(),
					new Item.Properties().fireResistant().rarity(Rarity.RARE).tab(ModTabs.EXAMPLE)));
	public static final RegistryObject<Item> STEEL_ORE = ITEMS.register("steel_ore",
			() -> new BlockItem(BlockInit.STEEL_ORE.get(),
					new Item.Properties().fireResistant().rarity(Rarity.RARE).tab(ModTabs.EXAMPLE)));
	public static final RegistryObject<Item> DEEPSLATE_STEEL_ORE = ITEMS.register("deepslate_steel_ore",
			() -> new BlockItem(BlockInit.DEEPSLATE_STEEL_ORE.get(),
					new Item.Properties().fireResistant().rarity(Rarity.RARE).tab(ModTabs.EXAMPLE)));
	public static final RegistryObject<Item> POWER_BLOCK = ITEMS.register("power_block",
			() -> new BlockItem(BlockInit.POWER_BLOCK.get(),
					new Item.Properties().fireResistant().rarity(Rarity.RARE).tab(ModTabs.EXAMPLE)));
}
