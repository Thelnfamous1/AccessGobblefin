package me.infamous.access_gobblefin.common.registry;

import me.infamous.access_gobblefin.AccessMod;
import me.infamous.access_gobblefin.common.entity.ai.eater.VortexEater;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.datasync.IDataSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DataSerializerEntry;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AccessModDataSerializers {

    public static final DeferredRegister<DataSerializerEntry> DATA_SERIALIZERS = DeferredRegister.create(ForgeRegistries.DATA_SERIALIZERS, AccessMod.MODID);

    public static final RegistryObject<DataSerializerEntry> EAT_STATE = DATA_SERIALIZERS.register("eat_state", () -> new DataSerializerEntry(new IDataSerializer<VortexEater.EatState>() {
        @Override
        public void write(PacketBuffer pBuffer, VortexEater.EatState pValue) {
            pBuffer.writeEnum(pValue);
        }

        @Override
        public VortexEater.EatState read(PacketBuffer pBuffer) {
            return pBuffer.readEnum(VortexEater.EatState.class);
        }

        @Override
        public VortexEater.EatState copy(VortexEater.EatState pValue) {
            return pValue;
        }
    }));


    public static <T> IDataSerializer<T> getSerializer(RegistryObject<DataSerializerEntry> entry){
        return (IDataSerializer<T>) entry.get().getSerializer();
    }

    public static void register(IEventBus modEventBus){
        DATA_SERIALIZERS.register(modEventBus);
    }
}
