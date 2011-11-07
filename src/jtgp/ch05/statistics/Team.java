package jtgp.ch05.statistics;

import java.util.*;

/**
 * The <code>Team</code> interface, which defines the notion of a team for our
 * statistics package. A team is, at first incarnation, simply a collection of
 * players. All teams have a name.
 */
public interface Team {

    /**
     * Return a <code>String</code> that is the name of this team.
     * 
     * @return name of the team
     */
    String getName();

    /**
     * Return a list of <code>Player</code>s.
     * 
     * @return list of <code>Player</code>s
     */
    List<? extends Player> getPlayerList();

    /**
     * Add a <code>Player</code> to the team.
     * 
     * @param toAdd
     *            - <code>Player</code> to add
     */
    void addPlayer( Player toAdd );

    /**
     * Remove a <code>Player</code> from the team.
     * 
     * @param toRemove
     *            - <code>Player</code> to remove
     */
    void removePlayer( Player toRemove );

}
