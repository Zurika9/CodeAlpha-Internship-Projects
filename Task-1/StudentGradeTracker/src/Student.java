/**
 * ============================================================
 * Student.java
 * ------------------------------------------------------------
 * Represents a student and stores personal information along
 * with marks obtained in five different subjects.
 *
 * Responsibilities:
 * • Store student details
 * • Calculate total marks
 * • Calculate average marks
 * • Calculate highest marks
 * • Calculate lowest marks
 * • Determine grade
 *
 * Project : Student Grade Tracker
 * Author  : Bhavya Shukla
 * ============================================================
 */

public class Student {

    // =========================================================
    // Constants
    // =========================================================

    /**
     * Total number of subjects.
     */
    private static final int TOTAL_SUBJECTS = 5;

    /**
     * Grade boundaries.
     */
    private static final int GRADE_A = 90;
    private static final int GRADE_B = 80;
    private static final int GRADE_C = 70;
    private static final int GRADE_D = 60;

    // =========================================================
    // Student Information
    // =========================================================

    private int id;
    private String name;

    // =========================================================
    // Subject Marks
    // =========================================================

    private double english;
    private double mathematics;
    private double science;
    private double computer;
    private double social;

    // =========================================================
    // Constructor
    // =========================================================

    /**
     * Creates a Student object.
     *
     * @param id Student ID
     * @param name Student Name
     * @param english English Marks
     * @param mathematics Mathematics Marks
     * @param science Science Marks
     * @param computer Computer Marks
     * @param social Social Science Marks
     */
    public Student(int id,
                   String name,
                   double english,
                   double mathematics,
                   double science,
                   double computer,
                   double social) {

        this.id = id;
        this.name = name;

        this.english = english;
        this.mathematics = mathematics;
        this.science = science;
        this.computer = computer;
        this.social = social;
    }

    // =========================================================
    // Getter Methods
    // =========================================================

    /**
     * Returns the student ID.
     *
     * @return Student ID
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the student name.
     *
     * @return Student name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns English marks.
     *
     * @return English marks
     */
    public double getEnglish() {
        return english;
    }

    /**
     * Returns Mathematics marks.
     *
     * @return Mathematics marks
     */
    public double getMathematics() {
        return mathematics;
    }

    /**
     * Returns Science marks.
     *
     * @return Science marks
     */
    public double getScience() {
        return science;
    }

    /**
     * Returns Computer marks.
     *
     * @return Computer marks
     */
    public double getComputer() {
        return computer;
    }

    /**
     * Returns Social Science marks.
     *
     * @return Social Science marks
     */
    public double getSocial() {
        return social;
    }

    // =========================================================
    // Setter Methods
    // =========================================================

    /**
     * Updates English marks.
     *
     * Marks must be between 0 and 100.
     *
     * @param english English marks
     */
    public void setEnglish(double english) {

        if (english >= 0 && english <= 100) {
            this.english = english;
        }
    }

    /**
     * Updates Mathematics marks.
     *
     * Marks must be between 0 and 100.
     *
     * @param mathematics Mathematics marks
     */
    public void setMathematics(double mathematics) {

        if (mathematics >= 0 && mathematics <= 100) {
            this.mathematics = mathematics;
        }
    }

    /**
     * Updates Science marks.
     *
     * Marks must be between 0 and 100.
     *
     * @param science Science marks
     */
    public void setScience(double science) {

        if (science >= 0 && science <= 100) {
            this.science = science;
        }
    }

    /**
     * Updates Computer marks.
     *
     * Marks must be between 0 and 100.
     *
     * @param computer Computer marks
     */
    public void setComputer(double computer) {

        if (computer >= 0 && computer <= 100) {
            this.computer = computer;
        }
    }

    /**
     * Updates Social Science marks.
     *
     * Marks must be between 0 and 100.
     *
     * @param social Social Science marks
     */
    public void setSocial(double social) {

        if (social >= 0 && social <= 100) {
            this.social = social;
        }
    }

    // =========================================================
    // Business Logic Methods
    // =========================================================

    /**
     * Calculates the total marks obtained by the student.
     *
     * @return Total marks
     */
    public double getTotalMarks() {

        return english
                + mathematics
                + science
                + computer
                + social;
    }

    /**
     * Calculates the average marks obtained by the student.
     *
     * @return Average marks
     */
    public double getAverage() {

        return getTotalMarks() / TOTAL_SUBJECTS;
    }

    /**
     * Finds the highest marks among all subjects.
     *
     * @return Highest marks
     */
    public double getHighestMarks() {

        return Math.max(
                Math.max(english, mathematics),
                Math.max(
                        Math.max(science, computer),
                        social
                )
        );
    }

    /**
     * Finds the lowest marks among all subjects.
     *
     * @return Lowest marks
     */
    public double getLowestMarks() {

        return Math.min(
                Math.min(english, mathematics),
                Math.min(
                        Math.min(science, computer),
                        social
                )
        );
    }

    /**
     * Determines the student's grade based on average marks.
     *
     * Grade Scale:
     * A : 90 and above
     * B : 80 – 89
     * C : 70 – 79
     * D : 60 – 69
     * F : Below 60
     *
     * @return Student grade
     */
    public String getGrade() {

        double average = getAverage();

        if (average >= GRADE_A)
            return "A";

        if (average >= GRADE_B)
            return "B";

        if (average >= GRADE_C)
            return "C";

        if (average >= GRADE_D)
            return "D";

        return "F";
    }

    // =========================================================
    // Display Method
    // =========================================================

    /**
     * Returns student information as a formatted string.
     *
     * Note:
     * This method is primarily intended for debugging purposes.
     * A professional tabular display will be implemented in
     * StudentManager for the application's console UI.
     *
     * @return Formatted student information
     */
    @Override
    public String toString() {

        return String.format(
                "ID: %d | Name: %s | English: %.0f | Mathematics: %.0f | Science: %.0f | Computer: %.0f | Social: %.0f | Total: %.0f | Average: %.2f | Highest: %.0f | Lowest: %.0f | Grade: %s",
                id,
                name,
                english,
                mathematics,
                science,
                computer,
                social,
                getTotalMarks(),
                getAverage(),
                getHighestMarks(),
                getLowestMarks(),
                getGrade()
        );
    }
}