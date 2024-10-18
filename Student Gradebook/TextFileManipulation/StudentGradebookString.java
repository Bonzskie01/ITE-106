import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class StudentGradebookString {
    public static void main(String[] args) {
        String inputFileName = "student_data.txt";
        String outputFileName = "student_grades.txt";

        try {
            Scanner scanner = new Scanner(new File(inputFileName));

            String[] studentNames = new String[100]; 
            double[][] studentGrades = new double[100][5]; 
            int numStudents = 0;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(",");

                studentNames[numStudents] = tokens[0];
                for (int i = 1; i < tokens.length; i++) {
                    studentGrades[numStudents][i - 1] = Double.parseDouble(tokens[i].trim());
                }
                numStudents++;
            }
            scanner.close();

            double[] averageScores = new double[numStudents];
            char[] grades = new char[numStudents];

            for (int i = 0; i < numStudents; i++) {
                double sum = 0;
                for (int j = 0; j < 5; j++) {
                    sum += studentGrades[i][j];
                }
                averageScores[i] = sum / 5;

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

            PrintWriter writer = new PrintWriter(new File(outputFileName));

            writer.println("Name\tQuiz1\tQuiz2\tHomework\tMidterm\tFinal\tAverage\tGrade");
            for (int i = 0; i < numStudents; i++) {
                writer.printf("%s\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\t%c\n",
                        studentNames[i], studentGrades[i][0], studentGrades[i][1], studentGrades[i][2],
                        studentGrades[i][3], studentGrades[i][4], averageScores[i], grades[i]);
            }

            writer.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found.");
        }
    }
}