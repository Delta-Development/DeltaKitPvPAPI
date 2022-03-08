package dev.negativekb.kitpvp.api;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents the bridge between external plugins and the core plugin
 */
public abstract class KitPvPAPI {

    @Getter @Setter
    private static KitPvPAPI instance;


}
