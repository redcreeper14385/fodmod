package mounderfod.mounderfodfodmod.block;

import mounderfod.mounderfodfodmod.MounderfodFodmod;
import mounderfod.mounderfodfodmod.screen.CentrifugeScreenHandler;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

public class CentrifugeBlockEntity extends AbstractFurnaceBlockEntity {

    public CentrifugeBlockEntity() {
        super(MounderfodFodmod.CENTRIFUGE_BLOCK_ENTITY, MounderfodFodmod.CENTRIFUGE_RECIPE_TYPE);
    }

    @Override
    protected Text getContainerName() {
        return new TranslatableText("container.centrifuge");
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new CentrifugeScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }
}
