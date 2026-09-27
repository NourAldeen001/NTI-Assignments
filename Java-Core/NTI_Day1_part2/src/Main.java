import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initialize data (declared here in main, passed into methods as parameters)
        String[] names = {"Ahmed Hassan", "Layla Mohamed", "Omar Ali",
                "Fatima Khaled", "Youssef Ibrahim"};
        double[] grades = {85.5, 92.0, 58.5, 76.0, 88.5};
        int studentCount = 5;

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n========================================");
            System.out.println("    STUDENT GRADE PROCESSOR MENU");
            System.out.println("========================================");
            System.out.println("1.  Test Validation Functions");
            System.out.println("2.  Calculate Class Average");
            System.out.println("3.  Get Letter Grade for a Student");
            System.out.println("4.  Calculate Weighted Average");
            System.out.println("5.  Count Passing Students");
            System.out.println("6.  Format a Student Name");
            System.out.println("7.  Get Performance Level");
            System.out.println("8.  Find Student by Name");
            System.out.println("9.  Find Top Student");
            System.out.println("10. Find Highest and Lowest Grades");
            System.out.println("11. Get Failing Students List");
            System.out.println("12. Display Single Student Record");
            System.out.println("13. Display Full Class Report");
            System.out.println("14. Display Top 3 Performers");
            System.out.println("0.  Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // clear the buffer

            switch (choice) {
                case 1 :
                    System.out.println("Is 85.5 valid? " + isValidGrade(85.5));
                    System.out.println("Is 150 valid? "  + isValidGrade(150));
                    System.out.println("Is 'Ahmed Hassan' valid? " + isValidName("Ahmed Hassan"));
                    System.out.println("Is '' valid? "  + isValidName(""));
                    System.out.println("Is 75 passing? " + isPassingGrade(75.0));
                    break;
                case 2 :
                    double average = calculateAverage(grades, studentCount);
                    System.out.printf("Class Average: %.2f%n", average);
                    break;
                case 3 :
                    System.out.print("Enter student index (0-4): ");
                    int index = scanner.nextInt();
                    if (index >= 0 && index < studentCount) {
                        char letter = getLetterGrade(grades[index]);
//                        System.out.println(names[index] + " has letter grade: " + letter);
                    } else System.out.println("Invalid index!");
                    break;
                case 4 :
                    System.out.print("Exam 1: "); double e1 = scanner.nextDouble();
                    System.out.print("Exam 2: "); double e2 = scanner.nextDouble();
                    System.out.print("Final:  "); double fin = scanner.nextDouble();
//                    double weighted = /* Call calculateWeightedAverage(e1, e2, fin) */;
//                    System.out.printf("Weighted Average: %.2f%n", weighted);
                    break;
                case 5 :
//                    System.out.println("Passing: " + /* Call countPassingStudents(...) */);
                    break;
                case 6 :
                    System.out.print("Name to format: ");
                    String raw = scanner.nextLine();
//                    System.out.println("Formatted: " + /* Call formatStudentName(raw) */);
                    break;
                case 7 :
                    System.out.print("Enter student index (0-4): ");
                    int p = scanner.nextInt();
                    if (p >= 0 && p < studentCount)
//                        System.out.println(names[p] + " - " + /* Call getPerformanceLevel for grades[p] */);
                    break;
                case 8 :
                    System.out.print("Name to search: ");
                    String q = scanner.nextLine();
//                    int found = /* Call findStudentByName(...) */;
//                    if (found != -1) System.out.println("Found at index " + found + ": " + names[found]);
//                    else System.out.println("Student not found!");
                    break;
                case 9 :
//                    int top = /* Call findTopStudent(...) */;
//                    System.out.println("Top: " + names[top] + " (" + grades[top] + ")");
                 break;
                case 10 :
//                    System.out.printf("Highest: %.2f%n", /* Call findHighestGrade(...) */);
//                    System.out.printf("Lowest:  %.2f%n", /* Call findLowestGrade(...) */);
                    break;
                case 11 :
//                    String[] failing = /* Call getFailingStudents(...) */;
//                    if (failing.length == 0) System.out.println("No failing students!");
//                    else for (String s : failing) System.out.println("- " + s);
                    break;
                case 12 :
                    System.out.print("Enter student index (0-4): ");
                    int s = scanner.nextInt();
                    if (s >= 0 && s < studentCount) /* Call displayStudentRecord for student s */;
                    else System.out.println("Invalid index!");
                    break;
                case 13 :
                    /* Call displayClassReport(names, grades, studentCount) */;
                    break;
                case 14 :
                    /* Call displayTopPerformers(...) to show the top 3 */;
                    break;
                case 0 :
                    System.out.println("Exiting... Thank you!");
                    break;
                default :
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static boolean isValidGrade(double v) {
        return v >= 0 && v <= 100;
    }

    private static boolean isValidName(String n) {
        return !n.isBlank();
    }

    private static boolean isPassingGrade(double v) {
        return v >= 60;
    }

    private static double calculateAverage(double[] grades, int studentCount) {
        double total = 0;
        for(double grade : grades) {
            total += grade;
        }
        return total / studentCount;
    }

    private static char getLetterGrade(double grade) {
        if(grade <= 100 && grade >= 90) {
            return 'A';
        }
        else if(grade <= 89 && grade >= 80) {
            return 'B';
        }
        else if(grade <= 79 && grade >= 70) {
            return 'C';
        }
        else if(grade <= 69 && grade >= 60) {
            return 'D';
        }
        else {
             return 'F';
        }
    }




}