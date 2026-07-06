import java.util.ArrayList;

/**
 * ============================================================
 * StudentManager.java
 * ------------------------------------------------------------
 * Manages all student records in the application.
 *
 * Responsibilities:
 * • Store student records
 * • Add new students
 * • Display student records
 * • Search students
 * • Update student information
 * • Delete student records
 * • Generate reports and statistics
 *
 * Project : Student Grade Tracker
 * Author  : Bhavya Shukla
 * ============================================================
 */
public class StudentManager {

    // =========================================================
    // Instance Variables
    // =========================================================

    /**
     * Stores all student records.
     */
    private ArrayList<Student> students;

    // =========================================================
    // Constructor
    // =========================================================

    /**
     * Creates a StudentManager object and initializes
     * the student collection.
     */
    public StudentManager() {

        students = new ArrayList<>();
    }

    // =========================================================
    // Getter / Setter Methods
    // =========================================================

    /**
     * Returns the complete list of students.
     *
     * @return List of students
     */
    public ArrayList<Student> getStudents() {
        return students;
    }

    /**
     * Replaces the current student list.
     *
     * Mainly used while loading student records
     * from the data file.
     *
     * @param students List of loaded students
     */
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    // =========================================================
    // Utility Methods
    // =========================================================

    /**
     * Returns the total number of students.
     *
     * @return Number of students
     */
    public int getStudentCount() {
        return students.size();
    }

    /**
     * Checks whether the student list is empty.
     *
     * @return true if no students exist
     */
    public boolean isEmpty() {
        return students.isEmpty();
    }

    /**
     * Displays a warning when no student records exist.
     */
    public void displayEmptyMessage() {

        ConsoleUI.showWarning(
                "No student records found.\nPlease add students first."
        );
    }

    // =========================================================
    // Student Management Methods
    // =========================================================

    /**
     * Adds a new student to the collection.
     *
     * Duplicate student IDs are not allowed.
     *
     * @param student Student object
     */
    public void addStudent(Student student) {

        // Check whether the student ID already exists
        if (searchStudentById(student.getId()) != null) {

            ConsoleUI.showError(
                    "Student ID already exists."
            );

            return;
        }

        // Add student to the collection
        students.add(student);

        ConsoleUI.showSuccess(
                "Student added successfully."
        );
    }

    /**
     * Displays all student records.
     */
    public void displayStudents() {

        // Check whether records exist
        if (isEmpty()) {
            displayEmptyMessage();
            return;
        }

        ConsoleUI.printTitle("STUDENT RECORDS");

        ConsoleUI.printStudentTableHeader();

        // Display every student
        for (Student student : students) {
            ConsoleUI.printStudent(student);
        }

        ConsoleUI.printStudentTableFooter(
                getStudentCount()
        );
    }

    // =========================================================
    // Search Methods
    // =========================================================
    /**
     * Searches for a student using the student ID.
     *
     * @param id Student ID
     * @return Student object if found, otherwise null
     */
    public Student searchStudentById(int id) {

        for (Student student : students) {

            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }

    /**
     * Displays a student's complete report using
     * the student ID.
     *
     * @param id Student ID
     */
    public void displayStudentById(int id) {

        Student student = searchStudentById(id);

        if (student == null) {

            ConsoleUI.showError(
                    "Student not found."
            );

            return;
        }

        ReportCard.displayReport(student);
    }

    /**
     * Searches students using their name.
     *
     * Search is:
     * • Case-insensitive
     * • Partial matching supported
     *
     * Example:
     * "bha" matches "Bhavya"
     *
     * @param name Student name
     */
    public void searchStudentByName(String name) {

        if (isEmpty()) {

            displayEmptyMessage();
            return;
        }

        int foundCount = 0;

        ConsoleUI.printTitle("SEARCH RESULTS");

        ConsoleUI.printStudentTableHeader();

        for (Student student : students) {

            if (student.getName()
                    .toLowerCase()
                    .contains(name.toLowerCase())) {

                ConsoleUI.printStudent(student);
                foundCount++;
            }
        }

        if (foundCount == 0) {

            ConsoleUI.showWarning(
                    "No students found."
            );

            return;
        }

        ConsoleUI.printStudentTableFooter(foundCount);
    }

    // =========================================================
    // Update Student Methods
    // =========================================================

    /**
     * Updates marks of an existing student.
     *
     * @param id Student ID
     * @param english English marks
     * @param mathematics Mathematics marks
     * @param science Science marks
     * @param computer Computer marks
     * @param social Social Science marks
     */
    public void updateStudentMarks(int id,
                                   double english,
                                   double mathematics,
                                   double science,
                                   double computer,
                                   double social) {

        Student student = searchStudentById(id);

        if (student == null) {

            ConsoleUI.showError(
                    "Student not found."
            );

            return;
        }

        student.setEnglish(english);
        student.setMathematics(mathematics);
        student.setScience(science);
        student.setComputer(computer);
        student.setSocial(social);

        ConsoleUI.showSuccess(
                "Student marks updated successfully."
        );
    }

    // =========================================================
    // Delete Student Method
    // =========================================================

    /**
     * Deletes a student from the collection.
     *
     * @param id Student ID
     */
    public void deleteStudent(int id) {

        Student student = searchStudentById(id);

        if (student == null) {

            ConsoleUI.showError(
                    "Student not found."
            );

            return;
        }

        students.remove(student);

        ConsoleUI.showSuccess(
                "Student deleted successfully."
        );
    }

    // =========================================================
    // Statistics Methods
    // =========================================================

    /**
     * Displays class statistics.
     */
    public void displayStatistics() {

        if (isEmpty()) {

            displayEmptyMessage();
            return;
        }

        double totalAverage = 0;

        double highestAverage = Double.MIN_VALUE;
        double lowestAverage = Double.MAX_VALUE;

        Student topper = null;
        Student lowestPerformer = null;

        for (Student student : students) {

            double average = student.getAverage();

            totalAverage += average;

            if (average > highestAverage) {

                highestAverage = average;
                topper = student;
            }

            if (average < lowestAverage) {

                lowestAverage = average;
                lowestPerformer = student;
            }
        }

        ConsoleUI.printTitle("CLASS STATISTICS");

        ConsoleUI.printField("Total Students", getStudentCount());
        ConsoleUI.printField(
                "Class Average",
                String.format("%.2f", totalAverage / getStudentCount())
        );

        ConsoleUI.printSeparator();

        if (topper != null) {

            ConsoleUI.printField("Topper", topper.getName());
            ConsoleUI.printField(
                    "Highest Average",
                    String.format("%.2f", topper.getAverage())
            );
        }

        ConsoleUI.printSeparator();

        if (lowestPerformer != null) {

            ConsoleUI.printField("Lowest Performer", lowestPerformer.getName());
            ConsoleUI.printField(
                    "Lowest Average",
                    String.format("%.2f", lowestPerformer.getAverage())
            );
        }

        ConsoleUI.printBorder();
    }

    // =========================================================
    // Report Methods
    // =========================================================

    /**
     * Displays the class topper.
     */
    public void displayTopper() {

        if (isEmpty()) {

            displayEmptyMessage();
            return;
        }

        Student topper = students.get(0);

        for (Student student : students) {

            if (student.getAverage() > topper.getAverage()) {

                topper = student;
            }
        }

        ReportCard.displayReport(topper);
    }

    /**
     * Displays the grade distribution.
     */
    public void displayGradeDistribution() {

        if (isEmpty()) {

            displayEmptyMessage();
            return;
        }

        int gradeA = 0;
        int gradeB = 0;
        int gradeC = 0;
        int gradeD = 0;
        int gradeF = 0;

        for (Student student : students) {

            switch (student.getGrade()) {

                case "A":
                    gradeA++;
                    break;

                case "B":
                    gradeB++;
                    break;

                case "C":
                    gradeC++;
                    break;

                case "D":
                    gradeD++;
                    break;

                default:
                    gradeF++;
            }
        }

        ConsoleUI.printTitle("GRADE DISTRIBUTION");

        ConsoleUI.printField("Grade A", gradeA);
        ConsoleUI.printField("Grade B", gradeB);
        ConsoleUI.printField("Grade C", gradeC);
        ConsoleUI.printField("Grade D", gradeD);
        ConsoleUI.printField("Grade F", gradeF);

        ConsoleUI.printBorder();
    }

    // =========================================================
// Filter Students By Grade
// =========================================================

    /**
     * Displays all students belonging to
     * the specified grade.
     *
     * @param grade Grade to filter
     */
    public void filterStudentsByGrade(String grade) {

        if (isEmpty()) {

            displayEmptyMessage();
            return;
        }

        boolean found = false;

        ConsoleUI.printTitle(
                "GRADE " + grade.toUpperCase() + " STUDENTS"
        );

        for (Student student : students) {

            if (student.getGrade()
                    .equalsIgnoreCase(grade)) {

                System.out.println(student);

                found = true;
            }
        }

        if (!found) {

            ConsoleUI.showInfo(
                    "No students found with Grade "
                            + grade.toUpperCase()
            );
        }
    }

    // =========================================================
    // Sorting Methods
    // =========================================================

    /**
     * Sorts students in descending order of average marks.
     */
    public void sortStudentsByAverage() {

        if (isEmpty()) {

            displayEmptyMessage();
            return;
        }

        students.sort(
                (student1, student2) ->
                        Double.compare(
                                student2.getAverage(),
                                student1.getAverage()
                        )
        );

        ConsoleUI.showSuccess(
                "Students sorted by average marks."
        );
    }

    /**
     * Displays student rankings.
     */
    public void displayRankings() {

        if (isEmpty()) {

            displayEmptyMessage();
            return;
        }

        sortStudentsByAverage();

        ConsoleUI.printTitle("CLASS RANKINGS");

        ConsoleUI.printTableBorder();

        System.out.printf(
                "%-8s %-25s %-12s %-10s%n",
                "Rank",
                "Student",
                "Average",
                "Grade"
        );

        ConsoleUI.printTableBorder();

        int rank = 1;

        for (Student student : students) {

            System.out.printf(
                    "%-8d %-25s %-12.2f %-10s%n",
                    rank++,
                    student.getName(),
                    student.getAverage(),
                    student.getGrade()
            );
        }

        ConsoleUI.printTableBorder();
    }

}