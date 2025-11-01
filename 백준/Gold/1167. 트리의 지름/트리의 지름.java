import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static int maxIdx;
    private static int maxDist;
    private static int[] dist;
    private static boolean[] visited;
    private static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            while (true) {
                int b = Integer.parseInt(st.nextToken());
                if (b == -1) {
                    break;
                }
                int v = Integer.parseInt(st.nextToken());
                graph.get(a).add(new Node(b, v));
            }
        }

        dist = new int[N + 1];
        visited = new boolean[N + 1];
        dfs(1, 0); // 임의의 한 점에서 돌려서 maxIdx를 구하기!!

        visited = new boolean[N + 1];
        dfs(maxIdx, 0);
        System.out.println(maxDist);
    }

    private static void dfs(int i, int value) {
        visited[i] = true;
        dist[i] = value;
        if (dist[i] > maxDist) {
            maxDist = dist[i];
            maxIdx = i;
        }

        for (Node node : graph.get(i)) {
            if (!visited[node.n]) {
                dfs(node.n, node.value + value);
            }
        }

    }

    static class Node {
        int n;
        int value;

        Node(int n, int value) {
            this.n = n;
            this.value = value;
        }

        @Override
        public String toString() {
            return n + " ";
        }
    }
}