package jtgp.ch04;

import java.util.*;

public class Hello {
    public static void main( String[] args ) {
        List<String> listOfArgs = Arrays.asList( args );
        if ( listOfArgs.size() > 0 ) {
            System.out.println( String.format( "Hello %s", listOfArgs ) );
        } else {
            System.out.println( "Hello" );
        }
    }

}
