package core.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q18870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] list = new int[N][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int index = 0;
        while (st.hasMoreTokens()) {
            int n = Integer.parseInt(st.nextToken());
            list[index][0] = n;
            list[index][1] = index;
            index++;
        }

        Arrays.sort(list, (a, b) -> a[0] - b[0]);

        int[] answer = new int[N];
        answer[list[0][1]] = 0;
        int differentCount = 0;
        for (int i = 1; i < N; i++) {
            if(list[i][0] != list[i - 1][0]) differentCount++;
            answer[list[i][1]] = differentCount;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : answer) {
            sb.append(i + " ");
        }

        System.out.println(sb);
    }
}
