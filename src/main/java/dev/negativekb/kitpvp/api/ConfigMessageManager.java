package dev.negativekb.kitpvp.api;

import dev.negativekb.kitpvp.api.model.ConfigMessage;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

/**
 * Represents the management class for {@link ConfigMessage}
 * <p>
 * Access via {@link KitPvPAPI}
 * @author Negative
 */
public interface ConfigMessageManager {

    /**
     * Create a new message in the messages.yml file!
     * @param defaultMessage Default value of the message
     * @return {@link ConfigMessage} instance
     * @apiNote It is recommended to use {@link #reload()} after creating new message, so it will be added to the file!
     */
    @NotNull
    ConfigMessage createMessage(@NotNull String key, @NotNull String... defaultMessage);

    /**
     * Returns an unmodifiable {@link Collection} of {@link ConfigMessage}
     * @return {@link Collection} of {@link ConfigMessage}
     */
    Collection<ConfigMessage> getAllCachedMessages();

    /**
     * Reload the messages.yml file
     */
    void reload();
}
