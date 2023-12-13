package me.infamous.access_gobblefin.client.events;

import me.infamous.access_gobblefin.AccessMod;
import me.infamous.access_gobblefin.client.keybinding.AccessModKeybindings;
import me.infamous.access_gobblefin.client.renderer.gobblefin.GobblefinRenderer;
import me.infamous.access_gobblefin.common.registry.AccessModEntityTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = AccessMod.MODID, value = Dist.CLIENT)
public class ModClientEventHandler {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(AccessModEntityTypes.GOBBLEFIN.get(), GobblefinRenderer::new);

        ClientRegistry.registerKeyBinding(AccessModKeybindings.GOBBLEFIN_VORTEX);
        ClientRegistry.registerKeyBinding(AccessModKeybindings.GOBBLEFIN_BOOST);
    }
}
