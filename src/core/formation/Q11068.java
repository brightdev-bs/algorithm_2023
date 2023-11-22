package core.formation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11068 {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while(st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    static FastReader sc = new FastReader();


    public static void main(String[] args) {
        int TC = sc.nextInt();
        while(TC-- > 0) {
            int input = sc.nextInt();
            checkTheAnswer(input);
        }
    }

    private static void checkTheAnswer(int number) {
        int len = Math.min(number, 64);
        boolean flag = false;
        for (int i = 2; i <= len; i++) {
            String formationedNumber = toNFormation(i, number);
            if(check(formationedNumber)) {
                System.out.println(1);
                flag = true;
                break;
            }
        }
        if(!flag) System.out.println(0);
    }

    private static String toNFormation(int N, int number) {
        StringBuilder sb = new StringBuilder();
        while (number != 0) {
            int D = number % N;
            if (D < 10) sb.append(D);
            else if (D <= 35) sb.append((char) (D - 10 + 'a'));
            else if (D <= 61) sb.append((char) (D - 10 + 'A'));
            else if (D == 62) sb.append('!');
            else if (D == 63) sb.append('@');
            number /= N;
        }
        return sb.reverse().toString();
    }

    private static boolean check(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left <= right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }
}
