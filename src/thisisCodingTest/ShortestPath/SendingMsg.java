package thisisCodingTest.ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SendingMsg {
    /*
    문제
    어떤 나라에는 N개의 도시가 있다.
    그리고 각 도시는 보내고자 하는 메시지가 있는 경우, 다른 도시로 전보를 보내서 다른 도시로 해당 메시지를 전송할 수 있다.
    하지만 X라는 도시에서 Y라는 도시로 전보를 보내고자 한다면, 도시 X에서 Y로 향하는 통로가 설치되어 있어야 한다.
    예를 들어 X에서 Y로 향하는 통로는 있지만, Y에서 X로 향하는 통로가 없다면 Y는 X로 메시지를 보낼 수 없다.
    또한 통로를 거쳐 메시지를 보낼 때는 일정 시간이 소요된다.
    어느 날 C라는 도시에서 위급 상황이 발생했다. 그래서 최대한 많은 도시로 메시지를 보내고자 한다.
    메시지는 도시 C에서 출발하여 각 도시 사이에 설치된 통로를 거쳐, 최대한 많이 퍼져나갈 것이다.
    각 도시의 번호와 통로가 설치되어 있는 정보가 주어졌을 때,
    도시 C에서 보낸 메시지를 받게 되는 도시의 개수는 총 몇 개이며
    도시들이 모두 메시지를 받는 데까지 걸리는 시간은 얼마인지 계산하는 프로그램을 작성하시오.

    입력 조건
    첫째 줄에 도시의 개수 N, 통로의 개수 M, 메시지를 보내고자 하는 도시 C가 주어진다.
    (1 <= N <= 30,000, 1 <= M <= 200,000, 1 <= C <= N)
    둘째 줄부터 M + 1번째 줄에 걸쳐서 통로에 대한 정보 X, Y, Z가 주어진다.
    이는 특정 도시 X에서 다른 특정 도시 Y로 이어지는 통로가 있으며, 메시지가 전달되는 시간이 Z라는 의미다.
    (1 <= X, Y <= N, 1 <= Z <= 1,000)

    출력 조건
    첫째 줄에 도시 C에서 보낸 메시지를 받는 도시의 총 개수와 총 걸리는 시간을 공백으로 구분하여 출력한다.

    입력 예시
    3 2 1
    1 2 4
    1 3 2

    출력 예시
    2 4
     */

    // 잘못 풀었던 부분 : C에서 도달하지 못하는 노드는 무한 값으로 남아 있을 텐데 그것을 고려 하지 못함!
    // 모든 노드가 도달 가능한 상황만 주어진다고 생각하지 말기
    static class Node implements Comparable<Node> {
        int point;
        int distance;

        public Node(int point, int distance) {
            this.point = point;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return point + " " + distance;
        }

        @Override
        public int compareTo(Node n) {
            return distance - n.distance;
        }

        public int getPoint() {
            return point;
        }

        public int getDistance() {
            return distance;
        }
    }

    private static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    private static int N;
    private static int d[] = new int[30001]; //최단 거리 배열
    private static boolean visited[] = new boolean[30001]; //최단 거리 배열

    private static void dijkstra(int start) {
        // 초기 설정
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        d[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll(); // 현재 노드 뽑기
            int curDistance = cur.getDistance(); // 노드의 거리 값
            int curPoint = cur.getPoint(); // 노드의 위치 값

            if (d[curPoint] < curDistance) { // 최단 거리 배열 값 보다 크면 더 뭐할 필요 없음!
                continue;
            }

            for (int i = 0; i < graph.get(curPoint).size(); i++) {
                if ( graph.get(curPoint).get(i).getDistance() + d[curPoint] < d[graph.get(curPoint).get(i).getPoint()] ) {
                    d[graph.get(curPoint).get(i).getPoint()] = graph.get(curPoint).get(i).getDistance() + d[curPoint];
                    pq.add(new Node(graph.get(curPoint).get(i).getPoint() , d[graph.get(curPoint).get(i).getPoint()]));
                }
            }
        }


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 도시 개수
        int M = Integer.parseInt(st.nextToken()); // 통로 개수
        int C = Integer.parseInt(st.nextToken()); // 메시지를 보내고자 하는 도시


        // 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b,c)); // 단방향 연결
        }

        // 큰 값으로 초기화
        Arrays.fill(d, (int) 1e9);
        dijkstra(C);

        // 도달한 노드의 개수와 도시들이 모두 메시지를 받는게 걸리는 시간
        // 도달했는지 안했는지를 어케 알지? -> (int) 1e9 값이면 도달 못한것! 고립되어서 도달 못한 것 일수도!!

        int cnt = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            if ( d[i] != (int) 1e9) { // 도달 했다면
                cnt++;
                max = Math.max(max, d[i]);
            }
        }

        System.out.println(cnt + " " + max);
    }
}
/*
3 2 1
1 2 4
1 3 2
-----
2 4
 */
