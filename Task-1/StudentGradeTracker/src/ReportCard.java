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

        System.out.println();
        System.out.println("==================================================");
        System.out.println("                STUDENT REPORT CARD");
        System.out.println("==================================================");

        // ---------------- Student Information ----------------

        System.out.println("Student ID        : " + student.getId());
        System.out.println("Student Name      : " + student.getName());

        System.out.println("--------------------------------------------------");

        // ---------------- Subject Marks ----------------

        System.out.printf("English           : %.2f%n", student.getEnglish());
        System.out.printf("Mathematics       : %.2f%n", student.getMathematics());
        System.out.printf("Science           : %.2f%n", student.getScience());
        System.out.printf("Computer          : %.2f%n", student.getComputer());
        System.out.printf("Social Science    : %.2f%n", student.getSocial());

        System.out.println("--------------------------------------------------");

        // ---------------- Academic Summary ----------------

        System.out.printf("Total Marks       : %.2f%n", student.getTotalMarks());
        System.out.printf("Average Marks     : %.2f%n", student.getAverage());
        System.out.printf("Highest Marks     : %.2f%n", student.getHighestMarks());
        System.out.printf("Lowest Marks      : %.2f%n", student.getLowestMarks());

        System.out.println("Grade             : " + student.getGrade());

        System.out.println("==================================================");
    }
}