package com.eatenmelon.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

import java.rmi.registry.Registry;

public class StoneStatue extends HorizontalFacingBlock{


    protected StoneStatue(Settings settings) {
        super(settings);
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return VoxelShapes.cuboid(0f, 0f, 0.375f, 1f, 2.0f, 0.625f);
    }

    

    protected MapCodec<StoneStatue> getCodec() {
        return null;
    }
}
