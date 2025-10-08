import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.Integer.compare;

public class Main {
//    헷갈렸던 부분 -> 만약에 < 출발 - v1 - 출발 - v2 - end > 이런 경우라면? 어떻게 해결하지? => 사실 이거를 고민할 필요가 없음! 다익스트라로 생기는 최단 거리 배열의 특징으 이용하기 때문에!

    private static int N, E;
    private static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        // 그래프와 최단 거리 배열 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        int[] distStart = new int[N + 1]; // 시작점 1에서의 최단 거리 배열
        int[] distNode1 = new int[N + 1]; // 필수 Node1에서의 최단 거리 배열
        int[] distNode2 = new int[N + 1]; // 필수 Node2에서의 최단 거리 배열
        Arrays.fill(distStart, (int) 1e8);
        Arrays.fill(distNode1, (int) 1e8);
        Arrays.fill(distNode2, (int) 1e8);

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 양방향 연결
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());  // 필수 방문
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        distStart = dijkstra(1, distStart);
        distNode1 = dijkstra(v1, distNode1);
        distNode2 = dijkstra(v2, distNode2);

        int sum1 = distStart[v1] + distNode1[v2] + distNode2[N]; // 출발점에서 v1까지 + v1에서 v2까지 + v2에서 N까지
        int sum2 = distStart[v2] + distNode1[N] + distNode2[v1]; // 출발점에서 v2까지 + v1에서 N까지 + v2에서 v1까지
        // 각 배열들은 각각 출발점, v1,v2에서 출발 했을 때 각 인덱스 노드까지의 초단 거리를 의미하는 것을 이용하기!
        
        int r = Math.min(sum1, sum2);
        if (r >= (int) 1e8) {
            System.out.println(-1);
            return;
        }
        System.out.println(r);
    }

    public static int[] dijkstra(int s, int[] arr) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        arr[s] = 0;
        pq.add(new Node(s, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int node = cur.getNode();
            int weight = cur.getWeight();

            if (weight > arr[node]) {
                continue;
            }

            for (int i = 0; i < graph.get(node).size(); i++) {
                int nextNode = graph.get(node).get(i).getNode();
                int w = graph.get(node).get(i).getWeight() + arr[node];

                if (arr[nextNode] > w) {
                    arr[nextNode] = w;
                    pq.add(new Node(nextNode, w));
                }
            }
        }
        return arr;
    }

    public static class Node implements Comparable<Node> {
        int node;
        int weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        public int getNode() {
            return node;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public int compareTo(Node o) {
            return compare(this.weight, o.weight);
        }
    }
}