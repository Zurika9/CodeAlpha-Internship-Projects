# 🎓 Student Grade Tracker

![Java](https://img.shields.io/badge/Java-17+-orange)
![OOP](https://img.shields.io/badge/Object--Oriented%20Programming-Enabled-blue)
![Status](https://img.shields.io/badge/Version-1.0-success)
![Internship](https://img.shields.io/badge/CodeAlpha-Java%20Internship-purple)
![License](https://img.shields.io/badge/License-MIT-green)

A professional **Java Console Application** developed as part of the **CodeAlpha Java Programming Internship**.

The project demonstrates **Object-Oriented Programming (OOP)**, **Java Collections Framework**, **Exception Handling**, **File Handling**, **Modular Architecture**, and **Software Engineering Best Practices**.

---

# 📌 Project Overview

Student Grade Tracker is a menu-driven Java console application that helps manage student academic records efficiently.

The application enables users to:

- Manage student records
- Generate report cards
- Calculate grades automatically
- Display academic statistics
- Rank students
- Export reports to CSV
- Save and load student records using file handling

The project follows a modular architecture where each class has a clearly defined responsibility, making the application maintainable, reusable, and scalable.

---

# ✨ Features

## 👨‍🎓 Student Management

- Add Student
- View All Students
- Search Student by ID
- Search Student by Name
- Update Student Marks
- Delete Student

---

## 📄 Academic Reports

- Generate Student Report Card
- Calculate Total Marks
- Calculate Average Marks
- Calculate Highest Marks
- Calculate Lowest Marks
- Automatic Grade Calculation

---

## 📊 Analytics

- Display Class Statistics
- Display Student Rankings
- Display Class Topper
- Display Grade Distribution
- Filter Students by Grade
- Sort Students by Average Marks

---

## 💾 Data Management

- Save Student Records
- Load Student Records
- Export Student Data to CSV

---

## 🛡 Input Validation

The application validates:

- Student IDs
- Student Names
- Subject Marks (0–100)
- Menu Options
- Grade Inputs
- Delete Confirmation
- Numeric Inputs

This ensures robust execution and prevents invalid data entry.

---

# 🎯 Project Objectives

This project was developed to strengthen practical knowledge of:

- Object-Oriented Programming
- Java Collections Framework
- Exception Handling
- File Handling
- Console Application Development
- Git & GitHub
- Software Testing
- Code Documentation

---

# 📋 Main Menu

```text
1. Add Student
2. View All Students
3. Search Student by ID
4. Search Student by Name
5. Update Student Marks
6. Delete Student
7. Generate Student Report Card
8. Display Class Statistics
9. Sort Students By Average
10. Display Class Topper
11. Display Student Rankings
12. Filter Students By Grade
13. Display Grade Distribution
14. Export Student Data To CSV
15. Save Student Records
16. Exit Application
```

---

# ⭐ Highlights

- Professional Console UI
- Modular Architecture
- Complete CRUD Operations
- Report Card Generation
- Academic Analytics
- CSV Export
- Persistent File Storage
- Comprehensive JavaDoc Documentation
- Professional Git Commit History
- Fully Tested (16/16 Functional Test Cases Passed)

---

# 🚀 Version

**Current Version:** `Student Grade Tracker v1.0`

**Project Status:** ✅ Production Ready

# 🏗️ Project Architecture

The Student Grade Tracker follows a **modular Object-Oriented Architecture**, where every class has a single, well-defined responsibility.

```
                    +----------------------+
                    |      Main.java       |
                    |----------------------|
                    | Application Control  |
                    +----------+-----------+
                               |
        -------------------------------------------------
        |                |               |              |
        ▼                ▼               ▼              ▼
+---------------+ +---------------+ +-------------+ +---------------+
| StudentManager| |  FileManager  | | ReportCard | |  ConsoleUI    |
+---------------+ +---------------+ +-------------+ +---------------+
| Business Logic| | File Handling | | Report View| | Console Output|
+-------+-------+ +-------+-------+ +------+------+ +-------+-------+
        |
        ▼
+------------------+
|   Student.java   |
+------------------+
| Student Entity   |
| Marks & Grades   |
+------------------+
```

---

# 📂 Project Structure

```text
StudentGradeTracker
│
├── src
│   ├── ConsoleUI.java
│   ├── FileManager.java
│   ├── Main.java
│   ├── ReportCard.java
│   ├── Student.java
│   └── StudentManager.java
│
├── grades.txt
├── student_report.csv
├── screenshots
│   ├── main-menu.png
│   ├── student-list.png
│   ├── report-card.png
│   ├── statistics.png
│   ├── rankings.png
│   ├── grade-distribution.png
│   └── csv-export.png
│
└── README.md
```

---

# 📦 Class Responsibilities

## Main.java

**Purpose**

Acts as the controller of the application.

### Responsibilities

- Application initialization
- Displaying the main menu
- Reading user input
- Coordinating all modules
- Application shutdown

---

## Student.java

**Purpose**

Represents a student entity.

### Responsibilities

- Store student details
- Store subject marks
- Calculate total marks
- Calculate average marks
- Calculate highest marks
- Calculate lowest marks
- Calculate grade

---

## StudentManager.java

**Purpose**

Handles all business logic.

### Responsibilities

- Add student
- Update student
- Delete student
- Search by ID
- Search by Name
- Display statistics
- Display rankings
- Display topper
- Grade distribution
- Grade filtering
- Sorting students

---

## FileManager.java

**Purpose**

Manages persistent storage.

### Responsibilities

- Save student records
- Load student records
- Export CSV reports
- Create data files
- Parse student records

---

## ReportCard.java

**Purpose**

Displays a formatted report card.

### Responsibilities

- Student information
- Subject-wise marks
- Academic summary
- Grade display

---

## ConsoleUI.java

**Purpose**

Provides reusable console components.

### Responsibilities

- Borders
- Titles
- Message boxes
- Student tables
- Welcome screen
- Exit screen

---

# ⚙️ Technologies Used

| Technology | Purpose |
|------------|---------|
| Java | Core Programming Language |
| OOP | Modular Design |
| Collections Framework | Student Record Management |
| File Handling | Persistent Storage |
| Exception Handling | Robust Input Validation |
| Scanner | User Input |
| CSV | Report Export |
| Git | Version Control |
| GitHub | Source Code Hosting |

---

# 🎯 Object-Oriented Principles Applied

The project demonstrates several Object-Oriented Programming principles.

## Encapsulation

- Private data members
- Public getter and setter methods

---

## Single Responsibility Principle (SRP)

Each class has one clearly defined responsibility.

Example:

- Student → Student information
- FileManager → File handling
- ConsoleUI → User interface

---

## Modularity

The project is divided into reusable classes.

This improves:

- Maintainability
- Readability
- Scalability

---

## Reusability

Common functionality has been extracted into reusable methods.

Examples include:

- ConsoleUI
- ReportCard
- FileManager helper methods

---

# 🔄 Application Workflow

```text
Application Starts
        │
        ▼
Initialize Application
        │
        ▼
Load Student Records
        │
        ▼
Display Main Menu
        │
        ▼
User Selects Menu Option
        │
        ▼
Business Logic Executes
        │
        ▼
Display Result
        │
        ▼
Return To Main Menu
        │
        ▼
Exit Application
        │
        ▼
Save Student Records
```

# 🚀 Installation Guide

## Prerequisites

Before running the project, ensure you have the following installed:

- Java Development Kit (JDK 17 or above)
- IntelliJ IDEA Community/Ultimate Edition (Recommended)
    - or Eclipse
    - or Visual Studio Code with Java Extension Pack
- Git (Optional, for cloning the repository)

---

# 📥 Clone the Repository

```bash
git clone https://github.com/<your-github-username>/CodeAlpha-Internship-Projects.git
```

Navigate to the project directory:

```bash
cd CodeAlpha-Internship-Projects/Task-1/StudentGradeTracker
```

---

# ▶ Running the Application

Open the project in your preferred Java IDE.

Locate:

```
src/Main.java
```

Run:

```
Main.java
```

The application will automatically:

- Load existing student records (if available)
- Create the data file if it does not exist
- Display the welcome screen
- Show the main menu

---

# 📁 Data Files

The application uses two data files.

## grades.txt

Stores student records permanently.

Example:

```text
101,Bhavya Shukla,95,92,91,97,90
102,Rahul,65,72,68,75,70
```

---

## student_report.csv

Generated using the **Export Student Data to CSV** feature.

Contains:

- Student Information
- Subject Marks
- Total Marks
- Average Marks
- Highest Marks
- Lowest Marks
- Grade

This file can be opened in:

- Microsoft Excel
- Google Sheets
- LibreOffice Calc

---

# 🧪 Functional Testing

The application has been tested using a structured Quality Assurance process.

## Test Summary

| Test Case | Status |
|-----------|:------:|
| Add Student | ✅ |
| View Students | ✅ |
| Search by ID | ✅ |
| Search by Name | ✅ |
| Update Student | ✅ |
| Delete Student | ✅ |
| Generate Report Card | ✅ |
| Display Statistics | ✅ |
| Sort Students | ✅ |
| Display Topper | ✅ |
| Display Rankings | ✅ |
| Filter by Grade | ✅ |
| Grade Distribution | ✅ |
| Export CSV | ✅ |
| Save Student Records | ✅ |
| Exit Application | ✅ |

**Result: 16 / 16 Test Cases Passed**

---

# 💡 Sample Workflow

A typical usage flow of the application:

```text
Start Application
        │
        ▼
Load Student Records
        │
        ▼
Display Main Menu
        │
        ▼
Add / Search / Update / Delete
        │
        ▼
Generate Reports
        │
        ▼
Display Analytics
        │
        ▼
Export CSV
        │
        ▼
Save Student Records
        │
        ▼
Exit Application
```

---

# 🛠 Error Handling

The application includes validation for:

- Invalid menu choices
- Empty names
- Invalid student IDs
- Duplicate student IDs
- Invalid marks
- Invalid grades
- File handling exceptions
- Number format exceptions
- Unexpected runtime exceptions

This ensures the application remains stable during execution.

---

# 📈 Performance

For the expected scale of this console application:

- Student records are stored using `ArrayList`
- Searching uses linear search
- Sorting uses Java's built-in sorting algorithm
- File operations use efficient buffered writing via `PrintWriter`

The performance is suitable for educational and small-scale academic record management.