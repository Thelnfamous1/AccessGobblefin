package me.infamous.access_gobblefin.datagen;

import me.infamous.access_gobblefin.common.registry.AccessModEntityTypes;
import net.minecraft.data.loot.EntityLootTables;
import net.minecraft.entity.EntityType;

public class AccessModEntityLootTables extends EntityLootTables {

    @Override
    protected void addTables() {
    }

    @Override
    protected Iterable<EntityType<?>> getKnownEntities() {
        return AccessModEntityTypes.getKnownEntities();
    }
}
