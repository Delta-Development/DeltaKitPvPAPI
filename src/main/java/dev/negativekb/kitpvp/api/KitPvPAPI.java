package dev.negativekb.kitpvp.api;

import dev.negativekb.kitpvp.api.manager.ConfigMessageManager;
import dev.negativekb.kitpvp.api.manager.ProfileManager;
import dev.negativekb.kitpvp.api.model.SpawnLocation;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents the bridge between external plugins and the core plugin
 * @author Negative
 */
public abstract class KitPvPAPI {

    private static KitPvPAPI instance;

    /**
     * Get the instance of {@link ProfileManager}
     * @return {@link ProfileManager}
     */
    public abstract ProfileManager getProfileManager();

    /**
     * Get the instance of {@link ConfigMessageManager}
     * @return {@link ConfigMessageManager}
     */
    public abstract ConfigMessageManager getMessageManager();

    /**
     * Get the instance of {@link SpawnLocation}
     * @return {@link SpawnLocation}
     */
    public abstract SpawnLocation getSpawnLocation();

    /**
     * @return the instance of {@link KitPvPAPI}
     */
    public static KitPvPAPI getInstance() {
        return instance;
    }

    /**
     * Set a new instance of {@link KitPvPAPI}
     * @param instance Subclass of {@link KitPvPAPI}
     */
    protected static void setInstance(KitPvPAPI instance) {
        KitPvPAPI.instance = instance;
    }
}
