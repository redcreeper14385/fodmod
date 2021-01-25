package mounderfod.mounderfodfodmod;

import mounderfod.mounderfodfodmod.block.BoxBlock;
import mounderfod.mounderfodfodmod.block.BoxBlockEntity;
import mounderfod.mounderfodfodmod.screen.BoxScreenHandler;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MounderfodFodmod implements ModInitializer {

    public static final Block BOX_BLOCK;
    public static final BlockItem BOX_BLOCK_ITEM;
    public static final BlockEntityType<BoxBlockEntity> BOX_BLOCK_ENTITY;
    public static final ScreenHandlerType<BoxScreenHandler> BOX_SCREEN_HANDLER;

    public static final Item IRON_GEAR;
    public static final Item GOLD_GEAR;

    public static final String MOD_ID = "fodmod";

    static {
        BOX_BLOCK = Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "box"), new BoxBlock(FabricBlockSettings.copyOf(Blocks.BARREL)));
        BOX_BLOCK_ITEM = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "box"), new BlockItem(BOX_BLOCK, new Item.Settings().group(ItemGroup.DECORATIONS).maxCount(1)));
        BOX_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(MOD_ID, "box"), BlockEntityType.Builder.create(BoxBlockEntity::new, BOX_BLOCK).build(null));
        BOX_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(MOD_ID, "box"), BoxScreenHandler::new);

        IRON_GEAR = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "iron_gear"), new Item(new Item.Settings().group(ItemGroup.MISC).maxCount(16)));
        GOLD_GEAR = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "gold_gear"), new Item(new Item.Settings().group(ItemGroup.MISC).maxCount(16)));

    }

    @Override
    public void onInitialize() {

    }
}
