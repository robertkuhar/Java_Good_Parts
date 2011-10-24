package jtgp.ch02;

import java.io.*;

public class UseAndAbuse {
    public void caller() {
        try {
            called();
        } catch ( Exception e ) {
            System.out.println( "Problems " + e );
//        } catch ( FileNotFoundException fe ) {
//            System.out.println( "Problems " + e );
        }
    }

    private void called() throws FileNotFoundException {
        throw new FileNotFoundException();
    }
}
