package jtgp.ch09.impl;

import java.io.*;
import java.util.*;

import jtgp.ch02.Batter.*;
import jtgp.ch02.Fielder.*;
import jtgp.ch08.Player.*;
import jtgp.ch09.*;

/**
 * An implementation of the {@link BoxScore} interface, ignoring all of the
 * little details like how the data that populates the private fields is
 * actually placed into the object.
 */
public class BoxScoreImpl implements BoxScore, Serializable {
    private static final long serialVersionUID = 1L;
    private LinkedList<String> teams = new LinkedList<String>();
    private Hashtable<String , List<UUID>> whoPlayed = new Hashtable<String , List<UUID>>();
    private Hashtable<UUID , Position> positions = new Hashtable<UUID , Position>();
    private Hashtable<UUID , List<AtBatResult>> atBats = new Hashtable<UUID , List<AtBatResult>>();
    private Hashtable<UUID , List<AttemptResult>> fielding = new Hashtable<UUID , List<AttemptResult>>();
    private Hashtable<UUID , Integer> passedBalls = new Hashtable<UUID , Integer>();

    public BoxScoreImpl( String team1, String team2 ) {
        teams.add( team1 );
        teams.add( team2 );
    }

    @Override
    public List<String> getTeams() {
        return teams;
    }

    @Override
    public List<UUID> getPlayers( String forTeam ) {
        return ( whoPlayed.get( forTeam ) );
    }

    @Override
    public Position getPosition( UUID forPlayer ) throws DidNotPlayException {
        if ( positions.contains( forPlayer )) {
            return positions.get(forPlayer);
        } else {
            throw new DidNotPlayException();
        }
    }

    @Override
    public List<AtBatResult> getBatting( UUID playerID ) throws DidNotPlayException {
        if (atBats.contains( playerID ) ) {
            return atBats.get( playerID );
        } else {
            throw new DidNotPlayException();
        }
    }

    @Override
    public List<AttemptResult> getFielding( UUID forPlayer ) {
        return fielding.get( forPlayer );
    }

    @Override
    public int getPassedBalls( UUID forPlayer ) {
        return passedBalls.get( forPlayer ).intValue();
    }

}
