package dev.negativekb.kitpvp.api;

import dev.negativekb.kitpvp.api.manager.ConfigMessageManager;
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
@SuppressWarnings("all") // Because autocorrect
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
    )),

    /**
     * Represents the message you will get if you kill a player.
     * <p>
     * All placeholders are:
     * <p>
     * %player% | Represents the player's (victim's) raw in-game-name.
     * <p>
     * %displayname% | Represents the player's (victim's) formatted in-game-name. Such as prefixes and suffixes.
     */
    KILLED_PLAYER("killed-player", Collections.singletonList(
            "&aYou have killed &e%player%&a."
    )),

    /**
     * Represents the message you will get if you die to a player.
     * <p>
     * All placeholders are:
     * <p>
     * %player% | Represents the player's (killer's) raw in-game-name/
     * <p>
     * %displayname% | Represents the player's (killer's) formatted in-game-name. Such as prefixes and suffixes.
     */
    KILLED_BY_PLAYER("killed-by-player", Collections.singletonList(
            "&cYou have been killed by &e%player%&c."
    )),

    /**
     * Represents the message you will get if you die.
     * <p>
     * All placeholders are:
     * <p>
     * No placeholders.
     */
    KILLED_BY_ENVIRONMENT("killed-by-environment", Collections.singletonList(
            "&cYou have died."
    )),

    /**
     * Represents the message you will get if you die on a killstreak higher than x ({@link Integer}).
     * <p>
     * All placeholders are:
     * <p>
     * %victim% | Represents the victim's raw in-game-name.
     * <p>
     * %victim-displayname% | Represents the victim's formatted in-game-name. Such as prefixes and suffixes.
     * <p>
     * %killstreak-raw% | Represents the raw killstreak number without any fancy formatting.
     * <p>
     * %killstreak-formatted% | Represents the formatted killstreak number. Example: 1,000 rather than 1000
     */
    KILLSTREAK_END("killstreak-end", Collections.singletonList(
            "&6[KillStreaks]: &6%victim% &ewas killed on a killstreak of &6%killstreak-formatted%&e."
    )),

    /**
     * Represents the message you will get if you obtain a new killstreak announcement goal.
     * <p>
     * All placeholders are:
     * <p>
     * %player% | Represents the player's raw in-game-name.
     * <p>
     * %displayname% | Represents the player's formatted in-game-name. Such as prefixes and suffixes.
     * <p>
     * %killstreak-raw% | Represents the raw killstreak number without any fancy formatting.
     * <p>
     * %killstreak-formatted% | Represents the formatted killstreak number. Example: 1,000 rather than 1000
     */
    KILLSTREAK_ANNOUNCEMENT("killstreak-announcement", Collections.singletonList(
            "&6[KillStreaks]: &6%player% &ehas reached a killstreak of &6&l%killstreak-formatted%"
    )),

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
