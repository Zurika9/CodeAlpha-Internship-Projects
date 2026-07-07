/**
 * Utility class for displaying formatted console output.

 * Provides reusable methods for printing titles,
 * separators, and other UI elements to maintain
 * a consistent console interface throughout the application.
 *
 * @author Bhavya Shukla
 * @version 1.0
 */
public final class ConsoleUI {

    /**
     * Prevent instantiation of this utility class.
     */
    private ConsoleUI() {
    }

    /**
     * Prints a formatted section title.
     *
     * @param title Title to display
     */
    public static void printTitle(String title) {

        System.out.println();
        printDoubleLine();
        System.out.printf("%55s%n", title);
        printDoubleLine();
    }

    /**
     * Prints a single horizontal separator.
     */
    public static void printLine() {
        System.out.println("----------------------------------------------------------------------------------------------");
    }

    /**
     * Prints a double horizontal separator.
     */
    public static void printDoubleLine() {
        System.out.println("==============================================================================================");
    }
}