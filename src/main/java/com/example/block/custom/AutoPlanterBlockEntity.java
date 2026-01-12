package com.example.block.custom;

import com.example.block.RegisterBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class AutoPlanterBlockEntity extends BlockEntity {
    private static int tickCounter = 0;

    public AutoPlanterBlockEntity(BlockPos pos, BlockState state) {
        super(RegisterBlock.AUTO_PLANTER_BLOCK_ENTITY_TYPE, pos, state);
    }


    public static void tick(World world, BlockPos pos, BlockState state, AutoPlanterBlockEntity autoPlanterBlockEntity) {
        tickCounter++;
        if(tickCooldown()){
            getSeedlingPos(pos);
        }
    }

        private static boolean tickCooldown(){
            return tickCounter % 1200 == 0;
        }
       private static List<BlockPos> getSeedlingPos(BlockPos posAutoPlanter){

        int maxPosX = posAutoPlanter.getX() + 5;
        int maxPosY = posAutoPlanter.getY();
        int maxPosZ = posAutoPlanter.getZ() + 5;

         List<BlockPos> allPos = new ArrayList<>();

         for (int xPos = posAutoPlanter.getX(); xPos != maxPosX; xPos++){
             for (int zPos = posAutoPlanter.getZ(); zPos != maxPosZ; zPos++){
                 allPos.add(new BlockPos(xPos, maxPosY, zPos));
             }
         }
        return allPos;
       }

}
