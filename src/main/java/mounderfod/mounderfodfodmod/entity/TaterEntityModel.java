package mounderfod.mounderfodfodmod.entity;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class TaterEntityModel extends EntityModel<TaterEntity> {
	private final ModelPart main;

	public TaterEntityModel() {
		textureWidth = 64;
		textureHeight = 64;

		main = new ModelPart(this);
		main.setPivot(0.0F, 24.0F, 0.0F);
		main.setTextureOffset(0, 0).addCuboid(-7.0F, -21.0F, -7.0F, 14.0F, 21.0F, 14.0F, 0.0F, false);
	}

	@Override
	public void setAngles(TaterEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
	}

	@Override
	public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		main.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelPart modelPart, float x, float y, float z) {
		modelPart.pivotX = x;
		modelPart.pivotY = y;
		modelPart.pivotZ = z;
	}
}