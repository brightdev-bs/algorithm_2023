package core.bruteforce;

import java.util.Scanner;

public class Q9663 {

    static int n, answer = 0;
    static int[] col;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        col = new int[n + 1];
        helper(1);
        System.out.println(answer);
    }

    private static void helper(int row) {
        if(row == n + 1) {
            answer++;
        } else {
            for(int i = 1; i <= n; i++) {
                boolean flag = false;
                for(int next = 1; next < row; next++) {
                    if(attackable(row, i, next, col[next])) {
                        flag = true;
                        break;
                    }
                }
                if(!flag) {
                    col[row] = i;
                    helper(row + 1);
                    col[row] = 0;
                }
            }
        }
    }

    private static boolean checkValidation() {
        for(int r1 = 1; r1 <= n; r1++) {
            for(int r2 = 1; r2 < r1; r2++) {
                if(attackable(r1, col[r1], r2, col[r2])) return false;
            }
        }
        return true;
    }

    private static boolean attackable(int r1, int c1, int r2, int c2) {
        if(c1 == c2) return true;
        if(r1 - c1 == r2 - c2) return true;
        if(r1 + c1 == r2 + c2) return true;
        return false;
    }


}
