import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {

        int spot;
        int distance;

        // 위치, 위치까지 가는 비용
        public Node(int spot, int distance) {
            this.distance = distance;
            this.spot = spot;
        }

        public int getSpot() {
            return spot;
        }

        public int getDistance() {
            return distance;
        }

        @Override
        public String toString() {
            return spot + " " + distance;
        }

        @Override
        public int compareTo(Node n){
            return distance - n.getDistance();
        }
    }

    private static int N;
    private static int M;
    private static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    private static int[] distance = new int[100001]; // 최단 거리를 담을 1차원 배열

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 시작점 관해서 다루기
        pq.add(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            // 현재 노드를 뽑기
            Node node = pq.poll();
            int d = node.getDistance();
            int spot = node.getSpot();

            if (distance[spot] < d) { // 이미 더 작은 비용을 가지고 있으면 넘어가기!
                continue;
            }

            for (int i = 0; i < graph.get(spot).size(); i++) {
                int cost = distance[spot] + graph.get(spot).get(i).getDistance(); // 현재 노드와 연결된 노드까지 가는데 드는 비용을 변수에 넣기

                if (cost < distance[graph.get(spot).get(i).getSpot()]) { // 기존에 최고 비용 배열에 넣은 곳과 비교
                    distance[graph.get(spot).get(i).getSpot()] = cost; // 최신화
                    pq.add(new Node(graph.get(spot).get(i).getSpot(),cost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 도시의 개수
        M = Integer.parseInt(br.readLine()); // 버스의 개수

        // 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()); // 출발 도시
            int end = Integer.parseInt(st.nextToken()); // 도착 도시
            int cost = Integer.parseInt(st.nextToken()); // 비용
            graph.get(start).add(new Node(end, cost));
        }

        // 최단 거리 배열을 최대값으로 초기화 하기!
        Arrays.fill(distance, Integer.MAX_VALUE);

//        System.out.println(graph);
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int startPoint = Integer.parseInt(st2.nextToken());
        int endPoint = Integer.parseInt(st2.nextToken());

        dijkstra(startPoint);
        System.out.println(distance[endPoint]);
    }
}