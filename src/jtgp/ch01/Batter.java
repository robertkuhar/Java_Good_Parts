package jtgp.ch01;

/**
 * An interface that defines the notion of a batter in a baseball statistics
 * package. Each at-bat will be recorded for the hitter, along with the result
 * of that at-bat. Running totals of the important statistics will be available.
 */
public interface Batter {
    /**
     * The possible results of an at-bat for a hitter
     */
    enum AtBatResult {
        strikeOut, fieldOut, base1, base2, base3, base4, walk, reachOnError, sacrifice
    }

    /**
     * Returns the batter's name. Note that the interface does not define how
     * the name is set; this will be done when the object implementing the
     * interface is created and cannot be changed.
     * 
     * @return the name of the batter as a String
     */
    String getName();

    /**
     * Method used to record an at-bat. The result of the at-bat is passed in
     * and recorded.
     * 
     * @param what
     *            The result of the at-bat
     */
    void atBat( AtBatResult what );

    /**
     * Return the batting average for the hitter, defined as number of hits
     * divided by the number of at-bats.
     * 
     * @return The batting average, as a float
     */
    float getAverage();

    /**
     * Return the on-base percentage for this hitter, defined as (hits + walks)
     * / at-bats.
     * 
     * @return the on-base percentage
     */
    float getOBP();

    /**
     * Return the slugging percentage for the batter, defined as (total number
     * of bases) / at-bats.
     * 
     * @return The slugging percentage, as a float
     */
    float getSlugging();

    /**
     * Return the total number of bases for the hitter.
     * 
     * @return Total bases, as an integer
     */
    int getTotalBases();

    /**
     * Return the total number of at-bats for this hitter. Note that walks and
     * sacrifices do not count as at-bats.
     * 
     * @return
     */
    int getAtBats();

}