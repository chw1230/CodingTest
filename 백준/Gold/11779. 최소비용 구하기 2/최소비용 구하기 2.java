import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.compare;

public class Main {
    private static int n, m;
    private static int[] pre; // 이전 node를 저장하는 배열 경로를 역추적할때 사용
    private static int[] dist; // 최단 거리 배열
    private static AbstractList<ArrayList<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
        }

        dist = new int[n + 1];
        Arrays.fill(dist, (int) 1e8);
        pre = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dijkstra(start);
        System.out.println(dist[end]);
        path(start, end);
    }

    // 경로 역추적 메서드
    private static void path(int s, int e) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.push(e);

        while (e != s) {
            e = pre[e];
            q.addFirst(e);
        }

        System.out.println(q.size()); // 최단 거리까지 가는데 거치는 노드의 개수
        for (Integer i : q) {
            System.out.print(i + " ");
        }
    }

    private static void dijkstra(int s) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(s, 0));
        pre[s] = s;
        dist[s] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int idx = cur.getIdx();
            int dis = cur.getDis();

            if (dis > dist[idx]) {
                continue;
            }

            for (int i = 0; i < graph.get(idx).size(); i++) {
                int nIdx = graph.get(idx).get(i).getIdx();
                int nDis = graph.get(idx).get(i).getDis() + dist[idx];

                if (nDis < dist[nIdx]) {
                    dist[nIdx] = nDis;
                    pq.offer(new Node(nIdx, nDis));
                    pre[nIdx] = idx;
                }
            }
        }
    }

    public static class Node implements Comparable<Node> {
        int idx;
        int dis;

        public Node(int b, int c) {
            this.idx = b;
            this.dis = c;
        }

        public int getIdx() {
            return idx;
        }

        public int getDis() {
            return dis;
        }

        @Override
        public int compareTo(Node o) {
            return compare(this.dis, o.dis);
        }
    }
}