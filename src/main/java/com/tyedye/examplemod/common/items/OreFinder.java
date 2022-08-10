package com.tyedye.examplemod.common.items;

import java.util.List;

import com.tyedye.examplemod.core.init.BlockInit;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class OreFinderItem extends Item {

	public OreFinderItem(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		ItemStack hand = context.getItemInHand();
		Level level = context.getLevel();

		if (level.isClientSide()) {
			BlockPos pos = context.getClickedPos();
			Player player = context.getPlayer();
			boolean found = false;

			for (int i = 0; i <= pos.getY() + 64; i++) {
				Block below = level.getBlockState(pos.below(i)).getBlock();

				if (isValuable(below)) {
					outputOreCoords(pos.below(i), player, below);
					found = true;
					break;
				}
			}

			if (!found) {
				player.sendSystemMessage(
						Component.literal("Sorry " + player.getName().getString() + ", no ores found. :("));
				// player.sendSystemMessage(Component.translatable("item.examplemod.ore_finder.no_ores"));
			}
		}

		hand.hurtAndBreak(1, context.getPlayer(), (player) -> player.broadcastBreakEvent(player.getUsedItemHand()));
		return super.useOn(context);
	}

	@Override
	public void appendHoverText(ItemStack stack, Level level, List<Component> tooltip, TooltipFlag isAdvanced) {
		if (Screen.hasShiftDown()) {
			tooltip.add(Component.translatable("item.examplemod.ore_finder.tooltip.shift"));
		} else {
			tooltip.add(Component.literal("Press SHIFT for more information"));
		}

		super.appendHoverText(stack, level, tooltip, isAdvanced);
	}

	private void outputOreCoords(BlockPos pos, Player player, Block below) {
		player.sendSystemMessage(Component.literal(below.getName().getString() + " found at (" + pos.getX() + ", "
				+ pos.getY() + ", " + pos.getZ() + "), " + player.getName().getString()));
	}

	private boolean isValuable(Block block) {
		return block == Blocks.COAL_ORE || block == Blocks.COPPER_ORE || block == Blocks.DEEPSLATE_COAL_ORE
				|| block == Blocks.DEEPSLATE_COPPER_ORE || block == Blocks.DEEPSLATE_DIAMOND_ORE
				|| block == Blocks.DEEPSLATE_EMERALD_ORE || block == Blocks.DEEPSLATE_GOLD_ORE
				|| block == Blocks.DEEPSLATE_IRON_ORE || block == Blocks.DEEPSLATE_LAPIS_ORE
				|| block == Blocks.DEEPSLATE_REDSTONE_ORE || block == Blocks.DIAMOND_ORE || block == Blocks.EMERALD_ORE
				|| block == Blocks.GOLD_ORE || block == Blocks.IRON_ORE || block == Blocks.LAPIS_ORE
				|| block == BlockInit.DEEPSLATE_STEEL_ORE.get() || block == BlockInit.STEEL_ORE.get()
				|| block == Blocks.RAW_IRON_BLOCK || block == Blocks.RAW_COPPER_BLOCK;
	}
}
