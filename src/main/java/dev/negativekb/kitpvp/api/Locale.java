package dev.negativekb.kitpvp.api;

import dev.negativekb.kitpvp.api.model.ConfigMessage;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Represents the official plugin messages
 * @author Negative
 */
@RequiredArgsConstructor
@Getter
public enum Locale {

    /**
     * Represents the message you will get if you attempted to find
     * a player which is not online.
     * <p>
     * All placeholders are:
     * <p>
     * %player% | Represents the player the user attempted to lookup.
      */
    PLAYER_NOT_ONLINE("player-not-online", Collections.singletonList(
            "&cThe player &e%player% &ccould not be found."
    ))

    ;
    private final String id;
    private final List<String> defaultMessage;
    private ConfigMessage message;

    /**
     * Initializes the official messages {@link ConfigMessage} instances
     * @param manager {@link ConfigMessageManager}
     */
    public static void init(ConfigMessageManager manager) {
        Arrays.stream(values()).forEach(locale ->
                locale.message = manager.createMessage(locale.id, locale.getDefaultMessage().toArray(new String[0])));

        manager.reload();
    }

    /**
     * See {@link ConfigMessage#send(CommandSender...)} for documentation
     */
    public void send(CommandSender... senders) {
        message.send(senders);
    }

    /**
     * See {@link ConfigMessage#broadcast()} for documentation
     */
    public void broadcast() {
        message.broadcast();
    }

    /**
     * See {@link ConfigMessage#replace(String, String)} for documentation
     */
    public ConfigMessage replace(String placeholder, String replacement) {
        return message.replace(placeholder, replacement);
    }
}
