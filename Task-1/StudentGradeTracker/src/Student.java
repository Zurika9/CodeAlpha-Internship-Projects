/**
 * ============================================================
 * Student.java
 * ------------------------------------------------------------
 * Represents a student and stores personal information along
 * with marks obtained in five different subjects.
 *
 * Responsibilities:
 * • Store student details
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
    // Constant
    // =========================================================

    /**
     * Total number of subjects.
     */
    private static final int TOTAL_SUBJECTS = 5;

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
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the student name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns English marks.
     */
    public double getEnglish() {
        return english;
    }

    /**
     * Returns Mathematics marks.
     */
    public double getMathematics() {
        return mathematics;
    }

    /**
     * Returns Science marks.
     */
    public double getScience() {
        return science;
    }

    /**
     * Returns Computer marks.
     */
    public double getComputer() {
        return computer;
    }

    /**
     * Returns Social Science marks.
     */
    public double getSocial() {
        return social;
    }

    // =========================================================
    // Setter Methods
    // =========================================================

    /**
     * Updates English marks.
     */
    public void setEnglish(double english) {
        this.english = english;
    }

    /**
     * Updates Mathematics marks.
     */
    public void setMathematics(double mathematics) {
        this.mathematics = mathematics;
    }

    /**
     * Updates Science marks.
     */
    public void setScience(double science) {
        this.science = science;
    }

    /**
     * Updates Computer marks.
     */
    public void setComputer(double computer) {
        this.computer = computer;
    }

    /**
     * Updates Social Science marks.
     */
    public void setSocial(double social) {
        this.social = social;
    }

    // =========================================================
    // Business Logic
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
     * Calculates average marks.
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
     * Determines the student's grade.
     *
     * Grade Scale:
     *
     * A : 90 and above
     * B : 80 – 89
     * C : 70 – 79
     * D : 60 – 69
     * F : Below 60
     *
     * @return Student Grade
     */
    public String getGrade() {

        double average = getAverage();

        if (average >= 90)
            return "A";

        if (average >= 80)
            return "B";

        if (average >= 70)
            return "C";

        if (average >= 60)
            return "D";

        return "F";
    }

    // =========================================================
    // Display Method
    // =========================================================

    /**
     * Returns formatted student information.
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