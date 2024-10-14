package lordruby.corruptednether.entities;

import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import lordruby.corruptednether.provider.CorruptedNetherEntityLootTableProvider;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.Shearable;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.entity.mob.BoggedEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class CorruptedSkeleton extends SkeletonEntity implements Shearable {
    private static final int HARD_ATTACK_INTERVAL = 50;
    private static final int REGULAR_ATTACK_INTERVAL = 70;
    private static final TrackedData<Boolean> SHEARED;
    public static final String SHEARED_KEY = "sheared";


    public CorruptedSkeleton(EntityType<? extends SkeletonEntity> entityType, World world) {

        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createSkeletonAttributes() {
        return AbstractSkeletonEntity.createAbstractSkeletonAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 24.0).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25);
    }

    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(SHEARED, false);
    }

    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putBoolean("sheared", this.isSheared());
    }

    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.setSheared(nbt.getBoolean("sheared"));
    }

    public boolean isSheared() {
        return (Boolean)this.dataTracker.get(SHEARED);
    }

    public void setSheared(boolean sheared) {
        this.dataTracker.set(SHEARED, sheared);
    }

    protected ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.isOf(Items.SHEARS) && this.isShearable()) {
            this.sheared(SoundCategory.PLAYERS);
            this.emitGameEvent(GameEvent.SHEAR, player);
            if (!this.getWorld().isClient) {
                itemStack.damage(1, player, getSlotForHand(hand));
            }

            return ActionResult.success(this.getWorld().isClient);
        } else {
            return super.interactMob(player, hand);
        }
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_BOGGED_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_BOGGED_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_BOGGED_DEATH;
    }

    protected PersistentProjectileEntity createArrowProjectile(ItemStack arrow, float damageModifier, @Nullable ItemStack shotFrom) {
        PersistentProjectileEntity persistentProjectileEntity = super.createArrowProjectile(arrow, damageModifier, shotFrom);
        if (persistentProjectileEntity instanceof ArrowEntity arrowEntity) {
            arrowEntity.addEffect(new StatusEffectInstance(StatusEffects.WITHER, 100));
        }

        return persistentProjectileEntity;
    }

    protected int getHardAttackInterval() {
        return 50;
    }

    protected int getRegularAttackInterval() {
        return 70;
    }

    public void sheared(SoundCategory shearedSoundCategory) {
        this.getWorld().playSoundFromEntity((PlayerEntity)null, this, SoundEvents.ENTITY_BOGGED_SHEAR, shearedSoundCategory, 1.0F, 1.0F);
        this.dropShearedItems();
        this.setSheared(true);
    }

    private void dropShearedItems() {
        World var2 = this.getWorld();
        if (var2 instanceof ServerWorld serverWorld) {
            LootTable lootTable = serverWorld.getServer().getReloadableRegistries().getLootTable(RegistryKey.of(RegistryKeys.LOOT_TABLE, CorruptedNetherEntityLootTableProvider.CORRUPTED_SKELETON_SHEARS));
            LootContextParameterSet lootContextParameterSet = (new LootContextParameterSet.Builder(serverWorld)).add(LootContextParameters.ORIGIN, this.getPos()).add(LootContextParameters.THIS_ENTITY, this).build(LootContextTypes.SHEARING);
            ObjectListIterator<ItemStack> var4 = lootTable.generateLoot(lootContextParameterSet).iterator();

            while(var4.hasNext()) {
                ItemStack itemStack = (ItemStack)var4.next();
                this.dropStack(itemStack, this.getHeight());
            }
        }

    }

    public boolean isShearable() {
        return !this.isSheared() && this.isAlive();
    }

    static {
        SHEARED = DataTracker.registerData(CorruptedSkeleton.class, TrackedDataHandlerRegistry.BOOLEAN);
    }
}
