package me.infamous.access_gobblefin.datagen;

import me.infamous.access_gobblefin.AccessMod;
import net.minecraft.block.Blocks;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class AccessModBlockTagsProvider extends BlockTagsProvider {
    public AccessModBlockTagsProvider(DataGenerator pGenerator, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, AccessMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.tag(AccessModTags.VORTEX_IMMUNE).addTag(BlockTags.DRAGON_IMMUNE).add(Blocks.WATER).add(Blocks.LAVA);
    }
}
