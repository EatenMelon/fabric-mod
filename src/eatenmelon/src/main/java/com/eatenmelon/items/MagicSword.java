package com.eatenmelon.items;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;



public class MagicSword extends SwordItem {

    public static Logger LOGGER = LoggerFactory.getLogger("MagicSword");
    public FireballEntity currentFireball;
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(world.isClient) {
            return TypedActionResult.pass(user.getStackInHand(hand));
        }

        LOGGER.info(user.getName() + ": Casting fireball!");

        if(user.getInventory().main.stream().anyMatch(stack -> stack.isOf(Items.FIRE_CHARGE))){

            BlockPos frontOfPlayer = user.getBlockPos().offset(user.getHorizontalFacing(), 1).up(1);

            Vec3d vec3d = user.getRotationVec(1.0F).normalize();

            currentFireball = new FireballEntity(world, user, vec3d.x,vec3d.y,vec3d.z, 10);
            currentFireball.setPosition(frontOfPlayer.toCenterPos());
            world.spawnEntity(currentFireball);

            List<ItemStack> stacks = user.getInventory().main.stream().toList();
            for(ItemStack stack : stacks) {
                if(stack.getItem() instanceof FireChargeItem) {
                    stack.decrement(1);
                    break;
                }
            }

        }else{
            user.sendMessage(Text.literal("you need fire charge"));
        }

        return TypedActionResult.success(user.getStackInHand(hand));
    }

    public MagicSword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }
}
