package jtgp.ch05.impl;

import java.io.*;
import java.util.*;

import jtgp.ch05.statistics.*;

public class PlayerImpl implements Player, Serializable {
    private static final long serialVersionUID = 1L;

    private UUID id;
    private String name;
    private String filePrefix;
    private Team team;
    private Position position = Position.Utility;
    private boolean changed = false;

    public PlayerImpl( String playerName ) {
        name = playerName;
        id = UUID.randomUUID();
    }

    public PlayerImpl( UUID playerId, String prefix ) {
        id = playerId;
        filePrefix = prefix;
        try {
            ObjectInputStream readIn = new ObjectInputStream( new FileInputStream( makeFilename() ) );
            PlayerImpl copy = (PlayerImpl) readIn.readObject();
            readIn.close();
            id = playerId;
            name = copy.name;
            team = copy.team;
            position = copy.position;
        } catch ( IOException e ) {
            System.out.println( "unable to open file for player, creating new player object" );
            name = "unkown";
        } catch ( ClassNotFoundException e ) {
            System.out.println( "unable to read file for player" );
        }
    }

    protected void writeState() {
        try {
            ObjectOutputStream writeOut = new ObjectOutputStream( new FileOutputStream( makeFilename() ) );
            writeOut.writeObject( this );
            writeOut.close();
        } catch ( Exception e ) {
            System.out.println( "unable to write object" );
        }
    }

    private String makeFilename() {
        return filePrefix + id.toString();
    }

    protected void finalize() {
        if ( changed ) {
            writeState();
            System.out.println( "writeing state in finalizer " );
        }
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Team getTeam() {
        return team;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition( Position pos ) {
        position = pos;
    }

}
