import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * ============================================================
 * Main.java
 * ------------------------------------------------------------
 * Entry point of the Student Grade Tracker application.
 *
 * Responsibilities:
 * • Initialize the application
 * • Display the main menu
 * • Handle user interaction
 * • Coordinate all application modules
 *
 * Project : Student Grade Tracker
 * Author  : Bhavya Shukla
 * ============================================================
 */
public class Main {

    // =========================================================
    // Instance Variables
    // =========================================================

    /**
     * Scanner object used throughout the application.
     */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Handles student management operations.
     */
    private static final StudentManager studentManager =
            new StudentManager();

    /**
     * Handles file operations.
     */
    private static final FileManager fileManager =
            new FileManager();

    /**
     * Stores the user's menu choice.
     */
    private static int choice;

    /**
     * Controls the application loop.
     */
    private static boolean running = true;

    // =========================================================
    // Main Method
    // =========================================================

    /**
     * Application entry point.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        initializeApplication();

        while (running) {

            displayMainMenu();

            readMenuChoice();

            handleMenuChoice();

            if (running) {

                pressEnterToContinue();
            }
        }
        shutdownApplication();
    }

    // =========================================================
    // Application Initialization
    // =========================================================

    /**
     * Initializes the application.
     */
    private static void initializeApplication() {

        ConsoleUI.showWelcomeScreen();

        studentManager.setStudents(
                fileManager.loadStudents()
        );

        ConsoleUI.showInfo(
                "Application initialized successfully."
        );
    }

    // =========================================================
// Main Menu
// =========================================================

    /**
     * Displays the main menu.
     */
    private static void displayMainMenu() {

        ConsoleUI.printTitle("STUDENT GRADE TRACKER");

        System.out.println(" 1.  Add Student");
        System.out.println(" 2.  View All Students");
        System.out.println(" 3.  Search Student by ID");
        System.out.println(" 4.  Search Student by Name");
        System.out.println(" 5.  Update Student Marks");
        System.out.println(" 6.  Delete Student");
        System.out.println(" 7.  Generate Student Report Card");
        System.out.println(" 8.  Display Class Statistics");
        System.out.println(" 9.  Sort Students By Average");
        System.out.println("10.  Display Class Topper");
        System.out.println("11.  Display Student Rankings");
        System.out.println("12.  Filter Students By Grade");
        System.out.println("13.  Display Grade Distribution");
        System.out.println("14.  Export Student Data To CSV");
        System.out.println("15.  Save Student Records");
        System.out.println("16.  Exit Application");

        ConsoleUI.printBorder();


    }


    // =========================================================
    // Input Methods
    // =========================================================

    /**
     * Reads the user's menu choice.
     */
    private static void readMenuChoice() {

        while (true) {

            try {

                System.out.print("Enter your choice : ");

                choice = scanner.nextInt();

                scanner.nextLine();

                break;
            }

            catch (InputMismatchException exception) {

                ConsoleUI.showError(
                        "Please enter a valid number."
                );

                scanner.nextLine();
            }
        }
    }

    /**
     * Reads an integer from the user.
     *
     * @param prompt Message displayed to the user
     * @return Integer entered by the user
     */
    private static int readInt(String prompt) {

        while (true) {

            try {

                System.out.print(prompt);

                int value = scanner.nextInt();

                scanner.nextLine();

                return value;

            } catch (InputMismatchException exception) {

                ConsoleUI.showError(
                        "Please enter a valid integer."
                );

                scanner.nextLine();
            }
        }
    }

    /**
     * Reads a decimal number from the user.
     *
     * @param prompt Message displayed to the user
     * @return Decimal value entered by the user
     */
    private static double readDouble(String prompt) {

        while (true) {

            try {

                System.out.print(prompt);

                double value = scanner.nextDouble();

                scanner.nextLine();

                return value;

            } catch (InputMismatchException exception) {

                ConsoleUI.showError(
                        "Please enter a valid numeric value."
                );

                scanner.nextLine();
            }
        }
    }

    /**
     * Reads a non-empty string from the user.
     *
     * @param prompt Message displayed to the user
     * @return String entered by the user
     */
    private static String readString(String prompt) {

        while (true) {

            System.out.print(prompt);

            String value = scanner.nextLine().trim();

            if (!value.isEmpty()) {

                return value;
            }

            ConsoleUI.showWarning(
                    "Input cannot be empty."
            );
        }
    }

    // =========================================================
    // Utility Methods
    // =========================================================

    /**
     * Pauses the application until the user presses Enter.
     */
    private static void pressEnterToContinue() {

        ConsoleUI.printSeparator();

        System.out.print("Press Enter to return to the Main Menu...");

        scanner.nextLine();
    }

    // =========================================================
    // Menu Handling
    // =========================================================

    /**
     * Executes the selected menu option.
     */
    private static void handleMenuChoice() {

        switch (choice) {

            case 1:
                addStudent();
                break;

            case 2:
                studentManager.displayStudents();
                break;

            case 3:
                searchStudentById();
                break;

            case 4:
                searchStudentByName();
                break;

            case 5:
                updateStudent();
                break;

            case 6:
                deleteStudent();
                break;

            case 7:
                generateReportCard();
                break;

            case 8:
                studentManager.displayStatistics();
                break;

            case 9:
                studentManager.sortStudentsByAverage();
                break;

            case 10:
                studentManager.displayTopper();
                break;

            case 11:
                studentManager.displayRankings();
                break;

            case 12:
                filterStudentsByGrade();
                break;

            case 13:
                studentManager.displayGradeDistribution();
                break;

            case 14:
                exportStudentDataToCSV();
                break;

            case 15:
                fileManager.saveStudents(studentManager.getStudents());
                break;

            case 16:
                exitApplication();
                break;

            default:

                ConsoleUI.showWarning(
                        "Invalid menu choice.\nPlease try again."
                );
        }
    }


    // =========================================================
    // Add Student
    // =========================================================

    /**
     * Adds a new student to the system.
     */
    private static void addStudent() {

        ConsoleUI.printTitle("ADD NEW STUDENT");

        int id = readStudentId();

        String name = readStudentName();

        double english = readMarks("English");

        double mathematics = readMarks("Mathematics");

        double science = readMarks("Science");

        double computer = readMarks("Computer");

        double social = readMarks("Social Science");

        Student student = new Student(
                id,
                name,
                english,
                mathematics,
                science,
                computer,
                social
        );

        studentManager.addStudent(student);
    }

    // =========================================================
    // Search Student By ID
    // =========================================================

    /**
     * Searches for a student using the student ID.
     */
    private static void searchStudentById() {

        ConsoleUI.printTitle(
                "SEARCH STUDENT BY ID"
        );

        int id = readStudentId();

        Student student = studentManager.searchStudentById(id);

        if (student == null) {

            ConsoleUI.showError(
                    "Student not found."
            );

            return;
        }

        ReportCard.displayReport(student);
    }

    // =========================================================
// Search Student By Name
// =========================================================

    /**
     * Searches students using the student name.
     */
    private static void searchStudentByName() {

        ConsoleUI.printTitle(
                "SEARCH STUDENT BY NAME"
        );

        String name = readString(
                "Enter Student Name         : "
        );

        studentManager.searchStudentByName(name);
    }

    // =========================================================
// Update Student Marks
// =========================================================

    /**
     * Updates the marks of an existing student.
     */
    private static void updateStudent() {

        ConsoleUI.printTitle(
                "UPDATE STUDENT MARKS"
        );

        int id = readStudentId();

        Student student =
                studentManager.searchStudentById(id);

        if (student == null) {

            ConsoleUI.showError(
                    "Student not found."
            );

            return;
        }

        ConsoleUI.showInfo(
                "Current Student Details"
        );

        ReportCard.displayReport(student);
        ConsoleUI.showInfo(
                "Enter the updated marks below."
        );

        System.out.println();

        double english =
                readMarks("English");

        double mathematics =
                readMarks("Mathematics");

        double science =
                readMarks("Science");

        double computer =
                readMarks("Computer");

        double social =
                readMarks("Social Science");

        studentManager.updateStudentMarks(
                id,
                english,
                mathematics,
                science,
                computer,
                social
        );
    }

    // =========================================================
// Delete Student
// =========================================================

    /**
     * Deletes an existing student from the system.
     */
    private static void deleteStudent() {

        ConsoleUI.printTitle(
                "DELETE STUDENT"
        );

        int id = readStudentId();

        Student student =
                studentManager.searchStudentById(id);

        if (student == null) {

            ConsoleUI.showError(
                    "Student not found."
            );

            return;
        }

        ConsoleUI.showInfo(
                "Student Details"
        );

        ReportCard.displayReport(student);

        System.out.println();

        // ---------------------------------------------------------
// Confirm Delete Operation
// ---------------------------------------------------------

        String confirmation;

        while (true) {

            confirmation = readString(
                    "Are you sure you want to delete this student? (Y/N) : "
            );

            if (confirmation.equalsIgnoreCase("Y") ||
                    confirmation.equalsIgnoreCase("N")) {

                break;
            }

            ConsoleUI.showWarning(
                    "Please enter Y or N."
            );
        }

// Delete only if confirmed
        if (confirmation.equalsIgnoreCase("Y")) {

            studentManager.deleteStudent(id);

        } else {

            ConsoleUI.showInfo(
                    "Delete operation cancelled."
            );
        }
    }

    // =========================================================
// Generate Student Report Card
// =========================================================

    /**
     * Generates and displays the report card
     * of a selected student.
     */
    private static void generateReportCard() {

        ConsoleUI.printTitle(
                "GENERATE STUDENT REPORT CARD"
        );

        int id = readStudentId();

        Student student =
                studentManager.searchStudentById(id);

        if (student == null) {

            ConsoleUI.showError(
                    "Student not found."
            );

            return;
        }

        ReportCard.displayReport(student);
    }

    // =========================================================
// Filter Students By Grade
// =========================================================

    /**
     * Filters students based on grade.
     */
    private static void filterStudentsByGrade() {

        ConsoleUI.printTitle(
                "FILTER STUDENTS BY GRADE"
        );

        String grade = readString(
                "Enter Grade (A/B/C/D/F) : "
        ).toUpperCase();

        while (!grade.matches("[ABCDF]")) {

            ConsoleUI.showWarning(
                    "Please enter A, B, C, D or F."
            );

            grade = readString(
                    "Enter Grade (A/B/C/D/F) : "
            ).toUpperCase();
        }

        studentManager.filterStudentsByGrade(
                grade
        );
    }

    // =========================================================
// Export Student Data To CSV
// =========================================================

    /**
     * Exports all student records to a CSV file.
     */
    private static void exportStudentDataToCSV() {

        ConsoleUI.printTitle(
                "EXPORT STUDENT DATA TO CSV"
        );

        fileManager.exportStudentDataToCSV(
                studentManager.getStudents()
        );
    }

    // =========================================================
// Exit Application
// =========================================================

    /**
     * Exits the application after optionally
     * saving student records.
     */
    private static void exitApplication() {

        ConsoleUI.printTitle(
                "EXIT APPLICATION"
        );

        while (true) {

            System.out.println("1. Save and Exit");
            System.out.println("2. Exit Without Saving");
            System.out.println("3. Cancel");

            ConsoleUI.printSeparator();

            int option = readInt(
                    "Enter your choice          : "
            );

            switch (option) {

                case 1:

                    fileManager.saveStudents(
                            studentManager.getStudents()
                    );

                    ConsoleUI.showSuccess(
                            "Thank you for using Student Grade Tracker."
                    );

                    running = false;
                    return;

                case 2:

                    ConsoleUI.showWarning(
                            "Exiting without saving changes."
                    );

                    ConsoleUI.showSuccess(
                            "Thank you for using Student Grade Tracker."
                    );

                    running = false;
                    return;

                case 3:

                    ConsoleUI.showInfo(
                            "Exit cancelled."
                    );

                    return;

                default:

                    ConsoleUI.showWarning(
                            "Please select a valid option."
                    );
            }
        }
    }

    /**
     * Reads the student ID.
     *
     * @return Student ID
     */
    private static int readStudentId() {

        return readInt(
                "Enter Student ID           : "
        );
    }

    /**
     * Reads the student name.
     *
     * @return Student name
     */
    private static String readStudentName() {

        return readString(
                "Enter Student Name         : "
        );
    }

    /**
     * Reads marks for a subject.
     *
     * Marks must be between 0 and 100.
     *
     * @param subject Subject name
     * @return Marks obtained
     */
    private static double readMarks(String subject) {

        while (true) {

            double marks = readDouble(
                    String.format("Enter %-20s : ", subject + " Marks")
            );

            if (marks >= 0 && marks <= 100) {

                return marks;
            }

            ConsoleUI.showWarning(
                    "Marks must be between 0 and 100."
            );
        }
    }

    // =========================================================
    // Shutdown
    // =========================================================

    /**
     * Closes the application safely.
     */
    private static void shutdownApplication() {

        scanner.close();

        ConsoleUI.showExitScreen();
    }

}