package jtgp.ch02;

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
        TheClass theBetterClass = new TheClass() {
            public void aNewMethodOnTheClass() {
                System.out.println( "aNewMethodOnTheClass()" );
                
            }
            public void methodOnTheClass() {
                super.methodOnTheClass();
                aNewMethodOnTheClass();
            }
        };
    }

}
