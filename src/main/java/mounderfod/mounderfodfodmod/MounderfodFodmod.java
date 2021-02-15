package mounderfod.mounderfodfodmod;

import mounderfod.mounderfodfodmod.block.*;
import mounderfod.mounderfodfodmod.item.SourceTankItem;
import mounderfod.mounderfodfodmod.recipe.CarbonInfusingRecipe;
import mounderfod.mounderfodfodmod.recipe.ProcessingRecipe;
import mounderfod.mounderfodfodmod.screen.BoxScreenHandler;
import mounderfod.mounderfodfodmod.screen.CarbonInfuserScreenHandler;
import mounderfod.mounderfodfodmod.screen.ProcessorScreenHandler;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.recipe.CookingRecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MounderfodFodmod implements ModInitializer {

    public static final Block BOX_BLOCK;
    public static final BlockItem BOX_BLOCK_ITEM;
    public static final BlockEntityType<BoxBlockEntity> BOX_BLOCK_ENTITY;
    public static final ScreenHandlerType<BoxScreenHandler> BOX_SCREEN_HANDLER;

    public static final Block PROCESSOR_BLOCK;
    public static final BlockItem PROCESSOR_BLOCK_ITEM;
    public static final BlockEntityType<ProcessorBlockEntity> PROCESSOR_BLOCK_ENTITY;

    public static final Item IRON_GEAR;
    public static final Item GOLD_GEAR;

    public static final Item IRON_DUST;
    public static final Item GOLD_DUST;

    public static final RecipeType<ProcessingRecipe> PROCESSING_RECIPE_TYPE;
    public static final CookingRecipeSerializer<ProcessingRecipe> PROCESSING_RECIPE_SERIALIZER;

    public static final ScreenHandlerType<ProcessorScreenHandler> PROCESSOR_SCREEN_HANDLER;

    public static final Item WATER_SOURCE_TANK;

    public static final Block CARBON_INFUSER_BLOCK;
    public static final BlockItem CARBON_INFUSER_BLOCK_ITEM;
    public static final BlockEntityType<CarbonInfuserBlockEntity> CARBON_INFUSER_BLOCK_ENTITY;

    public static final RecipeType<CarbonInfusingRecipe> CARBON_INFUSING_RECIPE_TYPE;
    public static final CookingRecipeSerializer<CarbonInfusingRecipe> CARBON_INFUSING_RECIPE_SERIALIZER;

    public static final ScreenHandlerType<CarbonInfuserScreenHandler> CARBON_INFUSER_SCREEN_HANDLER;

    public static final Item STEEL_DUST;
    public static final Item STEEL_INGOT;
    public static final Item STEEL_NUGGET;

    public static final String MOD_ID = "fodmod";

    static {
        BOX_BLOCK = Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "box"), new BoxBlock(FabricBlockSettings.copyOf(Blocks.BARREL)));
        BOX_BLOCK_ITEM = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "box"), new BlockItem(BOX_BLOCK, new Item.Settings().group(ItemGroup.DECORATIONS).maxCount(1)));
        BOX_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(MOD_ID, "box"), BlockEntityType.Builder.create(BoxBlockEntity::new, BOX_BLOCK).build(null));
        BOX_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(MOD_ID, "box"), BoxScreenHandler::new);

        IRON_GEAR = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "iron_gear"), new Item(new Item.Settings().group(ItemGroup.MISC).maxCount(16)));
        GOLD_GEAR = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "gold_gear"), new Item(new Item.Settings().group(ItemGroup.MISC).maxCount(16)));

        IRON_DUST = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "iron_dust"), new Item(new Item.Settings().group(ItemGroup.MISC)));
        GOLD_DUST = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "gold_dust"), new Item(new Item.Settings().group(ItemGroup.MISC)));

        PROCESSOR_BLOCK = Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "processor"), new ProcessorBlock(FabricBlockSettings.of(Material.METAL)));
        PROCESSOR_BLOCK_ITEM = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "processor"), new BlockItem(PROCESSOR_BLOCK, new Item.Settings().group(ItemGroup.DECORATIONS)));
        PROCESSOR_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(MOD_ID, "processor"), BlockEntityType.Builder.create(ProcessorBlockEntity::new, PROCESSOR_BLOCK).build(null));
        PROCESSING_RECIPE_TYPE = Registry.register(Registry.RECIPE_TYPE, new Identifier(MOD_ID, "processing"), new RecipeType<ProcessingRecipe>(){});
        PROCESSING_RECIPE_SERIALIZER = Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(MOD_ID, "processing"), new CookingRecipeSerializer<>(ProcessingRecipe::new, 200));
        PROCESSOR_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(MOD_ID, "processor"), ProcessorScreenHandler::new);

        CARBON_INFUSER_BLOCK = Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "carbon_infuser"), new CarbonInfuserBlock(FabricBlockSettings.of(Material.METAL)));
        CARBON_INFUSER_BLOCK_ITEM = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "carbon_infuser"), new BlockItem(CARBON_INFUSER_BLOCK, new Item.Settings().group(ItemGroup.DECORATIONS)));
        CARBON_INFUSER_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(MOD_ID, "carbon_infuser"), BlockEntityType.Builder.create(CarbonInfuserBlockEntity::new, CARBON_INFUSER_BLOCK).build(null));
        CARBON_INFUSING_RECIPE_TYPE = Registry.register(Registry.RECIPE_TYPE, new Identifier(MOD_ID, "carbon_infusing"), new RecipeType<CarbonInfusingRecipe>(){});
        CARBON_INFUSING_RECIPE_SERIALIZER = Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(MOD_ID, "carbon_infusing"), new CookingRecipeSerializer<>(CarbonInfusingRecipe::new, 200));
        CARBON_INFUSER_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(MOD_ID, "carbon_infuser"), CarbonInfuserScreenHandler::new);

        WATER_SOURCE_TANK = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "water_source_tank"), new SourceTankItem(Fluids.WATER, new Item.Settings().group(ItemGroup.MISC).maxCount(1)));

        STEEL_DUST = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "steel_dust"), new Item(new Item.Settings().group(ItemGroup.MISC)));
        STEEL_INGOT = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "steel_ingot"), new Item(new Item.Settings().group(ItemGroup.MISC)));
        STEEL_NUGGET = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "steel_nugget"), new Item(new Item.Settings().group(ItemGroup.MISC)));

    }

    @Override
    public void onInitialize() {

    }
}
