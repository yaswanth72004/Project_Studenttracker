import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class studenttracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> grades = new ArrayList<>();

        while (true) {
            System.out.println("\nStudent Grade Tracker");
            System.out.println("1. Add Student Grade");
            System.out.println("2. Show All Grades");
            System.out.println("3. Compute Average, Highest, and Lowest Grade");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter student grade (0-100): ");
                    int grade = scanner.nextInt();
                    if (grade >= 0 && grade <= 100) {
                        grades.add(grade);
                        System.out.println("Grade added successfully!");
                    } else {
                        System.out.println("Invalid grade! Please enter a value between 0 and 100.");
                    }
                    break;

                case 2:
                    if (grades.isEmpty()) {
                        System.out.println("No grades recorded yet.");
                    } else {
                        System.out.println("Student Grades: " + grades);
                    }
                    break;

                case 3:
                    if (grades.isEmpty()) {
                        System.out.println("No grades available to compute.");
                    } else {
                        int highest = Collections.max(grades);
                        int lowest = Collections.min(grades);
                        double average = grades.stream().mapToInt(Integer::intValue).average().orElse(0);

                        System.out.println("Average Grade: " + average);
                        System.out.println("Highest Grade: " + highest);
                        System.out.println("Lowest Grade: " + lowest);
                    }
                    break;

                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option! Please choose a valid option.");
            }
        }
    }
}

/*
   ==============================
   Sample Output 1 (Basic Example)
   ==============================

   Student Grade Tracker
   1. Add Student Grade
   2. Show All Grades
   3. Compute Average, Highest, and Lowest Grade
   4. Exit
   Choose an option: 1
   Enter student grade (0-100): 78
   Grade added successfully!

   Choose an option: 1
   Enter student grade (0-100): 92
   Grade added successfully!

   Choose an option: 2
   Student Grades: [78, 92]

   Choose an option: 3
   Average Grade: 85.0
   Highest Grade: 92
   Lowest Grade: 78

   Choose an option: 4
   Exiting program. Goodbye!

   ==============================
   Sample Output 2 (Invalid Input)
   ==============================

   Student Grade Tracker
   1. Add Student Grade
   2. Show All Grades
   3. Compute Average, Highest, and Lowest Grade
   4. Exit
   Choose an option: 1
   Enter student grade (0-100): 110
   Invalid grade! Please enter a value between 0 and 100.

   Choose an option: 1
   Enter student grade (0-100): 85
   Grade added successfully!

   Choose an option: 3
   Average Grade: 85.0
   Highest Grade: 85
   Lowest Grade: 85

   Choose an option: 4
   Exiting program. Goodbye!

   ==============================
   Sample Output 3 (No Grades Entered Yet)
   ==============================

   Student Grade Tracker
   1. Add Student Grade
   2. Show All Grades
   3. Compute Average, Highest, and Lowest Grade
   4. Exit
   Choose an option: 3
   No grades available to compute.

   Choose an option: 4
   Exiting program. Goodbye!
*/
