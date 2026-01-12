package com.example.block;

import com.example.AutoPlanterMod;
import com.example.block.custom.AutoPlanterBlock;
import com.example.block.custom.AutoPlanterBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
public class RegisterBlock {
    public static final Block AUTO_PLANTER_BLOCK = registerBlock("auto_planter_block",
            new AutoPlanterBlock(FabricBlockSettings.create()));

    public static final BlockEntityType<AutoPlanterBlockEntity> AUTO_PLANTER_BLOCK_ENTITY_TYPE =
            registerAutoPlanterBlockEntityType("auto_planter_block_entity_type", AUTO_PLANTER_BLOCK);

    private static Block registerBlock(String id, Block block){
        registerBlockItem(id, block);
        return Registry.register(Registries.BLOCK, new Identifier(AutoPlanterMod.MODID, id), block);
    }

    private static BlockEntityType<AutoPlanterBlockEntity> registerAutoPlanterBlockEntityType(String id, Block block){
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(AutoPlanterMod.MODID, id),
                FabricBlockEntityTypeBuilder.create(AutoPlanterBlockEntity::new, block).build());
    }

    private static void registerBlockItem(String id, Block block){
        Registry.register(Registries.ITEM, new Identifier(AutoPlanterMod.MODID, id), new BlockItem(block, new Item.Settings()));
    }

    public static void register() {

    }
}
