package mounderfod.mounderfodfodmod.client;

import mounderfod.mounderfodfodmod.MounderfodFodmod;
import mounderfod.mounderfodfodmod.screen.BoxScreen;
import mounderfod.mounderfodfodmod.screen.CarbonInfuserScreen;
import mounderfod.mounderfodfodmod.screen.ProcessorScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

@Environment(EnvType.CLIENT)
public class MounderfodFodmodClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(MounderfodFodmod.BOX_SCREEN_HANDLER, BoxScreen::new);
        ScreenRegistry.register(MounderfodFodmod.PROCESSOR_SCREEN_HANDLER, ProcessorScreen::new);
        ScreenRegistry.register(MounderfodFodmod.CARBON_INFUSER_SCREEN_HANDLER, CarbonInfuserScreen::new);

    }
}
