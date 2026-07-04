/**
 * ============================================================
 * ConsoleUI.java
 * ------------------------------------------------------------
 * Handles all console formatting and user interface display.
 *
 * Responsibilities:
 * • Display borders
 * • Display titles
 * • Display menus
 * • Display messages
 * • Display student tables
 * • Display welcome and exit screens
 *
 * Project : Student Grade Tracker
 * Author  : Bhavya Shukla
 * ============================================================
 */

public class ConsoleUI {

    // =========================================================
    // UI CONSTANTS
    // =========================================================

    /**
     * Width of normal screens.
     */
    private static final int SCREEN_WIDTH = 70;

    /**
     * Width of student tables.
     */
    private static final int TABLE_WIDTH = 110;

    /**
     * Border character.
     */
    private static final char BORDER_CHAR = '=';

    /**
     * Separator character.
     */
    private static final char SEPARATOR_CHAR = '-';

    // =========================================================
    // BASIC UTILITIES
    // =========================================================

    /**
     * Prints a blank line.
     */
    public static void blankLine() {
        System.out.println();
    }

    /**
     * Prints the standard border.
     */
    public static void printBorder() {
        System.out.println(String.valueOf(BORDER_CHAR).repeat(SCREEN_WIDTH));
    }

    /**
     * Prints a table border.
     */
    public static void printTableBorder() {
        System.out.println(String.valueOf(BORDER_CHAR).repeat(TABLE_WIDTH));
    }

    /**
     * Prints a separator.
     */
    public static void printSeparator() {
        System.out.println(String.valueOf(SEPARATOR_CHAR).repeat(SCREEN_WIDTH));
    }

    /**
     * Prints centered text.
     *
     * @param text Text to display
     */
    public static void printCentered(String text) {

        int padding = (SCREEN_WIDTH - text.length()) / 2;

        if (padding < 0) {
            padding = 0;
        }

        System.out.println(" ".repeat(padding) + text);
    }

    /**
     * Prints a label-value pair.
     *
     * @param label Display label
     * @param value Display value
     */
    public static void printField(String label, Object value) {

        System.out.printf("%-20s : %s%n", label, value);
    }

    // =========================================================
    // TITLES
    // =========================================================

    /**
     * Prints a formatted title.
     *
     * @param title Screen title
     */
    public static void printTitle(String title) {

        blankLine();
        printBorder();
        printCentered(title);
        printBorder();
    }

    /**
     * Prints a formatted subtitle.
     *
     * @param subtitle Subtitle
     */
    public static void printSubTitle(String subtitle) {

        blankLine();
        printCentered(subtitle);
        printSeparator();
    }

    // =========================================================
    // MESSAGE BOXES
    // =========================================================

    /**
     * Displays a success message.
     */
    public static void showSuccess(String message) {

        printTitle("SUCCESS");
        System.out.println(message);
        printBorder();
    }

    /**
     * Displays an error message.
     */
    public static void showError(String message) {

        printTitle("ERROR");
        System.out.println(message);
        printBorder();
    }

    /**
     * Displays an information message.
     */
    public static void showInfo(String message) {

        printTitle("INFORMATION");
        System.out.println(message);
        printBorder();
    }

    /**
     * Displays a warning message.
     */
    public static void showWarning(String message) {

        printTitle("WARNING");
        System.out.println(message);
        printBorder();
    }

    // =========================================================
    // APPLICATION SCREENS
    // =========================================================

    /**
     * Displays the welcome screen.
     */
    public static void showWelcomeScreen() {

        printBorder();
        printCentered("STUDENT GRADE TRACKER");
        printCentered("CodeAlpha Java Programming Internship");
        printBorder();
    }

    /**
     * Displays the exit screen.
     */
    public static void showExitScreen() {

        printBorder();
        printCentered("Thank you for using Student Grade Tracker");
        printCentered("Have a Great Day!");
        printBorder();
    }

    // =========================================================
    // STUDENT TABLE
    // =========================================================

    /**
     * Prints the student table header.
     */
    public static void printStudentTableHeader() {

        printTableBorder();

        System.out.printf(
                "%-6s %-22s %-8s %-8s %-8s %-8s %-8s %-10s %-10s %-8s%n",
                "ID",
                "Name",
                "English",
                "Math",
                "Science",
                "Comp",
                "Social",
                "Total",
                "Average",
                "Grade"
        );

        printTableBorder();
    }

    /**
     * Prints one student record.
     *
     * @param student Student object
     */
    public static void printStudent(Student student) {

        System.out.printf(
                "%-6d %-22s %-8.0f %-8.0f %-8.0f %-8.0f %-8.0f %-10.0f %-10.2f %-8s%n",
                student.getId(),
                student.getName(),
                student.getEnglish(),
                student.getMathematics(),
                student.getScience(),
                student.getComputer(),
                student.getSocial(),
                student.getTotalMarks(),
                student.getAverage(),
                student.getGrade()
        );
    }

    /**
     * Prints the student table footer.
     *
     * @param totalStudents Total number of students
     */
    public static void printStudentTableFooter(int totalStudents) {

        printTableBorder();
        System.out.println("Total Students : " + totalStudents);
        printTableBorder();
    }

}