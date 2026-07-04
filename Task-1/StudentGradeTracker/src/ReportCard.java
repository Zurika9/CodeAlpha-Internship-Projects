/**
 * ============================================================
 * ReportCard.java
 * ------------------------------------------------------------
 * Displays a formatted report card for a student.
 *
 * Responsibilities:
 * • Display student information
 * • Display subject-wise marks
 * • Display total marks
 * • Display average marks
 * • Display highest marks
 * • Display lowest marks
 * • Display grade
 *
 * Project : Student Grade Tracker
 * Author  : Bhavya Shukla
 * ============================================================
 */

public class ReportCard {

    /**
     * Displays the report card of a student.
     *
     * @param student Student object whose report card is to be displayed
     */
    public static void displayReport(Student student) {

        ConsoleUI.printTitle("STUDENT REPORT CARD");

        // =====================================================
        // Student Information
        // =====================================================

        ConsoleUI.printField("Student ID", student.getId());
        ConsoleUI.printField("Student Name", student.getName());

        ConsoleUI.printSeparator();

        // =====================================================
        // Subject Marks
        // =====================================================

        ConsoleUI.printField("English", String.format("%.2f", student.getEnglish()));
        ConsoleUI.printField("Mathematics", String.format("%.2f", student.getMathematics()));
        ConsoleUI.printField("Science", String.format("%.2f", student.getScience()));
        ConsoleUI.printField("Computer", String.format("%.2f", student.getComputer()));
        ConsoleUI.printField("Social Science", String.format("%.2f", student.getSocial()));

        ConsoleUI.printSeparator();

        // =====================================================
        // Academic Summary
        // =====================================================

        ConsoleUI.printField("Total Marks", String.format("%.2f", student.getTotalMarks()));
        ConsoleUI.printField("Average Marks", String.format("%.2f", student.getAverage()));
        ConsoleUI.printField("Highest Marks", String.format("%.2f", student.getHighestMarks()));
        ConsoleUI.printField("Lowest Marks", String.format("%.2f", student.getLowestMarks()));
        ConsoleUI.printField("Grade", student.getGrade());

        ConsoleUI.printBorder();
    }
}