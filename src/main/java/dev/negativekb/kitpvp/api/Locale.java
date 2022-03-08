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
 */
@RequiredArgsConstructor
@Getter
public enum Locale {

    /**
     * Represents the message you will get if you attempted to find
     * a player which is not online.
     */
    PLAYER_NOT_ONLINE("player-not-online", Collections.singletonList(
            "&cThe player &e%player% &ccould not be found."
    ))

    ;
    private final String id;
    private final List<String> defaultMessage;
    private ConfigMessage message;

    public static void init(ConfigMessageManager manager) {
        Arrays.stream(values()).forEach(locale ->
                locale.message = manager.createMessage(locale.id, locale.getDefaultMessage().toArray(new String[0])));

        manager.reload();
    }

    public void send(CommandSender... senders) {
        message.send(senders);
    }

    public void broadcast() {
        message.broadcast();
    }

    public ConfigMessage replace(String placeholder, String replacement) {
        return message.replace(placeholder, replacement);
    }
}
