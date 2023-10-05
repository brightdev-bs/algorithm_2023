package programmers;

public class N차_진수 {

    public static void main(String[] args) {

        System.out.println(solution(2, 4, 2, 1));
        System.out.println(solution(16, 16, 2, 1));
    }

    public static String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder sb = new StringBuilder();

        int num = 0;
        int len = t * m;
        while(sb.length() < len) {
            String temp = Integer.toString(num, n).toUpperCase();
            sb.append(temp);
            num++;
        }

        for(int i = p - 1; answer.length() < t; i += m) {
            answer.append(sb.charAt(i));
        }

        return answer.toString();
    }
}
