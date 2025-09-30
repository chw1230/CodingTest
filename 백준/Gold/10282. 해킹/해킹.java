import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int dist[];
    private static PriorityQueue<Node> pq;
    private static ArrayList<ArrayList<Node>> graph;

    private static void dijkstra(int c) {
        dist[c] = 0;
        pq.offer(new Node(c, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll(); // 일단 노드를 통으로 꺼내기
            int n = node.getNode();
            for (Node i : graph.get(n)) {
                int v = i.getNode(); // 노드
                int time = i.getTime();

                if (dist[v] > time + dist[n])  {
                    dist[v] = time + dist[n]; // 최신화
                    pq.offer(new Node(v, dist[n]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        while (test-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
            int d = Integer.parseInt(st.nextToken()); // 의존성 개수
            int c = Integer.parseInt(st.nextToken()); // 컴퓨터 번호

            pq = new PriorityQueue<>();
            graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken()); // 의존성
                graph.get(b).add(new Node(a, s));
            }

            for (int i = 0; i <= n; i++) {
                Collections.sort(graph.get(i));
            }

            dist = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                dist[i] = (int) 1e8;
            }
            dijkstra(c);

            int max = 0;
            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                if (dist[i] != (int) 1e8) {
                    cnt++;
                    if ( dist[i] > max) {
                        max = dist[i];
                    }
                }
            }
            System.out.println(cnt + " " + max);
        }
    }

    public static class Node implements Comparable<Node> {
        int node;
        int time;

        public Node(int node, int time) {
            this.node = node;
            this.time = time;
        }

        public int getNode() {
            return node;
        }

        public int getTime() {
            return time;
        }

        @Override
        public String toString() {
            return "node=" + node + ", time=" + time;
        } // 디버깅 하려고 만든거

        @Override
        public int compareTo(Node node) {
            return this.time - node.time;
        }
    }
}