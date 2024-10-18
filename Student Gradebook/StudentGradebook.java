import java.util.Scanner;

public class StudentGradebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        System.out.print("Enter the number of assignments: ");
        int numAssignments = scanner.nextInt();

        String[] studentNames = new String[numStudents];
        double[][] studentGrades = new double[numStudents][numAssignments];

        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter information for student " + (i + 1));

            System.out.print("Name: ");
            studentNames[i] = scanner.next();

            for (int j = 0; j < numAssignments; j++) {
                System.out.print("Score for assignment " + (j + 1) + ": ");
                studentGrades[i][j] = scanner.nextDouble();
            }
        }
		
        double[] averageScores = new double[numStudents];
        char[] grades = new char[numStudents];

        for (int i = 0; i < numStudents; i++) {
            double sum = 0;
            for (int j = 0; j < numAssignments; j++) {
                sum += studentGrades[i][j];
            }
            averageScores[i] = sum / numAssignments;

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

        System.out.println("\nHighest Score: " + studentNames[highestIndex] + " (" + highestScore + ")");
        System.out.println("Lowest Score: " + studentNames[lowestIndex] + " (" + lowestScore + ")");

        for (int i = 0; i < numStudents - 1; i++) {
            for (int j = 0; j < numStudents - i - 1; j++) {
                if (averageScores[j] > averageScores[j + 1]) {

                    double temp = averageScores[j];
                    averageScores[j] = averageScores[j + 1];
                    averageScores[j + 1] = temp;


                    String tempName = studentNames[j];
                    studentNames[j] = studentNames[j + 1];
                    studentNames[j + 1] = tempName;
                }
            }
        }

        System.out.println("\nSorted Students (by Average Score):");
        System.out.println("---------------------------------");
        System.out.println("Name\tAverage Score\tGrade");
        System.out.println("---------------------------------");

        for (int i = 0; i < numStudents; i++) {
            System.out.printf("%s\t%.2f\t%c\n", studentNames[i], averageScores[i], grades[i]);
        }
    }
}