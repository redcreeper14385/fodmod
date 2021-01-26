package mounderfod.mounderfodfodmod.recipe;

import mounderfod.mounderfodfodmod.MounderfodFodmod;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;

public class ProcessingRecipe extends AbstractCookingRecipe {
    public ProcessingRecipe(Identifier id, String group, Ingredient input, ItemStack output, float experience, int cookTime) {
        super(MounderfodFodmod.PROCESSING_RECIPE_TYPE, id, group, input, output, experience, cookTime);
    }

    @Override
    public ItemStack getRecipeKindIcon() {
        return new ItemStack(MounderfodFodmod.PROCESSOR_BLOCK_ITEM);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return MounderfodFodmod.PROCESSING_RECIPE_SERIALIZER;
    }
}
