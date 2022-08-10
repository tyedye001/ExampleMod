package com.tyedye.examplemod.common.blocks;

import java.util.List;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class PowerBlock extends Block {

	public PowerBlock(Properties properties) {
		super(properties);
	}

	@Override
	public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
		if (!level.isClientSide()) {
			if (entity instanceof LivingEntity) {
				LivingEntity livingEntity = (LivingEntity) entity;
				livingEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200));
			}
		}
		super.stepOn(level, pos, state, entity);
	}

	@SuppressWarnings("deprecation")
	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand,
			BlockHitResult hit) {
		Block block = state.getBlock();

		if (!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
			player.sendSystemMessage(
					Component.literal("This is " + block.getName().getString() + "! Step on it to gain strength."));
		}

		return super.use(state, level, pos, player, hand, hit);
	}

	@Override
	public void appendHoverText(ItemStack stack, BlockGetter level, List<Component> tooltip, TooltipFlag flag) {
		if (Screen.hasShiftDown()) {
			tooltip.add(Component.translatable("block.examplemod.power_block.tooltip.shift"));
		} else {
			tooltip.add(Component.translatable("block.examplemod.power_block.tooltip"));
		}
		super.appendHoverText(stack, level, tooltip, flag);
	}
}
