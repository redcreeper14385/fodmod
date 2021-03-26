package mounderfod.mounderfodfodmod.entity;

import mounderfod.mounderfodfodmod.MounderfodFodmod;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class TaterEntityRenderer extends MobEntityRenderer<TaterEntity, TaterEntityModel> {
    public TaterEntityRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new TaterEntityModel(), 0.875f);
    }

    @Override
    public Identifier getTexture(TaterEntity entity) {
        return new Identifier(MounderfodFodmod.MOD_ID, "textures/entity/tater/tater.png");
    }
}
