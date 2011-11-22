package jtgp.ch08;

import java.util.*;

import jtgp.ch02.*;
import jtgp.ch05.statistics.*;
import jtgp.ch08.impl.*;

/**
 * Basic interface for a player object. An object implementing this interface
 * can be made part of a {@link Team}. Classes implementing this interface will
 * also allow access to statistics gathered for the player in the form of
 * objects of type {@link Batter}, {@link Fielder}, or {@link Catcher}. Which of
 * these roles will be had by a Player will in part be determined by the
 * {@link Position} of the Player.
 */
public interface Player {
    /**
     * The position played by the player. The position can be used to determine
     * what objects supporting other interfaces will be returned by an
     * implementation of the object that also implements this interface. All
     * objects that implement this interface that are not assigned a Position of
     * <code>Pitcher</code> and are not on {@link Team} in the American League
     * will return an object implementing the {@link Batter} interface. All
     * objects that implement this interface will return an object implement the
     * {@link Fielder} interface except for those that have a position of
     * <code>DH</code>; only players on a {@link Team} that is in the American
     * League can be assigned that position. Only players assigned the position
     * of <code> Catcher</code> will return an object implementing the
     * {@link Catcher} interface.
     */
    public enum Position {
        Pitcher,
        Catcher,
        FirstBase,
        SecondBase,
        ThirdBase,
        ShortStop,
        LeftField,
        CenterField,
        RightField,
        DH,
        Utility
    }

    /**
     * The roles that can be played by a Player. These roles determine which
     * statistics will be gathered about the Player.
     */
    public enum Roles {
        Batter, Fielder, Catcher
    }

    /**
     * Return the identifier for the player. This is just a {@link UUID},
     * generated when the player object is first created, used to distinguish
     * between players that might have the same name. It is up to the
     * implementation of the method to ensure that the identifier is unique over
     * the set of all players. UUID getId();
     * 
     * @return A {@link UUID} that uniquely identifies this player
     */
    UUID getId();

    /**
     * Return the name of the player, as a {@link String}
     * 
     * @return {@link String} that is the name of this player
     */
    String getName();

    /**
     * Return a {@link Team} object that represents the team that this player is
     * on.
     * 
     * @return The {@link Team} for which this player plays
     */
    Team getTeam();

    /**
     * Return the {@link Position} played by this player, which can be used to
     * determine the roles that the player has.
     * 
     * @return the {@link Position} of this player
     */
    Position getPosition();

    /**
     * Set the {@link Position} of the player.
     * 
     * @param pos
     *            the {@link Position} played by this player
     */
    void setPosition( Position pos );

    /**
     * Queries if the {@code Player} has the indicated role. Returns
     * {@code true} if the Player does have the role, and {@code false}
     * otherwise. Note that a Player can have multiple roles.
     * 
     * @param role
     *            role as defined in {@link Roles}
     * @return {@code true} if the Player has the role, and {@code false}
     *         otherwise.
     */
    boolean hasRole( Roles role );

    /**
     * Add an instance of Roles to the set of Roles for which statistics are
     * gathered for this Player. Adding an instance of Roles multiple times has
     * no effect beyond the initial addition of the call. Roles cannot be
     * removed once assigned to a Player.
     * 
     * @param role
     *            the {@link Roles} to be added to the set of statistics for
     *            this Player.
     */
    void addRole( Roles role );

    /**
     * Return a {@link Batter} object if this Player has the role of a Batter,
     * otherwise returns null.
     * 
     * @return a {@link Batter} object containing the batting statistics for
     *         this Player.
     */
    Batter asBatter();

    /**
     * Return a {@link Fielder} object if this Player has the role of a Fielder,
     * otherwise returns null.
     * 
     * @return a {@link Fielder} object containing the fielding statistics for
     *         this Player.
     */
    Fielder asFielder();

    /**
     * Return a {@link Catcher} object if this Player has the role of a Catcher,
     * otherwise returns null.
     * 
     * @return a {@link Catcher} object containing the catching statistics for
     *         this Player.
     */
    Catcher asCatcher();
}
