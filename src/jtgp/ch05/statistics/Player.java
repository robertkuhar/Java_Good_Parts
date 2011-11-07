package jtgp.ch05.statistics;

import java.util.*;

/**
 * Basic interface for a player object.
 */
public interface Player {
    enum Position {
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
     * Return the identifier for the player. This is just an <code>int</code>,
     * generated when the player object is first created, used to distinguish
     * between players that might have the same name.
     */
    UUID getId();

    /**
     * Return the name of the player, as a <code>String</code>.
     * 
     * @return the name of the player
     */
    String getName();

    /**
     * Return the <code>Team</code> of the player.
     * 
     * @return the Team of the player
     */
    Team getTeam();

    /**
     * Return the <code>Position</code> played by this player.
     * 
     * @return the <code>Position</code> of this player
     */
    Position getPosition();

    /**
     * Set the <code>Position</code> of the player.
     * 
     * @param pos
     *            the <code>Position</code> played by this player.
     */
    void setPosition( Position pos );
}
