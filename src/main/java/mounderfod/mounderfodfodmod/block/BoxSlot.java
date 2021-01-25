package mounderfod.mounderfodfodmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class BoxSlot extends Slot {

    public BoxSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }
    @Override
    public boolean canInsert(ItemStack stack) {
        return !(Block.getBlockFromItem(stack.getItem()) instanceof ShulkerBoxBlock) && !(Block.getBlockFromItem(stack.getItem()) instanceof BoxBlock);
    }
}
