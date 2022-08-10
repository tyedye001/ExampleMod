package com.tyedye.examplemod.core.util;

import com.tyedye.examplemod.ExampleMod;
import com.tyedye.examplemod.core.init.ItemInit;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModTabs {
	public static final CreativeModeTab EXAMPLE = new CreativeModeTab(ExampleMod.MOD_ID) {

		@Override
		public ItemStack makeIcon() {
			return new ItemStack(ItemInit.STEEL_INGOT.get());
		}

	};
}
