package mounderfod.mounderfodfodmod.block;

import mounderfod.mounderfodfodmod.MounderfodFodmod;
import mounderfod.mounderfodfodmod.screen.CarbonInfuserScreenHandler;
import mounderfod.mounderfodfodmod.screen.ProcessorScreenHandler;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

public class CarbonInfuserBlockEntity extends AbstractFurnaceBlockEntity {

    public CarbonInfuserBlockEntity() {
        super(MounderfodFodmod.CARBON_INFUSER_BLOCK_ENTITY, MounderfodFodmod.CARBON_INFUSING_RECIPE_TYPE);
    }

    @Override
    protected Text getContainerName() {
        return new TranslatableText("container.carbon_infuser");
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new CarbonInfuserScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }
}
