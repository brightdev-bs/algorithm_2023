package core.sort;

import java.util.*;

public class Q7785 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String name = sc.next();
            String flag = sc.next();
            if (!set.contains(name))
                set.add(name);
            else
                set.remove(name);
        }

        List<String> result = new ArrayList<>(set);
        Collections.sort(result, (a, b) -> b.compareTo(a));

        for (String s : result) {
            System.out.println(s);
        }




    }
}
