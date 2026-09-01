package SWEA.D4;

import java.util.ArrayList;
import java.util.Scanner;

public class 창용마을무리의개수 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt(); // 마을에 사는 사람 수
            int m = sc.nextInt(); // 관계 수

            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            int sum = 0;
            boolean[] visited = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) { // 방문 안 한 것만 돌기
                    dfs(i, graph, visited); // 연결된 사람들을 전부 찾아 방문 처리
                    sum++;
                }
            }
            System.out.println("#" + test_case + " " + sum);
        }
    }

    private static void dfs(int cur, ArrayList<ArrayList<Integer>> graph, boolean[] visited) {
        visited[cur] = true;

        for (Integer next : graph.get(cur)) {
            if (!visited[next]) {
                dfs(next, graph, visited);
            }
        }
    }
}
