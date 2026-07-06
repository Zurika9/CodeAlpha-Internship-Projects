import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;


/**
 * ============================================================
 * FileManager.java
 * ------------------------------------------------------------
 * Handles all file operations for the Student Grade Tracker.
 *
 * Responsibilities:
 * • Save student records
 * • Load student records
 * • Manage application data files
 *
 * Project : Student Grade Tracker
 * Author  : Bhavya Shukla
 * ============================================================
 */
public class FileManager {

    // =========================================================
    // Constants
    // =========================================================

    /**
     * Name of the file used to store student records.
     */
    private static final String FILE_NAME = "grades.txt";

    // =========================================================
    // Constructor
    // =========================================================

    /**
     * Default constructor.
     */
    public FileManager() {

        // No initialization required at present.
    }

    // =========================================================
    // Utility Methods
    // =========================================================

    /**
     * Returns the data file used by the application.
     *
     * @return File object representing grades.txt
     */
    public static File getDataFile() {

        return new File(FILE_NAME);
    }

    /**
     * Creates the data file if it does not already exist.
     */

    public static void createFileIfNotExists() {

        File file = getDataFile();

        try {

            if (file.createNewFile()) {

                ConsoleUI.showSuccess(
                        "Data file created successfully."
                );
            }

        } catch (IOException exception) {

            ConsoleUI.showError(
                    "Error creating data file.\n"
                            + exception.getMessage()
            );
        }
    }

    // =========================================================
    // Save Methods
    // =========================================================

    /**
     * Saves all student records to the data file.
     *
     * File Format:
     *
     * ID,Name,English,Mathematics,Science,Computer,Social
     *
     * Example:
     * 101,Bhavya,95.0,88.0,91.0,97.0,90.0
     *
     * @param students List of students to save
     */
    public void saveStudents(ArrayList<Student> students) {

        // Ensure the data file exists
        createFileIfNotExists();

        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {

            // Write each student record
            for (Student student : students) {

                String record =
                        student.getId() + "," +
                                student.getName() + "," +
                                student.getEnglish() + "," +
                                student.getMathematics() + "," +
                                student.getScience() + "," +
                                student.getComputer() + "," +
                                student.getSocial();

                writer.println(record);

            }

            System.out.println();
            ConsoleUI.showSuccess(
                    "Student records saved successfully."
            );

        } catch (IOException exception) {

            ConsoleUI.showError(
                    "Error saving student records.\n"
                            + exception.getMessage()
            );
        }
    }

    // =========================================================
    // Export Student Data To CSV
    // =========================================================
    /**
     * Exports all student records to a CSV file.
     *
     * @param students List of students to export
     */
    public void exportStudentDataToCSV(
            ArrayList<Student> students) {

        final String REPORT_FILE =
                "student_report.csv";

        try (PrintWriter writer =
                     new PrintWriter(
                             new FileWriter(REPORT_FILE))) {

            // CSV Header
            writer.println(
                    "ID,Name,English,Mathematics,Science,Computer,Social,"
                            + "Total,Average,Highest,Lowest,Grade"
            );

            // Student Records
            for (Student student : students) {

                writer.printf(
                        "%d,%s,%.2f,%.2f,%.2f,%.2f,%.2f,%.2f,%.2f,%.2f,%.2f,%s%n",

                        student.getId(),
                        student.getName(),
                        student.getEnglish(),
                        student.getMathematics(),
                        student.getScience(),
                        student.getComputer(),
                        student.getSocial(),
                        student.getTotalMarks(),
                        student.getAverage(),
                        student.getHighestMarks(),
                        student.getLowestMarks(),
                        student.getGrade()
                );
            }

            ConsoleUI.showSuccess(
                    "Student data exported successfully.\n"
                            + "File : "
                            + REPORT_FILE
            );

        }

        catch (IOException exception) {

            ConsoleUI.showError(
                    "Unable to export student data."
            );
        }
    }

    /**
     * Converts one CSV record into a Student object.
     *
     * @param data CSV fields
     * @return Student object
     */
    private Student parseStudent(String[] data) {

        return new Student(

                Integer.parseInt(data[0]),

                data[1],

                Double.parseDouble(data[2]),
                Double.parseDouble(data[3]),
                Double.parseDouble(data[4]),
                Double.parseDouble(data[5]),
                Double.parseDouble(data[6])
        );
    }

    // =========================================================
    // Load Methods
    // =========================================================

    /**
     * Loads all student records from the data file.
     *
     * Each line in the file follows the format:
     *
     * ID,Name,English,Mathematics,Science,Computer,Social
     *
     * Example:
     * 101,Bhavya,95,88,91,97,90
     *
     * @return List of students loaded from the file
     */
    public ArrayList<Student> loadStudents() {

        // List to store loaded student records
        ArrayList<Student> students = new ArrayList<>();

        File file = getDataFile();

        // Return an empty list if the file does not exist
        if (!file.exists()) {

            createFileIfNotExists();

            return students;
        }

        try (Scanner scanner = new Scanner(file)) {

            // Read the file line by line
            while (scanner.hasNextLine()) {

                String line = scanner.nextLine().trim();

                // Ignore blank lines
                if (line.isEmpty()) {
                    continue;
                }

                // Split the CSV record
                String[] data = line.split(",");

                // Validate record format
                if (data.length != 7) {
                    continue;
                }

                // Create a Student object from the file data
                Student loadedStudent = parseStudent(data);

// Skip duplicate student IDs
                boolean exists = false;

                for (Student student : students) {

                    if (student.getId() == loadedStudent.getId()) {

                        exists = true;
                        break;
                    }
                }

                if (!exists) {

                    students.add(loadedStudent);
                }
            }

            System.out.println();
            ConsoleUI.showInfo(

                    "Student records loaded successfully.\n"

                            + "Total Records : "

                            + students.size()
            );

        } catch (FileNotFoundException exception) {

            ConsoleUI.showError(
                    "Data file could not be found."
            );
        }
        catch (NumberFormatException exception) {

            ConsoleUI.showError(
                    "Invalid student data found in "
                            + FILE_NAME
            );
        }
        catch (Exception exception) {

            ConsoleUI.showError(
                    "Unexpected error while loading student records.\n"
                            + exception.getMessage()
            );
        }

        return students;
    }
}