package dev.negativekb.kitpvp.api;

import dev.negativekb.kitpvp.api.model.Profile;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

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

    /**
     * Get all cached profiles
     * @return All cached profiles, returns an empty list if there are no profiles cached
     */
    @NotNull
    Collection<Profile> getCachedProfiles();

    /**
     * Get all profiles generated from the database
     * @return All profiles, returns an empty list if there are no profiles in the database.
     */
    @NotNull
    Collection<Profile> getProfilesFromDatabase();

    /**
     * Update information about the provided {@link Profile} in the database
     * @param uuid {@link UUID} of the {@link Profile}
     * @param function The code that will be executed when completed
     */
    CompletableFuture<Void> updateProfile(@NotNull UUID uuid, @NotNull Consumer<Profile> function);

    /**
     * Update information about the provided {@link Profile} in the database
     * @param player {@link Player}'s {@link UUID} of the {@link Profile}
     * @param function The code that will be executed when completed
     */
    default CompletableFuture<Void> updateProfile(@NotNull Player player, @NotNull Consumer<Profile> function) {
        return updateProfile(player.getUniqueId(), function);
    }

    /**
     * Adds a new {@link Profile} to the database
     * @param uuid {@link UUID} of the new user
     * @return A new {@link Profile}, or if the user already exists it will return their existing {@link Profile}
     */
    @NotNull
    Profile addProfile(@NotNull UUID uuid);

    /**
     * Removes a {@link Profile} from the database and cache
     * @param profile {@link Profile} to be removed
     */
    CompletableFuture<Void> removeProfile(@NotNull Profile profile);

    /**
     * Unloads the {@link Profile} from the cache
     * @param profile {@link Profile} to be unloaded
     */
    void unload(@NotNull Profile profile);
}
