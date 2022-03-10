package dev.negativekb.kitpvp.api.model;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

/**
 * Represents the data class for custom player statistics
 * @author Negative
 */
public interface Profile {

    /**
     * The unique identifier of the player
     * @return {@link UUID}
     */
    @NotNull
    UUID getUniqueID();

    /**
     * Get the kills statistic
     * @return {@link Integer}
     */
    int getKills();

    /**
     * Get the deaths statistic
     * @return {@link Integer}
     */
    int getDeaths();

    /**
     * Get the kill to death ratio of the player
     * @apiNote The equation is simple, just kills / deaths = kdr
     * @return {@link Double}
     */
    default double getKDR() {
        return ((double) getKills() / (double) getDeaths());
    }

    /**
     * Get the killstreak statistic
     * @return {@link Integer}
     */
    int getKillStreak();

    /**
     * Get the best killstreak statistic
     * @return {@link Integer}
     */
    int getBestKillStreak();

    /**
     * Get the current bounty statistic
     * @return {@link Long}
     */
    long getBounty();

    /**
     * Get the credits statistic
     * @return {@link Long}
     */
    long getCredits();

    /**
     * Set the kills statistic to the provided amount
     * @param amount Amount to set the statistic to
     */
    void setKills(int amount);

    /**
     * Set the deaths statistic to the provided amount
     * @param amount Amount to set the statistic to
     */
    void setDeaths(int amount);

    /**
     * Set the killstreak statistic to the provided amount
     * @param amount Amount to set the statistic to
     */
    void setKillStreak(int amount);

    /**
     * Set the best killstreak statistic to the provided amount
     * @param amount Amount to set the statistic to
     */
    void setBestKillStreak(int amount);

    /**
     * Set the bounty statistic to the provided amount
     * @param amount Amount to set the statistic to
     */
    void setBounty(long amount);

    /**
     * Set the credits statistic to the provided amount
     * @param amount Amount to set the statistic to
     */
    void setCredits(long amount);

    /**
     * Adds the amount provided to the kills statistic
     * @param amount Amount to add
     */
    default void addKills(int amount) {
        setKills(getKills() + amount);
    }

    /**
     * Adds the amount provided to the deaths statistic
     * @param amount Amount to add
     */
    default void addDeaths(int amount) {
        setDeaths(getDeaths() + amount);
    }

    /**
     * Adds the amount provided to the killstreak statistic
     * @param amount Amount to add
     */
    default void addKillStreak(int amount) {
        setKillStreak(getKillStreak() + amount);
    }

    /**
     * Resets the killstreak statistic to 0
     */
    default void resetKillStreak() {
        setKillStreak(0);
    }

    /**
     * Adds the amount provided to the best killstreak statistic
     * @param amount Amount to add
     */
    default void addBestKillStreak(int amount) {
        setBestKillStreak(getBestKillStreak() + amount);
    }

    /**
     * Adds the amount provided to the bounty statistic
     * @param amount Amount to add
     */
    default void addBounty(long amount) {
        setBounty(getBounty() + amount);
    }

    /**
     * Resets the bounty statistic to 0
     */
    default void resetBounty() {
        setBounty(0);
    }

    /**
     * Adds the amount provided to the credits statistic
     * @param amount Amount to add
     */
    default void addCredits(long amount) {
        setCredits(getCredits() + amount);
    }

    /**
     * Removes the amount provided from the credits statistic
     * If the remaining amount of credits left on the profile is under 0 it will reset to 0,
     * @param amount Amount to remove
     */
    default void removeCredits(long amount) {
        setCredits(getCredits() - amount);
        if (getCredits() < 0)
            setCredits(0);
    }

    /**
     * Transacts credits with the provided cost
     * @param cost Cost of the transaction
     * @return If the transaction was successful
     */
    default boolean transactCredits(long cost) {
        if (getCredits() >= cost) {
            removeCredits(cost);
            return true;
        }
        return false;
    }

    /**
     * Get the current {@link Kit} applied to the player
     * @return {@link String}
     * @throws NullPointerException If they do not have a {@link Kit} applied
     */
    @Nullable
    String getCurrentKit();

    /**
     * Set the current {@link Kit} of the player
     * @param kit {@link Kit} ID ({@link String})
     */
    void setCurrentKit(@Nullable String kit);

    /**
     * Set the current {@link Kit} of the player
     * @param kit {@link Kit} instance
     */
    default void setCurrentKit(@Nullable Kit kit) {
        if (kit == null)
            setCurrentKit((String) null);
        else
            setCurrentKit(kit.getID());
    }
}
