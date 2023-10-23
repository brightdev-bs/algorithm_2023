package core.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q20291 {
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

        String nextLine() {
            String input = null;
            try {
                input = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return input;
        }

        int nextInt() { return Integer.parseInt(next()); }
    }

    static FastReader scan = new FastReader();

    static class File implements Comparable<File> {
        String name;
        String ext;

        public File(String name, String ext) {
            this.name = name;
            this.ext = ext;
        }

        @Override
        public int compareTo(File f) {
            return this.ext.compareTo(f.ext);
        }
    }

    public static void main(String[] args) {
        int N = scan.nextInt();

        File[] files = new File[N];
        for(int i = 0; i < N; i++) {
            String input = scan.nextLine();
            String[] split = input.split("\\.");
            files[i] = new File(split[0], split[1]);
        }

        Arrays.sort(files);

        HashMap<String, Integer> map = new LinkedHashMap<>();
        for (File file : files) {
            map.put(file.ext, map.getOrDefault(file.ext, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (String s : map.keySet()) {
            sb.append(s)
                    .append(" ")
                    .append(map.get(s))
                    .append("\n");
        }

        System.out.println(sb);
    }
}


