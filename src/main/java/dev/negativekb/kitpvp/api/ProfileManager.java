package dev.negativekb.kitpvp.api;

import dev.negativekb.kitpvp.api.model.Profile;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

/**
 * Represents the management class for {@link Profile}
 * @author Negative
 */
public interface ProfileManager {

    /**
     * Get a {@link Profile} from the provided {@link UUID}
     * @param uuid {@link UUID}
     * @return {@link Optional} of {@link Profile}
     */
    Optional<Profile> getProfile(@NotNull UUID uuid);

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
