import java.util.ArrayList;

/**
 * ============================================================
 * StudentManager.java
 * ------------------------------------------------------------
 * Manages all student records in the application.
 *
 * Responsibilities:
 * • Store student objects
 * • Add students
 * • Search students
 * • Update student information
 * • Delete students
 * • Generate statistics and reports
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
    // Getter Method
    // =========================================================

    /**
     * Returns the complete list of students.
     *
     * @return List of students
     */
    public ArrayList<Student> getStudents() {
        return students;
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
     * Checks whether any student records exist.
     *
     * @return true if no students are present,
     *         otherwise false
     */
    public boolean isEmpty() {
        return students.isEmpty();
    }

    /**
     * Displays a message when no student records exist.
     */
    public void displayEmptyMessage() {

        System.out.println();
        System.out.println("========================================");
        System.out.println(" No student records found.");
        System.out.println(" Please add students first.");
        System.out.println("========================================");
    }

    // =========================================================
    // Student Management Methods
    // =========================================================

    /**
     * Adds a new student to the student list.
     *
     * @param student Student object to be added
     */
    public void addStudent(Student student) {

        // Add student to the collection
        students.add(student);

        System.out.println();
        System.out.println("========================================");
        System.out.println(" Student added successfully.");
        System.out.println("========================================");
    }

    /**
     * Displays all students currently stored in the system.
     */
    public void displayStudents() {

        // Check whether any student exists
        if (isEmpty()) {
            displayEmptyMessage();
            return;
        }

        System.out.println();
        System.out.println("==============================================================");
        System.out.println("                    STUDENT RECORDS");
        System.out.println("==============================================================");

        // Display every student
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println("==============================================================");
        System.out.println("Total Students : " + getStudentCount());
        System.out.println("==============================================================");
    }

    // =========================================================
    // Search Methods
    // =========================================================

    /**
     * Searches for a student using the student ID.
     *
     * @param id Student ID to search
     * @return Student object if found, otherwise null
     */
    public Student searchStudentById(int id) {

        // Traverse the student list
        for (Student student : students) {

            // Check whether the entered ID matches
            if (student.getId() == id) {
                return student;
            }
        }

        // Student not found
        return null;
    }

    /**
     * Displays a student's details using the student ID.
     *
     * @param id Student ID
     */
    public void displayStudentById(int id) {

        Student student = searchStudentById(id);

        if (student == null) {

            System.out.println();
            System.out.println("========================================");
            System.out.println(" Student not found.");
            System.out.println("========================================");
            return;
        }

        System.out.println();
        System.out.println("============== STUDENT FOUND ==============");
        System.out.println(student);
        System.out.println("===========================================");
    }

    /**
     * Searches students using their name.
     *
     * Search is:
     * • Case-insensitive
     * • Partial matching supported
     *
     * Example:
     * "bha" will match "Bhavya"
     *
     * @param name Name to search
     */
    public void searchStudentByName(String name) {

        // Flag to check whether any student was found
        boolean found = false;

        System.out.println();
        System.out.println("============= SEARCH RESULTS =============");

        for (Student student : students) {

            // Convert both strings to lowercase
            if (student.getName()
                    .toLowerCase()
                    .contains(name.toLowerCase())) {

                System.out.println(student);
                found = true;
            }
        }

        // Display message if no student is found
        if (!found) {
            System.out.println("No students found.");
        }

        System.out.println("==========================================");
    }

    // =========================================================
    // Update Student Methods
    // =========================================================

    /**
     * Updates the marks of an existing student.
     *
     * @param id Student ID
     * @param english Updated English marks
     * @param mathematics Updated Mathematics marks
     * @param science Updated Science marks
     * @param computer Updated Computer marks
     * @param social Updated Social Science marks
     */
    public void updateStudentMarks(int id,
                                   double english,
                                   double mathematics,
                                   double science,
                                   double computer,
                                   double social) {

        // Search the student using the ID
        Student student = searchStudentById(id);

        // Check whether the student exists
        if (student == null) {

            System.out.println();
            System.out.println("========================================");
            System.out.println(" Student not found.");
            System.out.println("========================================");
            return;
        }

        // Update subject marks
        student.setEnglish(english);
        student.setMathematics(mathematics);
        student.setScience(science);
        student.setComputer(computer);
        student.setSocial(social);

        System.out.println();
        System.out.println("========================================");
        System.out.println(" Student marks updated successfully.");
        System.out.println("========================================");
    }

    // =========================================================
    // Delete Student Method
    // =========================================================

    /**
     * Deletes a student from the student list.
     *
     * @param id Student ID to be deleted
     */
    public void deleteStudent(int id) {

        // Search the student first
        Student student = searchStudentById(id);

        // Check whether the student exists
        if (student == null) {

            System.out.println();
            System.out.println("========================================");
            System.out.println(" Student not found.");
            System.out.println("========================================");
            return;
        }

        // Remove the student from the collection
        students.remove(student);

        System.out.println();
        System.out.println("========================================");
        System.out.println(" Student deleted successfully.");
        System.out.println("========================================");
    }
}