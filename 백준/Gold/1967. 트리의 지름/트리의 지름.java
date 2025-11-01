import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    private static int N;
    private static int[] dist;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        // 처음에 트리의 지름이라는 것을 -> 루트에서 먼곳부터 루트에서 그 다음까지 먼 곳으로 이해하고 풀어서 정답까지 시간이 오래 걸림!
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dist = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, value));
            graph.get(b).add(new Node(a, value));
        }

        // 1> 출발점에서 가장 먼 곳의 노드를 찾기
        visited[1] = true;
        dfs(1, 0); // 출발점 -> 1, 0(출발점은 0)
        int maxIdx = 0; // 루트에서 가장 먼 곳에 있는 노드의 번호
        int maxValue = 0; // 루트에서 가장 먼 곳에 있는 노드까지의 거리
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] > maxValue) {
                maxValue = dist[i];
                maxIdx = i;
            }
        }

        // 2> 루트에서 가장 먼 곳의 노드에서 다른 노드까지 얼마나 걸리는 지 구해서 트리를 쭉 폈을때 가장 먼 노드까지의 거리를 구하자!
        Arrays.fill(dist, 0);
        Arrays.fill(visited, false);
        dfs(maxIdx, 0);
        int max = 0; // 루트에서 가장 먼 곳에 있는 노드에서 가장 먼 곳에 잇는 노드까지의 거리
        for (int i : dist) {
            if (i > max) {
                max = i;
            }
        }
        System.out.println(max);
    }

    private static void dfs(int i, int v) { // 시작, 누적 거리
        visited[i] = true;
        dist[i] = v;
        for (Node n : graph.get(i)) {
            if (!visited[n.node]) {
                dfs(n.node, n.value + v);
            }
        }
    }

    static class Node {
        int node;
        int value;

        public Node(int node, int value) {
            this.node = node;
            this.value = value;
        }
    }
}