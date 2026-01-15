package com.example.item;

import com.example.AutoPlanterMod;
import com.example.block.RegisterBlock;
import com.example.block.custom.AutoPlanterBlock;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class RegisterItemGroup {


    public static ItemGroup AUTO_PLANTER_MOD_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(AutoPlanterMod.MODID, "auto_planter"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.auto_planter")).icon(() -> new ItemStack(RegisterBlock.AUTO_PLANTER_BLOCK)).entries(((displayContext, entries) -> {
                entries.add(RegisterBlock.AUTO_PLANTER_BLOCK);
            })).build());

        public static void registersItemGroups (){
            AutoPlanterMod.LOGGER.info("Registering Item Groups for " + AutoPlanterMod.MODID);
        }

    }


