package mounderfod.mounderfodfodmod.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class TaterEntity extends PathAwareEntity {

    public TaterEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public boolean canBeLeashedBy(PlayerEntity player) {
        return true;
    }

    @Override
    public boolean canMoveVoluntarily() {
        return true;
    }

    @Override
    public boolean isInvulnerable() {
        return true;
    }

    @Override
    public boolean cannotDespawn() {
        return true;
    }

    @Override
    protected ActionResult interactMob(PlayerEntity player, Hand hand) {
        if (player.getStackInHand(hand) == ItemStack.EMPTY) {
            player.sendMessage(new TranslatableText("message.fodmod.taterBelief"), true);
            return ActionResult.SUCCESS;
        }
        else if (player.getStackInHand(hand).getItem() == Items.FLINT_AND_STEEL) {
            this.setOnFireFor(5);
            player.sendMessage(new TranslatableText("message.fodmod.taterFire"), true);
            return ActionResult.SUCCESS;
        }
        else {
            return ActionResult.PASS;
        }
    }
}
