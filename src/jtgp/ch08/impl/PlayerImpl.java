package jtgp.ch08.impl;

import java.util.*;

import jtgp.ch02.*;
import jtgp.ch05.statistics.*;
import jtgp.ch08.*;
import jtgp.ch08.Player;

/**
 *
 * 
 */
public class PlayerImpl implements Player {
    private UUID id;
    private String name;
    private Team team;
    private Position position = Position.Utility;
    private boolean changed = false;
    private EnumSet<Roles> roles;

    private BatterImpl batterStats;
    private FielderImpl fielderStats;
    private CatcherImpl catcherStats;

    public PlayerImpl( String playerName ) {
        name = playerName;
        id = UUID.randomUUID();
    }

    public PlayerImpl( UUID playerId, String prefix ) {
        id = playerId;
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

    @Override
    public boolean hasRole( Roles role ) {
        return roles.contains( role );
    }

    @Override
    public void addRole( Roles role ) {
        if ( hasRole( role ) ) {
            // Quick out on Player in role
            return;
        }
        switch ( role ) {
            case Batter:
                batterStats = new BatterImpl();
                break;
            case Fielder:
                fielderStats = new FielderImpl();
                break;
            case Catcher:
                catcherStats = new CatcherImpl();
                break;
            default:
                throw new IllegalStateException( String.format( "Unexpected Role %s", role ) );
        }
        roles.add( role );
    }

    @Override
    public Batter asBatter() {
        return batterStats;
    }

    @Override
    public Fielder asFielder() {
        return fielderStats;
    }

    @Override
    public Catcher asCatcher() {
        return catcherStats;
    }

}
