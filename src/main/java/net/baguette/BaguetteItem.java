package net.baguette;


import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;
public class BaguetteItem extends Item {

	public BaguetteItem(Settings settings) {
		super(settings);
	}

	@Override
	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
		tooltip.add(new TranslatableText("item.baguette.baguette.tooltip.effective"));
		tooltip.add(new TranslatableText("item.baguette.baguette.tooltip.damage"));
	}
}