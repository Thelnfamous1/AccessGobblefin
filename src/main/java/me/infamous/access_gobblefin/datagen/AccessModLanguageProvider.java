package me.infamous.access_gobblefin.datagen;

import me.infamous.access_gobblefin.AccessMod;
import me.infamous.access_gobblefin.client.keybinding.AccessModKeybindings;
import me.infamous.access_gobblefin.common.registry.AccessModEntityTypes;
import me.infamous.access_gobblefin.common.registry.AccessModItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class AccessModLanguageProvider extends LanguageProvider {
    public AccessModLanguageProvider(DataGenerator gen) {
        super(gen, AccessMod.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        this.addEntityType(AccessModEntityTypes.GOBBLEFIN, "Gobblefin");
        this.add(AccessModItems.GOBBLEFIN_SPAWN_EGG.get(), "Gobblefin Spawn Egg");
        this.add(AccessModKeybindings.GOBBLEFIN_VORTEX_KEY, "Gobblefin Vortex");
        this.add(AccessModKeybindings.GOBBLEFIN_VORTEX_KEY, "Gobblefin Vortex");

        this.add("death.attack.access_gobblefin.vortex", "%1$s was sucked up");
        this.add("death.attack.access_gobblefin.vortex.player", "%1$s was sucked up by %2$s");
        this.add("death.attack.access_gobblefin.vortex.player.item", "%1$s was sucked up by %2$s using %3$s");
    }
}