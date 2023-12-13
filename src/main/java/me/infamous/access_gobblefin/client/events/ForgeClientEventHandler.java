package me.infamous.access_gobblefin.client.events;

import me.infamous.access_gobblefin.AccessMod;
import me.infamous.access_gobblefin.client.keybinding.AccessModKeybindings;
import me.infamous.access_gobblefin.common.entity.gobblefin.Gobblefin;
import me.infamous.access_gobblefin.common.network.AccessModNetwork;
import me.infamous.access_gobblefin.common.network.ServerboundGobblefinControlPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.function.Consumer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, modid = AccessMod.MODID, value = Dist.CLIENT)
public class ForgeClientEventHandler {
    private static boolean wasVortexDown = false;
    private static boolean wasBoostDown = false;

    @SubscribeEvent
    static void onFOVModifier(FOVUpdateEvent event){
        if(event.getEntity().getVehicle() instanceof Gobblefin){
            event.setNewfov(event.getNewfov() * 2.0F);
        }
    }

    @SubscribeEvent
    static void onClientTick(TickEvent.ClientTickEvent event){
        if(event.phase == TickEvent.Phase.START){
            ClientPlayerEntity player = Minecraft.getInstance().player;
            if(player == null) return;

            boolean vortexDown = AccessModKeybindings.GOBBLEFIN_VORTEX.isDown();
            if(!wasVortexDown && vortexDown){
                handleGobblefinKey(player, p -> AccessModNetwork.SYNC_CHANNEL.sendToServer(
                        new ServerboundGobblefinControlPacket(ServerboundGobblefinControlPacket.GobblefinControl.GOBBLEFIN_START_VORTEX)));
                wasVortexDown = true;
            } else if(wasVortexDown && !vortexDown){
                wasVortexDown = false;
                handleGobblefinKey(player, p -> AccessModNetwork.SYNC_CHANNEL.sendToServer(
                        new ServerboundGobblefinControlPacket(ServerboundGobblefinControlPacket.GobblefinControl.GOBBLEFIN_STOP_VORTEX)));
            }

            boolean boostDown = AccessModKeybindings.GOBBLEFIN_BOOST.isDown();
            if(!wasBoostDown && boostDown){
                handleGobblefinKey(player, p -> AccessModNetwork.SYNC_CHANNEL.sendToServer(
                        new ServerboundGobblefinControlPacket(ServerboundGobblefinControlPacket.GobblefinControl.GOBBLEFIN_START_BOOST)));
                wasBoostDown = true;
            } else if(wasBoostDown && !boostDown){
                wasBoostDown = false;
                handleGobblefinKey(player, p -> AccessModNetwork.SYNC_CHANNEL.sendToServer(
                        new ServerboundGobblefinControlPacket(ServerboundGobblefinControlPacket.GobblefinControl.GOBBLEFIN_STOP_BOOST)));
            }
        }
    }

    private static void handleGobblefinKey(ClientPlayerEntity player, Consumer<ClientPlayerEntity> keyAction){
        if(player.getVehicle() instanceof Gobblefin && ((Gobblefin)player.getVehicle()).isOwnedBy(player, player.level)) keyAction.accept(player);
    }
}
