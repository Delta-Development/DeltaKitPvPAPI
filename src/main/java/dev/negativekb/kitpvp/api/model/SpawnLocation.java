package dev.negativekb.kitpvp.api.model;

import dev.negativekb.kitpvp.api.option.Reloadable;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents the location of the server spawn
 */
public interface SpawnLocation {

    /**
     * Get the {@link Location} of the spawn
     * @return {@link Location}
     * @throws NullPointerException If there is no valid spawn location set
     */
    @Nullable
    Location getLocation();

    /**
     * Sets the spawn location to the new {@link Location} provided
     * @param location {@link Location} instance
     */
    void setLocation(@Nullable Location location);

    /**
     * Queues the {@link Player} for teleportation to the spawn
     * @param player {@link Player} instance
     * @param seconds Time in seconds ({@link Integer})
     */
    void queue(@NotNull Player player, int seconds);

    /**
     * Teleports the {@link Player} to spawn
     * @param player {@link Player} instance
     */
    default void teleport(@NotNull Player player) {
        player.teleport(getLocation(), PlayerTeleportEvent.TeleportCause.PLUGIN);
        player.playSound(getLocation(), Sound.ENDERMAN_TELEPORT, 1, 1);
    }

    /**
     * Reload the spawn location.
     * @param section {@link ConfigurationSection} of the location information
     */
    void reload(@NotNull ConfigurationSection section);

}
