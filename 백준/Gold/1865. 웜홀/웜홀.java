import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        while (TC-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 지점 수
            int M = Integer.parseInt(st.nextToken()); // 도로의 개수
            int W = Integer.parseInt(st.nextToken()); // 웜홀 수

            ArrayList<Edge> list = new ArrayList<>();
            int[] dist = new int[N + 1];
            Arrays.fill(dist, 1_000_000_000);
            dist[1] = 0;

            for (int i = 0; i < M; i++) { // 도로 정보
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                // 도로는 양방향 이였구나.....
                list.add(new Edge(s, e, w));
                list.add(new Edge(e, s, w));
            }

            for (int i = 0; i < W; i++) { // 웜홀 정보
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                list.add(new Edge(s, e, -w));
            }

            for (int i = 1; i < N; i++) {
                for (Edge edge : list) {
                    if (/* dist[edge.s] != 1_000_000_000 && */dist[edge.e] > dist[edge.s] + edge.w) {
                        dist[edge.e] = dist[edge.s] + edge.w; // 최신화
                    }
                }
            }

            boolean negativeCycle = false;
            for (Edge edge : list) {
                if (/* dist[edge.s] != 1_000_000_000 && */ dist[edge.e] > dist[edge.s] + edge.w) {
                    // 내가 고려 하지 못한것! -> 1번 노드가 도달 할 수 없는 곳에서 negativeCycle이 있어서 시간이 줄어들면서 출발 위치로 돌아오는 것이 가능해 지는 경우가 존재 가능함!!
                    // dist[edge.s] != 1_000_000_000 이 조건은 무조건 1번 노드에서 출발했을 때 도달 가능한 것을 의미하니까 빼주기!
                    negativeCycle = true;
                    break;
                }
            }

            if (negativeCycle) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        System.out.println(sb);
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

        @Override
        public String toString() {
            return "Edge [s=" + s + ", e=" + e + ", w=" + w + "]";
        }
    }
}