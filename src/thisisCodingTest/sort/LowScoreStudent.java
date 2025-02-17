package thisisCodingTest.sort;

import java.util.Arrays;
import java.util.Scanner;

class Student implements Comparable<Student>{
    String name;
    int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        return score - o.score;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class LowScoreStudent {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            int score = scanner.nextInt();
            students[i] = new Student(name,score);
        }

        Arrays.sort(students);
        for (Student student : students) {
            System.out.print(student + " ");
        }
    }
}
