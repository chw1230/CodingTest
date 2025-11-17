import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N]; // 우물 파는데 걸리는 시간
        parent = new int[N + 1];
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            arr[i] = n;
            parent[i + 1] = i + 1;
        }

        ArrayList<Edge> edges = new ArrayList<Edge>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                edges.add(new Edge(i, j, Integer.parseInt(st.nextToken())));
            }
        }

        for (int i = 0; i < arr.length; i++) {
            edges.add(new Edge(i, N, arr[i])); // 우물을 하나의 노드라고 생각하고 연결해주고 이때 가중치를 파는데 걸리는 시간으로 설정하기
        }

        Collections.sort(edges);

        int sum = 0;
        int cnt = 0;
        for (Edge edge : edges) {
            if (union(edge.s, edge.e)) {
                sum += edge.w;
            }

            if (cnt == N - 1) {
                break;
            }
        }
        System.out.println(sum);
    }

    private static boolean union(int s, int e) {
        s = find(s);
        e = find(e);

        if (s == e) {
            return false;
        }

        parent[e] = s;
        return true;
    }

    private static int find(int s) {
        if (parent[s] == s) {
            return s;
        }
        return parent[s] = find(parent[s]);
    }

    static class Edge implements Comparable<Edge> {
        int s;
        int e;
        int w;

        public Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }
}