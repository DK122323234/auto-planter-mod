package com.example.block.custom;

import com.example.block.RegisterBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AutoPlanterBlockEntity extends BlockEntity {
    private  int tickCounter = 0;

    public AutoPlanterBlockEntity(BlockPos pos, BlockState state) {
        super(RegisterBlock.AUTO_PLANTER_BLOCK_ENTITY_TYPE, pos, state);
    }


    public static void tick(World world, BlockPos pos, BlockState state, AutoPlanterBlockEntity autoPlanterBlockEntity) {
      int tickCounter  =  autoPlanterBlockEntity.tickCounter++;
            System.out.println("tickCounter");

    }
}
