package randommemes.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class Gatorade extends Item {
	public Gatorade() {
		super(new Item.Settings().food(
						new FoodComponent.Builder()
										.nutrition(6)
										.saturationModifier(0.6f)
										.statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20 * 10, 2), 1.0f)
										.usingConvertsTo(Items.GLASS_BOTTLE)
										.build()
		));
	}
}
