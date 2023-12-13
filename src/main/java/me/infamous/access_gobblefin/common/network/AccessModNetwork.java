package me.infamous.access_gobblefin.common.network;

import me.infamous.access_gobblefin.AccessMod;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

import java.util.Optional;

public class AccessModNetwork {
    private static final ResourceLocation CHANNEL_NAME = new ResourceLocation(AccessMod.MODID, "sync_channel");
    private static final String PROTOCOL_VERSION = "1.0";
    public static final SimpleChannel SYNC_CHANNEL = NetworkRegistry.newSimpleChannel(
            CHANNEL_NAME, () -> "1.0",
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );
    private static int INDEX = 0;

    public static void init() {
        SYNC_CHANNEL.registerMessage(INDEX++, ServerboundGobblefinControlPacket.class, ServerboundGobblefinControlPacket::encode, ServerboundGobblefinControlPacket::new, ServerboundGobblefinControlPacket::handle, Optional.of(NetworkDirection.PLAY_TO_SERVER));
        SYNC_CHANNEL.registerMessage(INDEX++, ClientboundVortexPacket.class, ClientboundVortexPacket::encode, ClientboundVortexPacket::new, ClientboundVortexPacket::handle, Optional.of(NetworkDirection.PLAY_TO_CLIENT));
    }
}
