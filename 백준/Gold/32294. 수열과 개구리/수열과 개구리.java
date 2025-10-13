import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static final long INF = 4_000_000_000_000_000_000L;
    private static int n;
    private static long arrA[]; // 해당 인덱스일때 움직일 수 있는 값 배열
    private static long arrB[]; // 해당 인덱스일때 기다려야 하는 값 배열
    private static long time[]; // 최단 시간 배열
    // 왜 배열을 양옆에 하나씩 더 잡았나(N+2)? -> 배열을 넘어가야 탈출 => 하나 넘어가든 다 넘어 가든 다 똑같이 처리 [0]과 [n+1]에 담아버리기 어찌 되었든 최종은 가장 좌측 또는 가장 우측이니까!
    private static ArrayList<ArrayList<Edge>> re; // 뒤집은 그래프 인접 리스트

    /*
     문제점 i 지점에서 다익스타라 하면서 너무 많은 다익스트라 동작을 진행함! 이를 해결하자! 반대로 인덱스 0과 n+1에서 다익스트라를 해보기
     안에서 밖으로 문제해결 x , 밖에서 안으로 문제해결 -> 그래프도 그에 맞게 설정, 다익스트라의 시작점 2개(맨앞과 맨뒤) 
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        arrA = new long[n + 2];
        arrB = new long[n + 2];
        st = new StringTokenizer(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arrA[i] = Integer.parseInt(st.nextToken()); // move 배열
            arrB[i] = Integer.parseInt(st1.nextToken()); // move에 걸리는 시간 배열
        }

        re = new ArrayList<>();
        for (int i = 0; i <= n + 1; i++) {
            re.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            // 밖에서 들어오는 거라고 생각하자!
            long L = i - arrA[i]; // 왼쪽에서 들어오기
            long R = i + arrA[i]; // 오른쪽에서 들어오기

            if (L >= 1) { // 안에서 안으로 연결하는 로직
                re.get((int) L).add(new Edge(i, arrB[i]));
            } else {  // 밖 0 에서 안으로 연결하는 로직
                re.get(0).add(new Edge(i, arrB[i]));
            }

            if (R <= n) { // 안에서 안으로 연결하는 로직
                re.get((int) R).add(new Edge(i, arrB[i]));
            } else { // 밖에서 안으로 연결하는 로직
                re.get(n + 1).add(new Edge(i, arrB[i]));
            }
        }

        time = new long[n + 2];
        Arrays.fill(time, INF);
        dijkstra();

        for (int i = 1; i <= n; i++) {
            bw.write(time[i] + " ");
        }
        bw.flush();
        bw.close();
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 시작점을 2개로 하기!! -> 시작 점 기준 : 밖
        time[0] = 0;
        time[n + 1] = 0;
        pq.offer(new Node(0, 0));
        pq.offer(new Node(n + 1, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            long curB = cur.b;
            long curT = cur.time;

            if (curT > time[(int) curB]) {
                continue;
            }

            // 거꾸로된 연결 관계 그래프에서 루프
            for (Edge e : re.get((int) curB)) {
                long nT = curT + e.w;
                if (nT < time[e.to]) {
                    time[e.to] = nT;
                    pq.offer(new Node(e.to, time[e.to]));
                }
            }
        }
    }

    static class Edge {
        int to;
        long w;

        public Edge(int to, long w) {
            this.to = to;
            this.w = w;
        }
    }

    static class Node implements Comparable<Node> {
        long b;
        long time;

        public Node(long b, long time) {
            this.b = b;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.time, o.time);
        }
    }
}