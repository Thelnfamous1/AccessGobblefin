package me.infamous.access_gobblefin.common;

import me.infamous.access_gobblefin.AccessMod;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

public class AccessModUtil {
    public static final float TO_RADIANS = ((float) Math.PI / 180F);
    public static final ITag.INamedTag<Item> GOBBLEFIN_FOOD = ItemTags.createOptional(new ResourceLocation(AccessMod.MODID, "gobblefin_food"));

    public static int secondsToTicks(double seconds) {
        return (int) Math.ceil(seconds * 20);
    }

}
