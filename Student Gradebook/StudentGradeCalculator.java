import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        
        String[] studentNames = new String[numStudents];
        double[][] studentScores = new double[numStudents][3]; 
        
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter information for student " + (i + 1));
            System.out.print("Name: ");
            studentNames[i] = scanner.next();
            
            System.out.print("Enter your score for Quiz: ");
            studentScores[i][0] = scanner.nextDouble();
            System.out.print("Enter your score for Homework: ");
            studentScores[i][1] = scanner.nextDouble();
            System.out.print("Enter your score for Exam: ");
            studentScores[i][2] = scanner.nextDouble();
        }
        
        double[] averageScores = new double[numStudents];
        char[] grades = new char[numStudents];
        
        for (int i = 0; i < numStudents; i++) {
            double sum = 0;
            for (int j = 0; j < 3; j++) {
                sum += studentScores[i][j];
            }
            averageScores[i] = sum / 3; 
            
            if (averageScores[i] >= 90) {
                grades[i] = 'A';
            } else if (averageScores[i] >= 80) {
                grades[i] = 'B';
            } else if (averageScores[i] >= 70) {
                grades[i] = 'C';
            } else if (averageScores[i] >= 60) {
                grades[i] = 'D';
            } else {
                grades[i] = 'F';
            }
        }
        
        System.out.println("\nStudent Information:");
        System.out.println("---------------------------------");
        System.out.println("Name\tAverage Score\tGrade");
        System.out.println("---------------------------------");
        for (int i = 0; i < numStudents; i++) {
            System.out.printf("%s\t%.2f\t%c\n", studentNames[i], averageScores[i], grades[i]);
        }
        
        double classAverage = 0;
        for (int i = 0; i < numStudents; i++) {
            classAverage += averageScores[i];
        }
        classAverage /= numStudents;
        
        System.out.println("\nClass Average: " + classAverage);
        
        double highestScore = averageScores[0];
        int highestIndex = 0;
        double lowestScore = averageScores[0];
        int lowestIndex = 0;
        
        for (int i = 1; i < numStudents; i++) {
            if (averageScores[i] > highestScore) {
                highestScore = averageScores[i];
                highestIndex = i;
            }
            if (averageScores[i] < lowestScore) {
                lowestScore = averageScores[i];
                lowestIndex = i;
            }
        }
        
        System.out.println("Highest Score: " + studentNames[highestIndex] + " (" + highestScore + ")");
        System.out.println("Lowest Score: " + studentNames[lowestIndex] + " (" + lowestScore + ")");
    }
}
