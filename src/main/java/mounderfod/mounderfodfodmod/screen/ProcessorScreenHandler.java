package mounderfod.mounderfodfodmod.screen;

import mounderfod.mounderfodfodmod.MounderfodFodmod;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.screen.AbstractFurnaceScreenHandler;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandlerType;

public class ProcessorScreenHandler extends AbstractFurnaceScreenHandler {
    public ProcessorScreenHandler(int i, PlayerInventory playerInventory) {
        super(MounderfodFodmod.PROCESSOR_SCREEN_HANDLER, MounderfodFodmod.PROCESSING_RECIPE_TYPE, RecipeBookCategory.FURNACE, i, playerInventory);
    }
    public ProcessorScreenHandler(int i, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
        super(MounderfodFodmod.PROCESSOR_SCREEN_HANDLER, MounderfodFodmod.PROCESSING_RECIPE_TYPE, RecipeBookCategory.FURNACE, i, playerInventory, inventory, propertyDelegate);
    }
}
