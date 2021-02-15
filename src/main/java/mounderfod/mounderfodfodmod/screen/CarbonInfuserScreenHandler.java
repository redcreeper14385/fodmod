package mounderfod.mounderfodfodmod.screen;

import mounderfod.mounderfodfodmod.MounderfodFodmod;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.screen.AbstractFurnaceScreenHandler;
import net.minecraft.screen.PropertyDelegate;

public class CarbonInfuserScreenHandler extends AbstractFurnaceScreenHandler {
    public CarbonInfuserScreenHandler(int i, PlayerInventory playerInventory) {
        super(MounderfodFodmod.CARBON_INFUSER_SCREEN_HANDLER, MounderfodFodmod.CARBON_INFUSING_RECIPE_TYPE, RecipeBookCategory.FURNACE, i, playerInventory);
    }
    public CarbonInfuserScreenHandler(int i, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
        super(MounderfodFodmod.CARBON_INFUSER_SCREEN_HANDLER, MounderfodFodmod.CARBON_INFUSING_RECIPE_TYPE, RecipeBookCategory.FURNACE, i, playerInventory, inventory, propertyDelegate);
    }
}
