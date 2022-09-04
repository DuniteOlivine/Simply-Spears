package duniteolivine.simplyspears.world.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import duniteolivine.simplyspears.world.entity.projectile.ThrownDiamondSpear;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import duniteolivine.simplyspears.world.entity.projectile.ThrownIronSpear;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class SpearItem extends Item implements Vanishable {
    //public static final int THROW_THRESHOLD_TIME = 10;
    //public static final float SHOOT_POWER = 2.5F;
    public static int Tier = 0;
    private final Multimap<Attribute, AttributeModifier> defaultModifiers;
    public SpearItem(Tiers tier, float Damage, float Attack_Speed, Item.Properties iprop) {
        super(iprop);
        final float BASE_DAMAGE = Damage;
        final float ATTACK_SPEED = Attack_Speed;
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", BASE_DAMAGE, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", ATTACK_SPEED, AttributeModifier.Operation.ADDITION));
        this.defaultModifiers = builder.build();
    }

    public boolean canAttackBlock(BlockState bstate, Level lvl, BlockPos bpos, Player plyr) {
        return !plyr.isCreative();
    }

    public UseAnim getUseAnimation(ItemStack istack) {
        return UseAnim.SPEAR;
    }

    public int getUseDuration(ItemStack istack) {
        return 72000;
    }

    public void releaseUsing(ItemStack istack, Level lvl, LivingEntity ent, int p_43397_) {
        if (ent instanceof Player player) {
            int i = this.getUseDuration(istack) - p_43397_;
            if (i >= 10) {
                if (!lvl.isClientSide) {
                    istack.hurtAndBreak(1, player, (p_43388_) -> {
                        p_43388_.broadcastBreakEvent(ent.getUsedItemHand());
                    });
                    if (this.toString() == "iron_spear") {
                        ThrownIronSpear thrownspear = new ThrownIronSpear(lvl, player, istack);
                        thrownspear.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.5F, 1.0F);
                        if (player.getAbilities().instabuild) {
                            thrownspear.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                        }

                        lvl.addFreshEntity(thrownspear);
                        lvl.playSound(null, thrownspear, SoundEvents.TRIDENT_THROW, SoundSource.PLAYERS, 1.0F, 1.0F);
                        if (!player.getAbilities().instabuild) {
                            player.getInventory().removeItem(istack);
                        }
                    }
                    else {
                        ThrownDiamondSpear throwndiamondspear = new ThrownDiamondSpear(lvl, player, istack);
                        throwndiamondspear.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.5F, 1.0F);
                        if (player.getAbilities().instabuild) {
                            throwndiamondspear.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                        }

                        lvl.addFreshEntity(throwndiamondspear);
                        lvl.playSound(null, throwndiamondspear, SoundEvents.TRIDENT_THROW, SoundSource.PLAYERS, 1.0F, 1.0F);
                        if (!player.getAbilities().instabuild) {
                            player.getInventory().removeItem(istack);
                        }
                    }
                }

                player.awardStat(Stats.ITEM_USED.get(this));
            }
        }
    }

    public InteractionResultHolder<ItemStack> use(Level lvl, Player plyr, InteractionHand ihand) {
        ItemStack itemstack = plyr.getItemInHand(ihand);
        if (itemstack.getDamageValue() >= itemstack.getMaxDamage() - 1) {
            return InteractionResultHolder.fail(itemstack);
        }
        else {
            plyr.startUsingItem(ihand);
            return InteractionResultHolder.consume(itemstack);
        }
    }

    public boolean hurtEnemy(ItemStack istack, LivingEntity p_43391_, LivingEntity p_43392_) {
        istack.hurtAndBreak(1, p_43392_, (p_43414_) -> {
            p_43414_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
        });
        return true;
    }

    public boolean mineBlock(ItemStack istack, Level lvl, BlockState bstate, BlockPos bpos, LivingEntity ent) {
        if ((double)bstate.getDestroySpeed(lvl, bpos) != 0.0D) {
            istack.hurtAndBreak(2, ent, (p_43385_) -> {
                p_43385_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
            });
        }

        return true;
    }

    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(@NotNull EquipmentSlot eslot) {
        return eslot == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(eslot);
    }

    public int getEnchantmentValue() {
        return 1;
    }
}