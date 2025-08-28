package thisisCodingTest.ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityQueueDijkstra {

    public static class Node implements Comparable<Node> {
        // idx로 distance 거리 값을 가지고 연결된다!
        private int idx;
        private int distance;

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

        // 거리가 짧은 것이 더 높은 우선순위를 가지도록하기
        @Override
        public int compareTo(Node n) {
            return distance - n.getDistance();
        }

        public static final int INF = (int) 1e9; // 무한을 의미하는 값

        // 노드 개수 (N) , 간선 개수 (M) , 노드 시작 번호 (start)
        // 노드의 개는 최대 100,000개
        public static int n, m, start;

        // 각 노드(a)에 연결되어 있는 노드에 대한 정보(b와 연결 c라는 거리로 연결)를 담는 배열
        public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

        // 최단 거리를 담을 배열
        public static int[] d = new int[100001];

        public static void dijkstra(int start) {

            PriorityQueue<Node> pq = new PriorityQueue<Node>();
            pq.add(new Node(start, 0)); // 시작 노드 넣기
            d[start] = 0; // 시작 노드 초기화/ 출발 노드는 0으로 설정하고 시작!

            while (!pq.isEmpty()) { // 큐가 비어있지 않다면
                // 가장 최단 거리가 짧은 노드 꺼내기
                Node node = pq.poll(); // pq에서 꺼내면 어차피 자동으로 최단 거리가 가장 짧은 노드임!
                int dist = node.getDistance(); // 현재 노드까지의 비용
                int cur = node.getIdx(); // 현재 노드

                if (d[cur] < dist) {
                    // 현재 우선순위 큐에서 꺼낸 노드까지의 거리(dist)가 이전에 이미 발견된 더 짧은 최단 경로(d[cur])보다 길다면 현재 노드와 연결된 노드를 볼 필요가 없으니까 무시하기
                    continue;
                }

                // 현재 노드와 연결된 다른 노드를 체크
                for (int j = 0; j < graph.get(cur).size(); j++) {
                    int cost = d[cur] + graph.get(cur).get(j).getDistance(); // 현재 노드와 연결된 노드까지 가는데 드는 비용을 cost 변수에 넣기

                    // 만약에 현재 노드를 거처서 다른 노드로 이동하는게 더 거리가 짧은 경우
                    if (cost < d[graph.get(cur).get(j).getIdx()]) {
                        d[graph.get(cur).get(j).getIdx()] = cost; // 최신화
                        pq.offer(new Node(graph.get(cur).get(j).getIdx(), cost)); // 거리가 더 짧으면 pq에 넣기!
                    }
                }
            }
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            n = sc.nextInt();
            m = sc.nextInt();
            start = sc.nextInt();

            // 그래프 초기화
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<Node>());
            }

            // 모든 간선 정보를 입력받기
            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                // a번 노드에서 b번 노드로 가는 비용이 c라는 의미
                graph.get(a).add(new Node(b, c));
            }
            System.out.println(graph);

            // 최단 거리 테이블을 모두 무한으로 초기화
            Arrays.fill(d, INF);

            // 다익스트라 알고리즘을 수행
            dijkstra(start);

            // 모든 노드로 가기 위한 최단 거리를 출력
            for (int i = 1; i <= n; i++) {
                // 도달할 수 없는 경우, 무한(INFINITY)이라고 출력
                if (d[i] == INF) {
                    System.out.println("INFINITY");
                }
                // 도달할 수 있는 경우 거리를 출력
                else {
                    System.out.println(d[i]);
                }
            }
        }
    }
}
