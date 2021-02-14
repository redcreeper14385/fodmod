package mounderfod.mounderfodfodmod.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.ItemStack;

public class SourceTankItem extends BucketItem {

    public SourceTankItem(Fluid fluid, Settings settings) {
        super(fluid, settings);
    }

    @Override
    protected ItemStack getEmptiedStack(ItemStack stack, PlayerEntity player) {
        return new ItemStack(this);
    }
}
