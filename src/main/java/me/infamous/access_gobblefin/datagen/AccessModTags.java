package me.infamous.access_gobblefin.datagen;

import me.infamous.access_gobblefin.AccessMod;
import net.minecraft.block.Block;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

public class AccessModTags {
    public static Tags.IOptionalNamedTag<Block> VORTEX_IMMUNE = blockTag("vortex_immune");

    private static Tags.IOptionalNamedTag<Block> blockTag(String name)
    {
        return BlockTags.createOptional(new ResourceLocation(AccessMod.MODID, name));
    }
}
