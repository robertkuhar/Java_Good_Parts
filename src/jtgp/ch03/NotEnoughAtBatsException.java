package jtgp.ch03;

public class NotEnoughAtBatsException extends Exception {
    private static final long serialVersionUID = 1L;

    private int atBatsNeeded;

    /**
     * Basic constructor, taking the reason and the number of additional at-bats
     * needed for a statistic to be valid.
     * 
     * @param message
     * @param needed
     */
    public NotEnoughAtBatsException( String message, int needed ) {
        super( message );
        atBatsNeeded = needed;
    }

    /**
     * Returns the number of at-bats needed for this exception to not be thrown
     * for this batter.
     * 
     * @return an integer showing the number of additional at-bats needed
     */
    public int getNeeded() {
        return atBatsNeeded;
    }
}
