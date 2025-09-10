import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int V;
    private static int E;
    private static ArrayList<ArrayList<Node>> graph = new ArrayList<>(); // 노드들간의 관계를 나타내느 graph
    private static PriorityQueue<Node> pq = new PriorityQueue<>();
    private static int[] arr; // 최단 거리를 담을 배열

    public static class Node implements Comparable<Node> {
        int idx;
        int distance;

        public Node(int idx, int distance) {
            this.idx = idx;
            this.distance = distance;
        }

        public int getIdx() {
            return idx;
        }

        public int getDistance() {
            return distance;
        }

        @Override
        public String toString() {
            return idx + " " + distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

    public static void dijkstra(int start) {
        // 시작 노드에 관한 설정
        pq.add(new Node(start, 0));
        arr[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll(); // 현재 노드 가져오기
            int curIdx = cur.getIdx();
            int curDis = cur.getDistance();

            if ( arr[curIdx] < curDis ) { // 이미 최소 비용 보다 크면 굳이 더 계산을 해볼 필요도 없지!!
                continue;
            }

            for (int i = 0; i < graph.get(curIdx).size(); i++) { // 현재 노드와 연결된 노드 수 만큼 반복
                int cost = arr[curIdx] + graph.get(curIdx).get(i).getDistance();
                if ( cost < arr[graph.get(curIdx).get(i).getIdx()]) {
                    arr[graph.get(curIdx).get(i).getIdx()] = cost;
                    pq.offer(new Node(graph.get(curIdx).get(i).getIdx(), cost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken()); // 정점의 개수
        E = Integer.parseInt(st.nextToken()); // 간선의 개수
        int K = Integer.parseInt(br.readLine()); // 시작 정점의 번호

        // 최단 거리 배열 초기화
        arr = new int[V + 1];
        Arrays.fill(arr, (int) 1e9); // 최단 거리를 담을 거니까 큰 수로 초기화 진행하기!

        for (int i = 0; i <= V; i++) { // 노드의 개수 + 1 만큼 그래프 초기화 해주기
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // 시작점
            int v = Integer.parseInt(st.nextToken()); // 종료점? 도착점?
            int w = Integer.parseInt(st.nextToken()); // 가중치

            graph.get(u).add(new Node(v, w));
        }

        dijkstra(K);

        for (int i = 1; i <= V; i++) {
            if (arr[i] == (int) 1e9) {
                System.out.println("INF");
            } else {
                System.out.println(arr[i]);
            }
        }
    }
}