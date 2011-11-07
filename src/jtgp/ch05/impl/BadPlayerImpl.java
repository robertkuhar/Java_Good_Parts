package jtgp.ch05.impl;

import java.io.*;
import java.util.*;

import jtgp.ch05.statistics.*;

public class BadPlayerImpl implements Player, Serializable {
    private static final long serialVersionUID = 1L;

    private UUID id;
    private String name;
    private String filePrefix;
    private Team team;
    private Position position = Position.Utility;
    private boolean changed = false;

    private ObjectInputStream readIn = null;

    public BadPlayerImpl( UUID playerId, String prefix ) {
        id = playerId;
        filePrefix = prefix;
        try {
            readIn = new ObjectInputStream( new FileInputStream( makeFilename() ) );
            BadPlayerImpl copy = (BadPlayerImpl) readIn.readObject();
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

    private String makeFilename() {
        return filePrefix + id.toString();
    }

    protected void finalize() {
        if ( readIn != null ) {
            try {
                readIn.close();
            } catch ( Exception e ) {
                // if there is an exception on close just eat it.
            }
        }
        if ( changed ) {
            try {
                ObjectOutputStream writeOut = new ObjectOutputStream( new FileOutputStream( makeFilename() ) );
                writeOut.writeObject( this );
                writeOut.close();
            } catch ( Exception e ) {
                System.out.println( "unable to write object" );
            }
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
