package net.baguette;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Baguette implements ModInitializer{

	public static final Item BAGUETTE_ITEM = new BaguetteItem(new Item.Settings()
		.group(ItemGroup.FOOD)
		.food(new FoodComponent.Builder()
			.hunger(15)
			.saturationModifier(18f)
			.build())
		.maxCount(16));

	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier("baguette", "baguette"), BAGUETTE_ITEM);

		AttackEntityCallback.EVENT.register((player, world, hand, entity, result) -> {
			if(entity != null 
				&& player.inventory.main.get(player.inventory.selectedSlot).getTranslationKey().compareTo("item.baguette.baguette") == 0
				&& entity.isAlive()
				&& entity instanceof LivingEntity) {
					System.out.println(player.getItemCooldownManager().isCoolingDown(player.inventory.main.get(player.inventory.selectedSlot).getItem()));
					entity.damage(DamageSource.player(player), 5f);
					return ActionResult.SUCCESS;
			}
			return ActionResult.PASS;
		});
	}
	
}