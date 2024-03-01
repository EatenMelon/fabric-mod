package com.eatenmelon.items;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class MagicSword extends SwordItem {

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(world.isClient()) {
            user.sendMessage(Text.literal("casting!"));

            if(user.getInventory().main.stream().anyMatch(stack -> stack.isOf(Items.FIRE_CHARGE))){

                user.sendMessage(Text.literal("you have ammo"));

                BlockPos frontOfPlayer = user.getBlockPos().offset(user.getHorizontalFacing(), 10);

                LightningEntity lightningBolt = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
                lightningBolt.setPosition(frontOfPlayer.toCenterPos());
                world.spawnEntity(lightningBolt);



            }else{
                user.sendMessage(Text.literal("you need fire charge"));
            }
        }
        return TypedActionResult.success(user.getStackInHand(hand));
        //return super.use(world, user, hand);
    }

    public MagicSword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }
}
