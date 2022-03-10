package dev.negativekb.kitpvp.api.model;

import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

/**
 * Represents an entry in the messages.yml file
 * @author Negative
 */
public interface ConfigMessage {

    /**
     * Represents the unique id / path of the message
     * @return {@link String}
     */
    @NotNull
    String key();

    /**
     * The initial unchangeable message
     * @return {@link String}
     */
    @NotNull
    String getInitialMessage();

    /**
     * The message that will be sent or broadcasted
     *
     * The difference between this and the initial message is
     * the replacement strings, so if the message contains
     * placeholders, the initialMessage will still
     * have those default placeholders compared to this method which has the replaced placeholders.
     *
     * @return {@link String}
     */
    @NotNull
    String getMessage();

    /**
     * Set the message to a new array of {@link String}
     * @param message {@link String} Array
     */
    void setMessage(@NotNull String... message);

    /**
     * Set the message to a new collection of {@link String}
     * @param message {@link Collection} of {@link String}
     */
    void setMessage(@NotNull Collection<String> message);

    /**
     * Replace a placeholder with a new value
     * @param placeholder The placeholder to be replaced
     * @param replacement The new values of which to replace
     * @return {@link ConfigMessage} instance
     */
    @NotNull
    ConfigMessage replace(@NotNull String placeholder, @NotNull String replacement);

    /**
     * Send the final message to specified {@link CommandSender}s
     * @param senders Array of {@link CommandSender}
     */
    void send(@NotNull CommandSender... senders);

    /**
     * Broadcast the final message to the entire server
     */
    void broadcast();
}
