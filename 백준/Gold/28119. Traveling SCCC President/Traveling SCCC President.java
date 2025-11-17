import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 건물의 개수
        int M = Integer.parseInt(st.nextToken()); // 도로의 개수
        int S = Integer.parseInt(st.nextToken()); // 출발 번호

        List<Edge> edges = new ArrayList<>(M);

        // 간선 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Edge(u, v, w));
        }

        st = new StringTokenizer(br.readLine()); // 우리가 원하는 것은 최소 소요 시간임!! - 그래서 방문 순서에 상관이 없음!
        // 그래서 만약 3 으로 가야하는데 1에서 출발한다 근데 2로 들렀다 가는게 더 빠르다 그려먼 그냥 최소 스패닝 트리를 구해서
        // 이동 순서에 상관없이 구하면 되는것! 그 순간이동은 시간이 들지 않으니까!


        // 크루스칼을 위해 가중치 기준 정렬
        Collections.sort(edges);

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        long answer = 0L;
        int selected = 0;
        for (Edge e : edges) {
            if (union(e.u, e.v)) {  
                answer += e.w;
                selected++;
                if (selected == N - 1) {
                    break; // 노드 수 - 1 이면 mst
                }
            }
        }

        System.out.println(answer);
    }

    private static boolean union(int u, int v) {
        u = find(u);
        v = find(v);

        if (u == v) {
            return false;
        }
        parent[v] = u;
        return true;
    }

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }

    static class Edge implements Comparable<Edge> {
        int u, v, w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }
}