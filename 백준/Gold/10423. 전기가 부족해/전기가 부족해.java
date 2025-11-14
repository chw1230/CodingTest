import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    private static int N, M, K;
    private static int[] parent;
    private static boolean[] plant;
    private static ArrayList<edge> edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        plant = new boolean[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= K; i++) {
            plant[Integer.parseInt(st.nextToken())] = true;
        }

        edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges.add(new edge(s, e, w));
        }
        Collections.sort(edges);

        int sum = 0;
        for (edge edge : edges) {
            if (union(edge.s, edge.e)) {
                sum += edge.w;
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

        if ( plant[s] && plant[e]) { // 둘다 발전소를 가지고 있으면 연결할 필요없음!
            return false;
        }

        // 작은 쪽의 부모를 따라가고, 둘 중 하나라도 발전소가 있으면 발전소 있음을 표시, 둘다 없으면 그냥 false 되는 거고
        if (s < e) {
            parent[e] = s;
            plant[s] = plant[s] || plant[e];
        } else {
            parent[s] = e;
            plant[e] = plant[s] || plant[e];
        }
        return true;
    }

    private static int find(int v) {
        if ( parent[v] == v ) {
            return v;
        }
        return parent[v] = find(parent[v]);
    }

    static class edge implements Comparable<edge> {
        int s;
        int e;
        int w;

        public edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(edge o) {
            return this.w - o.w;
        }
    }
}