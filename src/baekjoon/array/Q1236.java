package baekjoon.array;

import java.io.IOException;
import java.util.Scanner;

public class Q1236 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        sc.nextLine();
        char[][] graph = new char[n][m];
        for(int i = 0; i < n; i++) {
            graph[i] = sc.nextLine().toCharArray();
        }

        int rowCount = 0;
        for(int i = 0; i < n; i++) {
            boolean exist = false;
            for(int j = 0; j < m; j++) {
                if(graph[i][j] == 'X') {
                    exist = true;
                    break;
                }
            }
            if(exist) rowCount++;
        }

        int colCount = 0;
        for(int i = 0; i < m; i++) {
            boolean exist = false;
            for(int j = 0; j < n; j++) {
                if(graph[j][i] == 'X') {
                    exist = true;
                    break;
                }
            }
            if(exist) colCount++;
        }

        System.out.println(Math.max(n - rowCount, m - colCount));

    }
}
