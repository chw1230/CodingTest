import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 뭔가 쉽게 생각을 해보면 그냥 그래프를 거꾸로 해서 해결하면 되는 거 아닌가?
    // 당연히 하나의 그래프로 루프 돌면서 문제를 풀면 시간초과 날게 뻔하니까 한번 그래프를 꺼꾸루 해보쟈
    // 거꾸로 하는게 정답이였다!!
    // 생각 정리 : 모든 집에서 2로 가야해, 그리고 2에서 집으로 다시 가야해! -> 그러면 2에서 오는 것은 문제가 없네? => 2를 출발호 해서 다익스트라하면 되니까!!
    // 모든 집에서 2로 가는 거는 어떻게 하지? -> 문제에서 '모든 학생들은 집에서 X에 갈수 있고, X에서 집으로 돌아올 수 있는 데이터만 입력으로 주어진다.'라고 하였기 때문에
    // 그래프의 방향을 반대로 해서 저장하는 그래프를 통해서 2부터 출발하면 모든 루프를 돌지 않고 2번으로 오늘 시간을 구할 수 있음!
    private static int N, X, M;
    private static int arr[];
    private static int arrREVERSE[];
    private static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    private static ArrayList<ArrayList<Node>> graphREVERSE = new ArrayList<>();
    private static PriorityQueue<Node> pq = new PriorityQueue<>();

    private static class Node implements Comparable<Node> {
        int idx;

        int time;
        public Node(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }

        public int getIdx() {
            return idx;
        }

        public int getTime() {
            return time;
        }

        @Override
        public String toString() {
            return idx + " " + time;
        }

        @Override
        public int compareTo(Node node) {
            return this.time - node.time;
        }
    }

    private static void dijkstra(int start, int n) {
        pq.add(new Node(start, 0));
        if (n == 1) {
            arr[start] = 0;
        } else {
            arrREVERSE[start] = 0;
        }

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curIdx = cur.getIdx();
            int curTime = cur.getTime();

            if (n == 1) {
                if (arr[curIdx] < curTime) {
                    continue;
                }

                for (int i = 0; i < graph.get(curIdx).size(); i++) {
                    int time = arr[curIdx] + graph.get(curIdx).get(i).getTime();

                    if (time < arr[graph.get(curIdx).get(i).getIdx()]) {
                        arr[graph.get(curIdx).get(i).getIdx()] = time;
                        pq.add(new Node(graph.get(curIdx).get(i).getIdx(), time));
                    }
                }
            } else {
                if (arrREVERSE[curIdx] < curTime) {
                    continue;
                }

                for (int i = 0; i < graphREVERSE.get(curIdx).size(); i++) {
                    int time = arrREVERSE[curIdx] + graphREVERSE.get(curIdx).get(i).getTime();

                    if (time < arrREVERSE[graphREVERSE.get(curIdx).get(i).getIdx()]) {
                        arrREVERSE[graphREVERSE.get(curIdx).get(i).getIdx()] = time;
                        pq.add(new Node(graphREVERSE.get(curIdx).get(i).getIdx(), time));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // N명의 학생
        M = Integer.parseInt(st.nextToken()); // edge 개수
        X = Integer.parseInt(st.nextToken()); // X 마을에 모여서 -> 도착점

        // 최단 거리 배열 2개 초기화
        arr = new int[N+1];
        Arrays.fill(arr,(int) 1e9);
        arrREVERSE = new int[N+1];
        Arrays.fill(arrREVERSE,(int) 1e9);

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            graphREVERSE.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, t));
            graphREVERSE.get(end).add(new Node(start, t));
        }

        pq = new PriorityQueue<>();
        dijkstra(X,1 ); // X 마을에서 집에오는 거를 구하자 -> graph 이용

        pq = new PriorityQueue<>();
        dijkstra(X,0 ); // 반대

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, arr[i] + arrREVERSE[i]);
        }
        System.out.println(max);
    }
}