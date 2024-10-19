package randommemes.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;

public class Doritos extends Item {
	public Doritos() {
		super(new Item.Settings().food(
						new FoodComponent.Builder()
										.snack()
										.statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20 * 10, 2), 1.0F)
										.nutrition(6)
										.saturationModifier(0.6F)
										.build()
		));
	}
}
