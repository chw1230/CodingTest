import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.Integer.compare;

public class Main {
    private static int N, T;
    private static int arr[][];
    private static int dist[][][]; // 최단 거리 배열 --> 단계 별로 구분하기!
    // [][][0] -> 3 걸음 움직여서 방금 풀을 먹고, 새로운 3걸음을 할 수 있는 상태
    // [][][1] -> 이전에 풀을 먹고, 1 걸음을 움직인 상태
    // [][][2] -> 2걸음을 움직인 상태
    private static int moveX[] = {0, 0, -1, 1};
    private static int moveY[] = {-1, 1, 0, 0};

    private static void Dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[0][0][0] = 0; // 소의 출발점[0][0][]에서 한 걸음[][][0]도 안걸음( ~~ = 0 )! 0 부터 시작
        pq.offer(new Node(0, 0, 0, 0)); // 시작 점을 넣기!

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            // 소의 위치
            int r = cur.r;
            int c = cur.c;
            int step = cur.step;
            int value = cur.value;

            if (value > dist[r][c][step]) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nR = r + moveY[i];
                int nC = c + moveX[i];

                if (nR < 0 || nC < 0 || nR >= N || nC >= N) {
                    continue; // 밖으로 탈출은 없어요
                }

                int nStep = (step + 1) % 3; // 기존의 스텝에서 한걸음 가기 + 왜 나누기 3? => 0단계가 3 걸음 움직여서 방금 풀을 먹고, 새로운 3걸음을 할 수 있는 상태라고 정했으니까!
                int nValue = value + T; // 풀을 먹고 안먹고의 상관없이 건너는 시간 최신화!

                if (nStep == 0) { // 0단계 -> 3걸은 걸어서 풀 뜯어야함
                    nValue += arr[nR][nC];
                }

                // 발견한 경로가 기존 최단 경로보다 효율적일 경우 갱신해주기
                if (nValue < dist[nR][nC][nStep]) {
                    // 만약에 nstep이 1이거나, 2인데 첫 방문 이야 그러면 그냥 이전 value에 + T(건너는 시간) 만 추가된 값으로 초기화 됨!
                    // 만약에 nstep이 건너는 시간과 풀뜯어 먹은 시간이 들어간 값으로 초기화
                    // 이미 한번 갔던 곳이라면 dist[nR][nC][nStep]가 (int) 1e8이 아닌 값 일 것!! 그래서 이 보다 작아야 최신화 가능하도록 바꾸기
                    dist[nR][nC][nStep] = nValue;
                    pq.offer(new Node(nR, nC, nStep, nValue));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dist = new int[N][N][3];
        // 최단 거리 배열을 큰 값으로 초기화 해주기!
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(dist[i][j], (int) 1e10);
            }
        }

        Dijkstra();

        int min = Integer.MAX_VALUE;
        for (int i : dist[N - 1][N - 1]) {
            // 도착 점이 3번째 일때도 풀을 뜯어야 하니까, 0-1-2 단계 모두 비교하기!
            min = Math.min(min, i);
        }
        System.out.println(min);
    }

    public static class Node implements Comparable<Node> {
        int r, c;
        int step;
        int value;

        public Node(int r, int c, int step, int value) {
            this.r = r;
            this.c = c;
            this.step = step;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return compare(this.value, o.value);
        }
    }
}