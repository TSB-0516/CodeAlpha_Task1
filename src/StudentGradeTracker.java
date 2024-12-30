import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {
    private final ArrayList<Integer> grades = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\n1. Add Grade");
            System.out.println("2. Compute Average");
            System.out.println("3. Show Highest Grade");
            System.out.println("4. Show Lowest Grade");
            System.out.println("5. Show All Grades");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addGrade();
                case 2 -> computeAverage();
                case 3 -> showHighestGrade();
                case 4 -> showLowestGrade();
                case 5 -> showAllGrades();
                case 6 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void addGrade() {
        System.out.print("Enter grade (0-100): ");
        int grade = scanner.nextInt();
        if (grade >= 0 && grade <= 100) {
            grades.add(grade);
            System.out.println("Grade added.");
        } else {
            System.out.println("Invalid grade. Please enter a value between 0 and 100.");
        }
    }

    private void computeAverage() {
        if (grades.isEmpty()) {
            System.out.println("No grades available.");
            return;
        }
        double average = grades.stream().mapToInt(Integer::intValue).average().orElse(0);
        System.out.println("Average grade: " + average);
    }

    private void showHighestGrade() {
        if (grades.isEmpty()) {
            System.out.println("No grades available.");
            return;
        }
        int highest = grades.stream().max(Integer::compareTo).orElse(0);
        System.out.println("Highest grade: " + highest);
    }

    private void showLowestGrade() {
        if (grades.isEmpty()) {
            System.out.println("No grades available.");
            return;
        }
        int lowest = grades.stream().min(Integer::compareTo).orElse(0);
        System.out.println("Lowest grade: " + lowest);
    }

    private void showAllGrades() {
        if (grades.isEmpty()) {
            System.out.println("No grades available.");
            return;
        }
        System.out.println("All grades: " + grades);
    }
}
