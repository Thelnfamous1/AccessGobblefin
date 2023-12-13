package me.infamous.access_gobblefin.common.registry;

import me.infamous.access_gobblefin.AccessMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AccessModItems {

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AccessMod.MODID);

    public static final RegistryObject<Item> GOBBLEFIN_SPAWN_EGG = ITEMS.register("gobblefin_spawn_egg",
            () -> new ForgeSpawnEggItem(AccessModEntityTypes.GOBBLEFIN, 2243405, 16382457,
                    (new Item.Properties()).tab(ItemGroup.TAB_MISC)));

    public static void register(IEventBus modEventBus){
        ITEMS.register(modEventBus);
    }
}
