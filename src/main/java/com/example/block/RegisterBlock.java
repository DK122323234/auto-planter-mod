package com.example.block;

import com.example.AutoPlanterMod;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class RegisterBlock {
    public static final Block AUTO_PLANTER_BLOCK = registerBlock("auto_planter_block", new Block(FabricBlockSettings.create()));

    private static Block registerBlock(String id, Block block){
        registerBlockItem(id, block);
      return Registry.register(Registries.BLOCK, new Identifier(AutoPlanterMod.MODID, id), block);
    }

    private static void registerBlockItem(String id, Block block){
        Registry.register(Registries.ITEM, new Identifier(AutoPlanterMod.MODID, id), new BlockItem(block, new Item.Settings()));
    }
  public static void  register(){

    }
}
