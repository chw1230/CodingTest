import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] dist;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }

            dist = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(dist[i], 1_000_000_000);
            }

            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dist[0][0] = arr[0][0]; // 시작 점에도 비용 존재해가지구
            dijkstra();

            cnt++;
            System.out.println("Problem " + cnt + ": " + dist[N - 1][N - 1]);
        }
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0,0,arr[0][0]));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int s = cur.s;
            int e = cur.e;
            int w = cur.w;

            if (dist[s][e] < w) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int ns = s + dx[i];
                int ne = e + dy[i];

                if (ns < 0 || ne < 0 || ns >= N || ne >= N) {
                    continue;
                }
                
                int nextW = arr[ns][ne] + w;
                if (nextW < dist[ns][ne]) {
                    dist[ns][ne] = nextW;
                    pq.offer(new Node(ns, ne, nextW));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int s;
        int e;
        int w;

        Node(int s,int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
}