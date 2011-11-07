package one.two.three;

public class PackageFilesystemWTF {
    public static void main( String[] args ) {
        System.out.println( String.format(
                "Greetings from %s whose Classloader is %s",
                PackageFilesystemWTF.class.getName(),
                PackageFilesystemWTF.class.getClassLoader().toString() ) );
    }
}