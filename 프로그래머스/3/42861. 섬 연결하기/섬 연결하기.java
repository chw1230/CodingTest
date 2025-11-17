import java.util.ArrayList;
import java.util.Collections;

class Solution {

    static int[] parent;

    public int solution(int n, int[][] costs) {
        int answer = 0;

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        ArrayList<Edge> edges = new ArrayList<>();
        for (int[] cost : costs) {
            int s = cost[0];
            int e = cost[1];
            int w = cost[2];
            edges.add(new Edge(s, e, w));
        }

        Collections.sort(edges);

        int cnt = 0;
        for (Edge edge : edges) {
            if (union(edge.s, edge.e)) {
                answer += edge.w;
                cnt++;                 
            }
            if (cnt == n - 1) {
                break;
            }
        }
        return answer;
    }

    private boolean union(int s, int e) {
        s = find(s);
        e = find(e);

        if (s == e) {
            return false;
        }
        parent[e] = s;
        return true;
    }

    private int find(int v) {
        if (parent[v] == v) {
            return v;
        }
        return parent[v] = find(parent[v]);
    }

    private static class Edge implements Comparable<Edge> {
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