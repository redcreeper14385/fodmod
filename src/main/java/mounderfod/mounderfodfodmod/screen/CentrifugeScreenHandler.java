package mounderfod.mounderfodfodmod.screen;

import mounderfod.mounderfodfodmod.MounderfodFodmod;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.screen.AbstractFurnaceScreenHandler;
import net.minecraft.screen.PropertyDelegate;

public class CentrifugeScreenHandler extends AbstractFurnaceScreenHandler {
    public CentrifugeScreenHandler(int i, PlayerInventory playerInventory) {
        super(MounderfodFodmod.CENTRIFUGE_SCREEN_HANDLER, MounderfodFodmod.CENTRIFUGE_RECIPE_TYPE, RecipeBookCategory.FURNACE, i, playerInventory);
    }
    public CentrifugeScreenHandler(int i, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
        super(MounderfodFodmod.CENTRIFUGE_SCREEN_HANDLER, MounderfodFodmod.CENTRIFUGE_RECIPE_TYPE, RecipeBookCategory.FURNACE, i, playerInventory, inventory, propertyDelegate);
    }
}
