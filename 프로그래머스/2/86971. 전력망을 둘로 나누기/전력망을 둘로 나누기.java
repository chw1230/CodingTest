import java.util.ArrayList;

class Solution {
    static boolean[] visited;

    public static int solution(int n, int[][] wires) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < wires.length; i++) {
            graph.get(wires[i][0]).add(wires[i][1]);
            graph.get(wires[i][1]).add(wires[i][0]);
        }

//        System.out.println(graph);

        int min = Integer.MAX_VALUE;
        // 끊을 노드를 정하기
        for (int[] wire : wires) {
            int u = wire[0];
            int v = wire[1];

            visited = new boolean[n + 1];

            int cnt = dfs(1, u, v, graph);
            int diff = Math.abs(cnt - (n - cnt));
            min = Math.min(min, diff);
        }

        return min;
    }

    // 노드1,2의 연결을 끊는다라고 생각
    // 현재송전탑, 끊을노드1, 끊을노드2, 그래프
    private static int dfs(int cur, int u, int v, ArrayList<ArrayList<Integer>> graph) {
        visited[cur] = true;
        int cnt = 1; // 카운트한 송전탑의 개수 하나 올리기

        // 현재 송전탑에서 연결된 노드들을 보기
        for (Integer next : graph.get(cur)) {
            // 현재 노드와 다음 노드가 끊을 노드 쌍과 동일하다면 넘어가기
            if ((cur == u && next == v) || (cur == v && next == u)) {
                continue;
            }

            if (!visited[next]) {
                cnt += dfs(next, u, v, graph);
            }
        }

        return cnt;
    }
}