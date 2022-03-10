package dev.negativekb.kitpvp.api.manager;

import dev.negativekb.kitpvp.api.model.Profile;
import dev.negativekb.kitpvp.api.option.Disableable;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.UUID;

/**
 * Represents the management class for {@link Profile}
 * @author Negative
 */
public interface ProfileManager extends Disableable {

    /**
     * Get a {@link Profile} from the provided {@link UUID}
     * @param uuid {@link UUID}
     * @return {@link Profile}
     * @throws NullPointerException If the {@link Profile} does not exist.
     */
    @Nullable
    Profile getProfile(@NotNull UUID uuid);

    /**
     * Get a {@link Profile} from the provided {@link UUID}
     * @param player {@link Player} instance
     * @return {@link Profile}
     * @throws NullPointerException If the {@link Profile} does not exist.
     */
    @Nullable
    default Profile getProfile(@NotNull Player player) {
        return getProfile(player.getUniqueId());
    }

    /**
     * Get a {@link Profile} from the provided {@link UUID}
     * @param player {@link OfflinePlayer} instance
     * @return {@link Profile}
     * @throws NullPointerException If the {@link Profile} does not exist.
     */
    default Profile getProfile(@NotNull OfflinePlayer player) {
        return getProfile(player.getUniqueId());
    }

    /**
     * Adds a new {@link Profile}
     * @param uuid {@link UUID} of the new user
     * @return A new {@link Profile}, or if the user already exists it will return their existing {@link Profile}
     */
    @NotNull
    Profile addProfile(@NotNull UUID uuid);

    /**
     * Remove the provided {@link Profile}
     * @param profile {@link Profile}
     */
    void removeProfile(@NotNull Profile profile);

    /**
     * Get an unmodifiable {@link Collection} of {@link Profile}
     * @return {@link Collection} of {@link Profile}
     */
    Collection<Profile> getProfiles();
}
