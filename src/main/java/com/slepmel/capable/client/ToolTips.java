package com.slepmel.capable.client;

import com.slepmel.capable.common.registry.CapableTags;
import com.slepmel.capable.config.CapableConfig;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.Item;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

public class ToolTips {
	
    public static void onToolTipEvent(ItemTooltipEvent event) {
        if (CapableConfig.Common.enableToolTips.get()) {
            final Item item = event.getItemStack().getItem();
            if (item.is(CapableTags.CUSTOM_TOOLTIPS)) {
                if (Screen.hasShiftDown() || Screen.hasControlDown())
                    event.getToolTip().add(new TranslationTextComponent("tooltip.capable." + item.getRegistryName().toString().replaceAll("capable:", "")).withStyle(TextFormatting.AQUA));
                else
                    event.getToolTip().add(new TranslationTextComponent("tooltip.capable.default").withStyle(TextFormatting.BLUE));
            }
        }
    }

}
