package mounderfod.mounderfodfodmod;

import mounderfod.mounderfodfodmod.block.*;
import mounderfod.mounderfodfodmod.entity.TaterEntity;
import mounderfod.mounderfodfodmod.item.SourceTankItem;
import mounderfod.mounderfodfodmod.recipe.CarbonInfusingRecipe;
import mounderfod.mounderfodfodmod.recipe.CentrifugeRecipe;
import mounderfod.mounderfodfodmod.recipe.ProcessingRecipe;
import mounderfod.mounderfodfodmod.screen.BoxScreenHandler;
import mounderfod.mounderfodfodmod.screen.CarbonInfuserScreenHandler;
import mounderfod.mounderfodfodmod.screen.CentrifugeScreenHandler;
import mounderfod.mounderfodfodmod.screen.ProcessorScreenHandler;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.recipe.CookingRecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import wraith.alloy_forgery.MaterialWorth;
import wraith.alloy_forgery.RecipeOutput;
import wraith.alloy_forgery.api.ForgeRecipes;
import wraith.alloy_forgery.api.MaterialWorths;

import java.util.HashMap;

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

    public static final RecipeType<CentrifugeRecipe> CENTRIFUGE_RECIPE_TYPE;
    public static final CookingRecipeSerializer<CentrifugeRecipe> CENTRIFUGE_RECIPE_SERIALIZER;
    public static final ScreenHandlerType<CentrifugeScreenHandler> CENTRIFUGE_SCREEN_HANDLER;

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

    public static final Item ZINC_DUST;
    public static final Item ZINC_INGOT;
    public static final Item ZINC_NUGGET;
    
    public static final Block ZINC_ORE;
    public static final BlockItem ZINC_ORE_ITEM;
    public static final Item GALVANISED_STEEL_INGOT;
    public static final Item GALVANISED_STEEL_NUGGET;

    public static final Item BASIC_CIRCUIT;
    public static final Item ADVANCED_CIRCUIT;

    public static final Block CENTRIFUGE_BLOCK;
    public static final BlockItem CENTRIFUGE_BLOCK_ITEM;
    public static final BlockEntityType<CentrifugeBlockEntity> CENTRIFUGE_BLOCK_ENTITY;

    public static final Block CARBON_FRAME;
    public static final BlockItem CARBON_FRAME_ITEM;

    public static final String MOD_ID = "fodmod";

    public static final EntityType<TaterEntity> TATER = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(MOD_ID, "tater"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, TaterEntity::new).dimensions(EntityDimensions.fixed(0.875f, 1.3125f)).build()
    );

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

        BASIC_CIRCUIT = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "basic_circuit"), new Item(new Item.Settings().group(ItemGroup.MISC)));
        ADVANCED_CIRCUIT = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "advanced_circuit"), new Item(new Item.Settings().group(ItemGroup.MISC)));

        ZINC_DUST = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "zinc_dust"), new Item(new Item.Settings().group(ItemGroup.MISC)));
        ZINC_INGOT = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "zinc_ingot"), new Item(new Item.Settings().group(ItemGroup.MISC)));
        ZINC_NUGGET = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "zinc_nugget"), new Item(new Item.Settings().group(ItemGroup.MISC)));
        ZINC_ORE = Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "zinc_ore"), new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE)));
        ZINC_ORE_ITEM = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "zinc_ore"), new BlockItem(ZINC_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

        CENTRIFUGE_BLOCK = Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "centrifuge"), new CentrifugeBlock(FabricBlockSettings.copyOf(Blocks.COBBLESTONE)));
        CENTRIFUGE_BLOCK_ITEM = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "centrifuge"), new BlockItem(CENTRIFUGE_BLOCK, new Item.Settings().group(ItemGroup.MISC)));
        CENTRIFUGE_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(MOD_ID, "centrifuge"), BlockEntityType.Builder.create(CentrifugeBlockEntity::new, CENTRIFUGE_BLOCK).build(null));
        CENTRIFUGE_RECIPE_TYPE = Registry.register(Registry.RECIPE_TYPE, new Identifier(MOD_ID, "centrifuge"), new RecipeType<CentrifugeRecipe>(){});
        CENTRIFUGE_RECIPE_SERIALIZER = Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(MOD_ID, "centrifuge"), new CookingRecipeSerializer<>(CentrifugeRecipe::new, 200));
        CENTRIFUGE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(MOD_ID, "centrifuge"), CentrifugeScreenHandler::new);

        GALVANISED_STEEL_INGOT = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "galvanised_steel_ingot"), new Item(new Item.Settings().group(ItemGroup.MISC)));
        GALVANISED_STEEL_NUGGET = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "galvanised_steel_nugget"), new Item(new Item.Settings().group(ItemGroup.MISC)));

        CARBON_FRAME = Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "carbon_frame"), new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
        CARBON_FRAME_ITEM = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "carbon_frame"), new BlockItem(CARBON_FRAME, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));


    }

    private static ConfiguredFeature<?, ?> ZINC_ORE_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    ZINC_ORE.getDefaultState(),
                    14
                    ))
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
                    0,
                    0,
                    63
            )))
            .spreadHorizontally()
            .repeat(20);

    @Override
    public void onInitialize() {
        RegistryKey<ConfiguredFeature<?, ?>> zincOreOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("fodmod", "zinc_ore_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, zincOreOverworld.getValue(), ZINC_ORE_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, zincOreOverworld);

        MaterialWorths.addMaterials(new HashMap<String, HashMap<String, MaterialWorth>>() {{
            put("steel", new HashMap<String, MaterialWorth>() {{
                put("#c:steel_blocks", new MaterialWorth(81, true));
                put("#c:steel_ingots", new MaterialWorth(9, true));
                put("#c:steel_dusts", new MaterialWorth(9, false));
                put("#c:steel_nuggets", new MaterialWorth(1, true));
            }});
            put("zinc", new HashMap<String, MaterialWorth>() {{
                put("#c:zinc_blocks", new MaterialWorth(81, true));
                put("#c:zinc_ingots", new MaterialWorth(9, true));
                put("#c:zinc_dusts", new MaterialWorth(9, false));
                put("#c:zinc_ores", new MaterialWorth(9, false));
                put("#c:zinc_nuggets", new MaterialWorth(1, true));
            }});
        }}, false);

        HashMap<String, Integer> galvanisedSteelInputs = new HashMap<String, Integer>();

        galvanisedSteelInputs.put("zinc", 9);
        galvanisedSteelInputs.put("steel", 9);

        ForgeRecipes.addRecipe(
                galvanisedSteelInputs,
                new RecipeOutput(
                        "fodmod:galvanised_steel_ingot",
                        1,
                        9,
                        1),
                true
        );
        FabricDefaultAttributeRegistry.register(TATER, TaterEntity.createMobAttributes());
    }
}
