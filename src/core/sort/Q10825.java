package core.sort;

import java.util.Arrays;
import java.util.Scanner;

public class Q10825 {

    static class Grade implements Comparable<Grade> {
        String name;
        int korean;
        int english;
        int math;

        public Grade(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Grade o) {
            if(this.korean == o.korean && this.english == o.english && this.math == o.math) {
                return this.name.compareTo(o.name);
            }
            if(this.korean == o.korean && this.english == o.english) {
                return o.math - this.math;
            }
            if(this.korean == o.korean) {
                return this.english - o.english;
            }

            return o.korean - this.korean;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Grade[] grades = new Grade[n];
        for(int i = 0; i < n; i++) {
            String name = sc.next();
            int korean = sc.nextInt();
            int english = sc.nextInt();
            int math = sc.nextInt();
            grades[i] = new Grade(name, korean, english, math);
        }

        Arrays.sort(grades);

        for (Grade grade : grades) {
            System.out.println(grade.name);
        }
    }
}
