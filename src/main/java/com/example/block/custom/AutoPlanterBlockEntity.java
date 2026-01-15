package com.example.block.custom;

import com.example.block.RegisterBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class AutoPlanterBlockEntity extends BlockEntity {
   private static final int FIELD_LENGTH = 6;
   private static final int SEED_LINGS = -5;
    private static int tickCounter = 0;

    public AutoPlanterBlockEntity(BlockPos pos, BlockState state) {
        super(RegisterBlock.AUTO_PLANTER_BLOCK_ENTITY_TYPE, pos, state);
    }


    public static void tick(World world, BlockPos pos, BlockState state, AutoPlanterBlockEntity autoPlanterBlockEntity) {
        tickCounter++;
        if(tickCooldown()){
            plantingSeedlings(getSeedlingPos(pos), world);
        }
    }

        private static boolean tickCooldown(){
            return tickCounter % 40 == 0;
        }
       private static List<BlockPos> getSeedlingPos(BlockPos posAutoPlanter){

        int maxPosX = posAutoPlanter.getX() + FIELD_LENGTH;
        int maxPosZ = posAutoPlanter.getZ() + FIELD_LENGTH;
        int minPosX = posAutoPlanter.getX() + SEED_LINGS ;
        int minPosZ = posAutoPlanter.getZ() + SEED_LINGS;
        int yPos = posAutoPlanter.getY();


         List<BlockPos> allPos = new ArrayList<>();

         for (int xPos = minPosX; xPos != maxPosX; xPos++){
             for (int zPos = minPosZ; zPos != maxPosZ; zPos++){
                 if(!new BlockPos(xPos, yPos, zPos).equals(posAutoPlanter)){
                   allPos.add(new BlockPos(xPos, yPos, zPos));
                 }

             }
         }
        return allPos;
       }

       private static void plantingSeedlings(List<BlockPos> seedlingsPos, World world){
   for (BlockPos seedlingPos : seedlingsPos){
      world.setBlockState(seedlingPos, Blocks.OAK_SAPLING.getDefaultState());
   }
    }

}
