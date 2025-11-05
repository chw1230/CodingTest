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

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, w));
        }

        Collections.sort(edges); // 가중치가 작은 순으로 정렬하기!

        parent = new int[N + 1]; // idx 노드의 부모 노드 번호를 담는 배열
        for (int i = 1; i <= N; i++) {
            parent[i] = i; // 처음에는 자기 자신으로 초기화!
        }

        int sum = 0;
        int max = 0; // 마을을 두개로 분리하는 것이 우리의 목표인데,
        // mst만들어서 가장 가중치가 높은 엣지를 하나 끊어내면 마을을 두쪽 낼 수 있음

        for (Edge edge : edges) {
            if (!find(edge)) { // 시작 노드와 도착 노드가 같은 집합에 속해있는지 확인
                union(edge); // 같은 집합이 아니면 합치기
                sum += edge.w;
                max = Math.max(max, edge.w);
            }
        }
        System.out.println(sum - max); // mst 가중치 합에서 반쪼갈 내기 위한 mst 중 가중치가 가장 큰거 빼기
    }

    private static void union(Edge edge) {
        int A = edge.a;
        while (A != parent[A]) {
            parent[A] = parent[parent[A]];
            A = parent[A];
        }

        int B = edge.b;
        while (B != parent[B]) {
            parent[B] = parent[parent[B]];
            B = parent[B];
        }

        if (A < B) {
            parent[B] = A;
        } else {
            parent[A] = B;
        }
    }

    private static boolean find(Edge edge) {
        int A = edge.a;
        while (A != parent[A]) {
            parent[A] = parent[parent[A]];
            A = parent[A];
        }

        int B = edge.b;
        while (B != parent[B]) {
            parent[B] = parent[parent[B]];
            B = parent[B];
        }

        if (A == B) {
            return true;
        }
        return false;
    }


    static class Edge implements Comparable<Edge> {
        int a;
        int b;
        int w;

        Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }


        @Override
        public String toString() {
            return "a: " + a + "b: " + b + ", w: " + w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }
}