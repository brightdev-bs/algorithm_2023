package baekjoon.string;

import java.util.Scanner;

public class Q13223 {

    // 계층적으로 표현되는 각 단위를 계산할 때, 가장 작은 단위로 통일하면 더 편할 수 있다.
    // 문자열 포맷 코드
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] current = sc.nextLine().split(":");
        String[] drop = sc.nextLine().split(":");

        int currentHour = Integer.parseInt(current[0]);
        int currentMin = Integer.parseInt(current[1]);
        int currentSecond = Integer.parseInt(current[2]);
        int currentTotalSecond = currentHour * 3600 + currentMin * 60 + currentSecond;

        int dropHour = Integer.parseInt(drop[0]);
        int dropMin = Integer.parseInt(drop[1]);
        int dropSecond = Integer.parseInt(drop[2]);
        int dropTotalSecond = dropHour * 3600 + dropMin * 60 + dropSecond;

        int gap = dropTotalSecond - currentTotalSecond;
        if(gap < 0) gap += 24 * 3600;

        int resultHour = gap / 3600;
        int resultMin = (gap % 3600) / 60;
        int resultSecond = gap % 60;
        System.out.printf("%02d:%02d:%02d", resultHour, resultMin, resultSecond);

    }
}
