public class ConsoleUI {

    public static void printTitle(String title) {

        System.out.println();
        System.out.println("==============================================================");
        System.out.printf("%35s%n", title);
        System.out.println("==============================================================");
    }

    public static void printLine() {
        System.out.println("--------------------------------------------------------------");
    }

    public static void printDoubleLine() {
        System.out.println("==============================================================");
    }

}