package mounderfod.mounderfodfodmod.recipe;

import mounderfod.mounderfodfodmod.MounderfodFodmod;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;

public class CentrifugeRecipe extends AbstractCookingRecipe {
    public CentrifugeRecipe(Identifier id, String group, Ingredient input, ItemStack output, float experience, int cookTime) {
        super(MounderfodFodmod.CENTRIFUGE_RECIPE_TYPE, id, group, input, output, experience, cookTime);
    }

    @Override
    public ItemStack getRecipeKindIcon() {
        return new ItemStack(MounderfodFodmod.CENTRIFUGE_BLOCK_ITEM);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return MounderfodFodmod.CENTRIFUGE_RECIPE_SERIALIZER;
    }
}
