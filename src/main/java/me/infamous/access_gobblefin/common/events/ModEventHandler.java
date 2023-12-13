package me.infamous.access_gobblefin.common.events;

import me.infamous.access_gobblefin.AccessMod;
import me.infamous.access_gobblefin.common.entity.gobblefin.Gobblefin;
import me.infamous.access_gobblefin.common.network.AccessModNetwork;
import me.infamous.access_gobblefin.common.registry.AccessModEntityTypes;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = AccessMod.MODID)
public class ModEventHandler {

    @SubscribeEvent
    public static void onAttributeCreation(EntityAttributeCreationEvent event) {
        event.put(AccessModEntityTypes.GOBBLEFIN.get(), Gobblefin.createAttributes().build());
    }

    @SubscribeEvent
    static void onCommonSetup(FMLCommonSetupEvent event){
        event.enqueueWork(() -> {
            AccessModNetwork.init();
            EntitySpawnPlacementRegistry.register(
                    AccessModEntityTypes.GOBBLEFIN.get(),
                    EntitySpawnPlacementRegistry.PlacementType.IN_WATER,
                    Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                    Gobblefin::checkGobblefinSpawnRules);
        });
    }
}
