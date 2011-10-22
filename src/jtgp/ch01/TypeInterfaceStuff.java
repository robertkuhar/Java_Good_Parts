package jtgp.ch01;

public class TypeInterfaceStuff {
    static class TheClass {
        public void methodOnTheClass() {
            System.out.println( "methodOnTheClass()" );
        }
    }
    
    interface TheInterface {
        public void methodOnTheInterface();
    }

    public static final void main( String args[] ) {
        TheClass theClass = new TheClass();
        TheInterface theInterface = new TheInterface() {
            @Override
            public void methodOnTheInterface() {
                System.out.println( "methodOnTheInterface()" );
            } };
        /* Why can't I do this, since I can do that crazy thing with the interface...    
        TheClass theBetterClass = new TheClass() extends TheClass {
            public void aNewMethodOnTheClass() {
                
            }
        };
        */
    }

}
