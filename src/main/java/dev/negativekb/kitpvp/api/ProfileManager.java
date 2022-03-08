package dev.negativekb.kitpvp.api;

import dev.negativekb.kitpvp.api.model.Profile;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

/**
 * Represents the management class for {@link Profile}
 */
public interface ProfileManager {

    /**
     * Get the statistics {@link Profile} of the provided {@link UUID}
     * @param uuid {@link UUID} to lookup
     * @return {@link Profile} of the {@link UUID} if it is cached, returns null if it doesn't exist
     */
    @Nullable
    Profile getCachedProfile(@NotNull UUID uuid);

    /**
     * Get the statistics {@link Profile} of the provided {@link Player}
     * @param player {@link Player} to lookup
     * @return {@link Profile} of the {@link UUID} if it is cached, returns null if it doesn't exist
     */
    @Nullable
    default Profile getCachedProfile(@NotNull Player player) {
        return getCachedProfile(player.getUniqueId());
    }

}
