package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class N으로_표현 {

    public int solution(int N, int number) {

        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }

        for (int i = 1; i <= 8; i++) {
            // i번 사용하여 만들 수 있는 숫자는 N을 연속해서 사용한 경우부터 시작합니다.
            int currNum = Integer.parseInt(Integer.toString(N).repeat(i));
            dp.get(i).add(currNum);

            // j는 i보다 작은 수를 나타냅니다.
            for (int j = 1; j < i; j++) {
                for (int num1 : dp.get(j)) {
                    for (int num2 : dp.get(i - j)) {
                        dp.get(i).add(num1 + num2);
                        dp.get(i).add(num1 - num2);
                        dp.get(i).add(num1 * num2);
                        if (num2 != 0) {
                            dp.get(i).add(num1 / num2);
                        }
                    }
                }
            }

            // 만약 number가 dp[i]에 있다면, 최소 사용 횟수인 i를 반환합니다.
            if (dp.get(i).contains(number)) {
                return i;
            }
        }

        // 최솟값이 8보다 큰 경우에는 -1을 반환합니다.
        return -1;
    }
}
