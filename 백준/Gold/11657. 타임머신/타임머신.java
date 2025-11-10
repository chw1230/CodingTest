import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Edge> edges = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges.add(new Edge(start, end, w));
        }

        long[] dist = new long[N + 1];
        Arrays.fill(dist, 1_000_000_000); // 초기화
        dist[1] = 0; // 시작 정점은 0 처리!

        boolean update;
        for (int i = 1; i <= N; i++) {
            update = false;
            for (Edge edge : edges) {
                if (dist[edge.s] != 1_000_000_000 && dist[edge.e] > dist[edge.s] + edge.w) {
                    dist[edge.e] = dist[edge.s] + edge.w;
                    update = true;
                }
            }
            if (!update) {
                break;
            }
        }

        boolean negativeCycle = false;
        for (Edge edge : edges) {
            if (dist[edge.s] != 1_000_000_000 && dist[edge.e] > dist[edge.s] + edge.w) {
                negativeCycle = true;
            }
        }

        if (negativeCycle) {
            System.out.println(-1);
            return;
        }

        for (int i = 2; i <= N; i++) {
            if (dist[i] == 1_000_000_000) {
                System.out.println(-1);
            } else {
                System.out.println(dist[i]);
            }
        }
    }

    static class Edge {
        int s;
        int e;
        int w;

        public Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }
}