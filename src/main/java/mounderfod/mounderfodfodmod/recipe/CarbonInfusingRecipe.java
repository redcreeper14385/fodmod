package mounderfod.mounderfodfodmod.recipe;

import mounderfod.mounderfodfodmod.MounderfodFodmod;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;

public class CarbonInfusingRecipe extends AbstractCookingRecipe {
    public CarbonInfusingRecipe(Identifier id, String group, Ingredient input, ItemStack output, float experience, int cookTime) {
        super(MounderfodFodmod.CARBON_INFUSING_RECIPE_TYPE, id, group, input, output, experience, cookTime);
    }

    @Override
    public ItemStack getRecipeKindIcon() {
        return new ItemStack(MounderfodFodmod.CARBON_INFUSER_BLOCK_ITEM);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return MounderfodFodmod.CARBON_INFUSING_RECIPE_SERIALIZER;
    }
}
