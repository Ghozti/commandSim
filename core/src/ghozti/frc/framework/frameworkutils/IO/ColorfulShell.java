package ghozti.frc.framework.frameworkutils.IO;

public class ColorfulShell {

    private static final String RESET = "\033[0m";  // Text Reset
    private static final String BLACK = "\033[0;30m";   // BLACK
    private static final String RED = "\033[0;31m";     // RED
    private static final String GREEN = "\033[0;32m";   // GREEN
    private static final String YELLOW = "\033[0;33m";  // YELLOW
    private static final String BLUE = "\033[0;34m";    // BLUE
    private static final String PURPLE = "\033[0;35m";  // PURPLE
    private static final String CYAN = "\033[0;36m";    // CYAN
    private static final String WHITE = "\033[0;37m";   // WHITE

    public static void printBLACK(String text){
        System.out.println(BLACK + text + RESET);
    }

    public static void printRED(String text){
        System.out.println(RED + text + RESET);
    }

    public static void printGREEN(String text){
        System.out.println(GREEN + text + RESET);
    }

    public static void printYELLOW(String text){
        System.out.println(YELLOW + text + RESET);
    }

    public static void printBLUE(String text){
        System.out.println(BLUE + text + RESET);
    }

    public static void printPURPLEK(String text){
        System.out.println(PURPLE + text + RESET);
    }

    public static void printCYAN(String text){
        System.out.println(CYAN + text + RESET);
    }

    public static void printWHITE(String text){
        System.out.println(WHITE + text + RESET);
    }
}
