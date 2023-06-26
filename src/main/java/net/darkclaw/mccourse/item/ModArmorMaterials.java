package net.darkclaw.mccourse.item;

import net.darkclaw.mccourse.MCCourseMod;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
        COBALT("cobalt", 17, new int[]{2, 5, 7, 3}, 12, SoundEvents.ARMOR_EQUIP_IRON, 0.5F, 0.0F, () -> {
                    return Ingredient.of(ModItems.COBALT_INGOT.get());
                });


        private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
        private final String name;
        private final int durabilityMultiplier;
        private final int[] slotProtections;
        private final int enchantmentValue;
        private final SoundEvent sound;
        private final float toughness;
        private final float knockbackResistance;
        private final LazyLoadedValue<Ingredient> repairIngredient;

   private ModArmorMaterials(String name, int DurabilityMultiplier, int[] SlotProtections,
                             int EnchantmentValue, SoundEvent Sound, float Toughness,
                             float KnockbackResistance, Supplier<Ingredient> RepairIngredient) {
        this.name = name;
        this.durabilityMultiplier = DurabilityMultiplier;
        this.slotProtections = SlotProtections;
        this.enchantmentValue = EnchantmentValue;
        this.sound = Sound;
        this.toughness = Toughness;
        this.knockbackResistance = KnockbackResistance;
        this.repairIngredient = new LazyLoadedValue<>(RepairIngredient);
    }

        public int getDurabilityForSlot(EquipmentSlot pSlot) {
        return HEALTH_PER_SLOT[pSlot.getIndex()] * this.durabilityMultiplier;
    }

        public int getDefenseForSlot(EquipmentSlot pSlot) {
        return this.slotProtections[pSlot.getIndex()];
    }

        public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

        public SoundEvent getEquipSound() {
        return this.sound;
    }

        public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

        public String getName() {
        return MCCourseMod.MOD_ID + ":" + this.name;
    }

        public float getToughness() {
        return this.toughness;
    }

        public float getKnockbackResistance() {
        return this.knockbackResistance;
    }

}
