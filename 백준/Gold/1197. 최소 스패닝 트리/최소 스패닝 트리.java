import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        ArrayList<Edge> edges = new ArrayList<>();
        parent = new int[V + 1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges.add(new Edge(start, end, weight));
        }

        Collections.sort(edges);

        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }

        long sum = 0;
        for (Edge edge : edges) {
            if (!find(edge)) {
                union(edge);
                sum += edge.weight;
            }
        }
        System.out.println(sum);
    }

    private static void union(Edge edge) {
        int start = edge.start;
        while (start != parent[start]) {
            parent[start] = parent[parent[start]];
            start = parent[start];
        }

        int end = edge.end;
        while (end != parent[end]) {
            parent[end] = parent[parent[end]];
            end = parent[end];
        }

        if (parent[start] <= parent[end]) {
            parent[end] = parent[start];
        } else {
            parent[start] = parent[end];
        }
    }

    private static boolean find(Edge edge) {
        int start = edge.start;
        while (start != parent[start]) {
            parent[start] = parent[parent[start]];
            start = parent[start];
        }

        int end = edge.end;
        while (end != parent[end]) {
            parent[end] = parent[parent[end]];
            end = parent[end];
        }

        if (start == end) {
            return true;
        } else {
            return false;
        }
    }

    static class Edge implements Comparable<Edge> {
        int start, end;
        int weight;

        Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }

        @Override
        public String toString() {
            return "Edge [start=" + start + ", end=" + end + ", weight=" + weight + "]";
        }
    }
}