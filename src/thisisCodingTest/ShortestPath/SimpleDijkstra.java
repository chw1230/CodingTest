package thisisCodingTest.ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SimpleDijkstra {

    public static class Node {
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
    }

    public static final int INF = (int) 1e9; // 무한을 의미하는 값

    // 노드 개수 (N) , 간선 개수 (M) , 노드 시작 번호 (start)
    // 노드의 개는 최대 100,000개
    public static int n, m, start;

    // 각 노드(a)에 연결되어 있는 노드에 대한 정보(b와 연결 c라는 거리로 연결)를 담는 배열
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

    // 방문 처리를 담당하는 배열
    public static boolean[] visited = new boolean[100001];

    // 최단 거리를 담을 배열
    public static int[] d = new int[100001];

    // 방문하지 않은 노드 중에서, 가장 최단 거리가 짧은 노드의 번호를 반환 (순차 탐색)
    public static int getSmallestNode() {
        int min = INF;
        int index = 0; // 가장 최단 거리가 짧을 노드의 인덱스를 담을 변수
        for (int i = 1; i < n; i++) {
            if ( d[i] < min && !visited[i] ) {
                min = d[i];
                index = i;
            }
        }
        return index;
    }

    public static void dijkstra(int start) {

        d[start] = 0; // 시작 노드 초기화/ 출발 노드는 0으로 설정하고 시작!
        visited[start] = true; // 방문 처리

        for (int i = 0; i < graph.get(start).size(); i++) {
            d[graph.get(start).get(i).getIdx()] = graph.get(start).get(i).getDistance();
        }

        // 시작 노드를 제외한 전체 n - 1개 노드에 대해서 반복하기
        for (int i = 0; i < n - 1; i++) {

            // 현재 최단 거리가 가장 짧은 노드를 꺼낸뒤
            int cur = getSmallestNode();
            visited[cur] = true; // 방문처리하기

            // 현재 노드와 연결된 다른 노드를 체크
            for (int j = 0; j < graph.get(cur).size(); j++) {
                int cost = d[cur] + graph.get(cur).get(j).getDistance(); // 현재 노드와 연결된 노드까지 가는데 드는 비용을 cost 변수에 넣기

                // 만약에 현재 노드를 거처서 다른 노드로 이동하는게 더 거리가 짧은 경우
                if ( cost < d[graph.get(cur).get(j).getIdx()]) {
                    d[graph.get(cur).get(j).getIdx()] = cost; // 최신화
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

/*
6 11
1
1 2 2
1 3 5
1 4 1
2 3 3
2 4 2
3 2 3
3 6 5
4 3 3
4 5 1
5 3 1
5 6 2
-----
0
2
3
1
2
4
 */
