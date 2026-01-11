package com.example.block.custom;

import com.example.AutoPlanterMod;
import com.example.block.RegisterBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class AutoPlanterBlock extends Block implements BlockEntityProvider {

    public AutoPlanterBlock(Settings settings) {
        super(settings);
    }


    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new AutoPlanterBlockEntity(pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        if (type != RegisterBlock.AUTO_PLANTER_BLOCK_ENTITY_TYPE) {
            return null;
        }

        return (world1, pos, state1, be) -> {
            if (be instanceof AutoPlanterBlockEntity planterBe) {
                AutoPlanterBlockEntity.tick(world1, pos, state1, planterBe);
            }
        };    }
}
