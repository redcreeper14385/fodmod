package mounderfod.mounderfodfodmod.block;

import mounderfod.mounderfodfodmod.MounderfodFodmod;
import mounderfod.mounderfodfodmod.screen.ProcessorScreenHandler;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

public class ProcessorBlockEntity extends AbstractFurnaceBlockEntity {

    public ProcessorBlockEntity() {
        super(MounderfodFodmod.PROCESSOR_BLOCK_ENTITY, MounderfodFodmod.PROCESSING_RECIPE_TYPE);
    }

    @Override
    protected Text getContainerName() {
        return new TranslatableText("container.processor");
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new ProcessorScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }
}
