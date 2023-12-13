package me.infamous.access_gobblefin.common.events;

import me.infamous.access_gobblefin.AccessMod;
import me.infamous.access_gobblefin.common.entity.gobblefin.Gobblefin;
import me.infamous.access_gobblefin.common.registry.AccessModEntityTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, modid = AccessMod.MODID)
public class ForgeEventHandler {


    @SubscribeEvent(priority = EventPriority.HIGH)
    static void onBiomeLoading(BiomeLoadingEvent event){
        ResourceLocation biomeName = event.getName();
        if(biomeName == null) return;

        RegistryKey<Biome> biomeKey = RegistryKey.create(Registry.BIOME_REGISTRY, biomeName);
        if(BiomeDictionary.hasType(biomeKey, BiomeDictionary.Type.OVERWORLD)
                && BiomeDictionary.hasType(biomeKey, BiomeDictionary.Type.OCEAN)
                && !BiomeDictionary.hasType(biomeKey, BiomeDictionary.Type.COLD)
                && biomeName.getPath().contains("deep")){ // looking for overworld deep oceans that are not cold/frozen
            AccessMod.LOGGER.info("Adding {} spawns to {}", AccessModEntityTypes.GOBBLEFIN.getId(), biomeName);
            event.getSpawns().getSpawner(EntityClassification.WATER_CREATURE)
                    .add(new MobSpawnInfo.Spawners(AccessModEntityTypes.GOBBLEFIN.get(), 1, 1, 2));
        }
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    static void onDismount(EntityMountEvent event){
        if(!event.isCanceled() && event.getEntityBeingMounted() instanceof Gobblefin){
            Gobblefin gobblefin = (Gobblefin) event.getEntityBeingMounted();
            if(event.isDismounting()){
                Entity rider = event.getEntityMounting();
                if(gobblefin.isAlive() && gobblefin.isTrappedPassenger(rider) && EntityPredicates.NO_CREATIVE_OR_SPECTATOR.test(rider)){
                    event.setCanceled(true);
                } else if(!event.getWorldObj().isClientSide && !gobblefin.isThrowingUp()){
                    gobblefin.setThrowingUp();
                }
            }
        }
    }

}
