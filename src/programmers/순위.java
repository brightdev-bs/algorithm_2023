package programmers;

public class 순위 {

    public static void main(String[] args) {
        int n = 5;
        int[][] results = new int[][]{
                {4, 3},
                {4, 2},
                {3, 2},
                {1, 2},
                {2, 5}
        };

        int[][] graph = new int[n + 1][n + 1];
        for(int[] result : results) {
            int winner = result[0];
            int loser = result[1];
            graph[winner][loser] = 1;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                for(int k = 1; k <= n; k++) {
                    if(graph[i][j] == 1 && graph[j][k] == 1) graph[i][k] = 1;
                }
            }
        }

        int answer = 0;
        for(int i = 1; i <= n; i++) {
            int game = 0;
            for(int j = 1; j <= n; j++) {
                if(graph[i][j] == 1 || graph[j][i] == 1)
                    game++;
            }
            if(game == n - 1) answer++;
        }

        System.out.println(answer);
    }


}
