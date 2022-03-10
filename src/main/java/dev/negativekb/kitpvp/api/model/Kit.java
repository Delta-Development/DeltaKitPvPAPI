package dev.negativekb.kitpvp.api.model;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;

/**
 * Represents a selectable kit in which you can apply to yourself in-game and play.
 * @author Negative
 */
public interface Kit {

    /**
     * Get the identifier of the {@link Kit}
     * @return {@link String}
     */
    @NotNull
    String getID();

    /**
     * Get the name of the {@link Kit}
     * @return {@link String}
     */
    @NotNull
    String getName();

    /**
     * Get the inventory contents of the {@link Kit}
     * @return {@link LinkedHashMap} of {@link Integer} and {@link ItemStack}
     */
    @NotNull
    LinkedHashMap<Integer, ItemStack> getInventory();

    /**
     * Get the helmet item of the {@link Kit}
     * @return {@link ItemStack}
     */
    @Nullable
    ItemStack getHelmet();

    /**
     * Get the chestplate item of the {@link Kit}
     * @return {@link ItemStack}
     */
    @Nullable
    ItemStack getChestplate();

    /**
     * Get the leggings item of the {@link Kit}
     * @return {@link ItemStack}
     */
    @Nullable
    ItemStack getLeggings();

    /**
     * Get the boots item of the {@link Kit}
     * @return {@link ItemStack}
     */
    @Nullable
    ItemStack getBoots();

    /**
     * Apply the {@link Kit} to the {@link Player}
     * @param player {@link Player} to be applied to
     * @param profile {@link Profile} of the {@link Player}
     */
    void apply(@NotNull Player player, @Nullable Profile profile);


}
