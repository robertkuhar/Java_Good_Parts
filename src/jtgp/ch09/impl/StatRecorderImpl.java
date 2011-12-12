package jtgp.ch09.impl;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.util.*;

import jtgp.ch05.statistics.*;
import jtgp.ch08.Player;
import jtgp.ch09.*;

/**
 * An implementation of the StatRecorder interface. This will create a server
 * that is exported using the default RMI registry (which will need to be
 * started by some other means) on the standard port (1099). The server will
 * name itself Recorder, and can be found by clients if they know the machine on
 * which the server is running.
 */
public class StatRecorderImpl implements StatRecorder {
    private Hashtable<String , Team> teams = new Hashtable<String , Team>();
    private Registry registry;
    private StatRecorder myStub;

    public StatRecorderImpl( List<Team> initTeams ) {
        for ( Team t : initTeams ) {
            teams.put( t.getName(), t );
        }
        try {
            exportRecorder();
        } catch ( RemoteException re ) {
            /*
             * Hate it. We ate the actual exception, why are we try catch in a
             * constructor anyhow? Finally, System.out, NO, System.err
             */
            System.out.println( "unable to export stat recorder" );
            System.exit( 1 );
        }
    }

    /**
     * Export a stub object so that calls can be made from another address space
     * thorugh that object. This is done by putting the stub in a
     * {@link Registry}, which itself is a remote object that others can use to
     * find the stub that in turn is used to call the remote objects of this
     * implementation.
     * 
     * @throws RemoteException
     */
    private void exportRecorder() throws RemoteException {
        if ( System.getSecurityManager() == null ) {
            System.setSecurityManager( new SecurityManager() );
        }
        registry = LocateRegistry.getRegistry();
        myStub = (StatRecorder) UnicastRemoteObject.exportObject( this, 5550 );
        registry.rebind( "Recorder", myStub );
    }

    @Override
    public void recordGame( BoxScore stats ) throws RemoteException {
        for ( String teamName : stats.getTeams() ) {
            Team toUpdate = teams.get( teamName );
            processScore( toUpdate, stats );
        }
    }

    /**
     * Process the box score for a particular team. This implementation will go
     * through the players (by their id), and call {@link upDatePlayer} for each
     * player that was in the game.
     * 
     * @param forTeam
     *            the team whose players are being updated
     * @param game
     *            the {@link BoxScore} object that contains the record of the
     *            game
     */
    private void processScore( Team forTeam, BoxScore game ) {
        List<UUID> players = game.getPlayers( forTeam.getName() );
        for ( UUID id : players ) {
            Player toUpdate = forTeam.getPlayer( id );
            updatePlayer( toUpdate, game );
        }
    }

    /**
     * Update the statistics of a particular player, given the boxscore of the
     * game. The actual implementation of this method is an exercise left to the
     * reader...
     * 
     * @param toUpdate
     * @param game
     */
    private void updatePlayer( Player toUpdate, BoxScore game ) {
        // TODO Auto-generated method stub
    }

    @Override
    public Set<Player> getRoster( String forTeam ) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }
}
