import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 좀 간단하게 생객해보자..!!
    private static int N, K;
    private static int dist[];
    private static int cnt[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            System.out.println(1);
            return;
        }

        dist = new int[100001]; // 최단 시간를 담을 배열
        cnt = new int[100001];
        Arrays.fill(dist, -1);
        dist[N] = 0; // 시작점 0 처리
        cnt[N] = 1; // 시작점에서 시작점으로 가능 방법은 1가지

        BFS(N);
    }

    private static void BFS(int n) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(n);

        while (!q.isEmpty()) {
            int cur = q.poll();

            int option[] = {-1, 1, 2};
            for (int i : option) {
                int newPos;
                if (i == 2) {
                    newPos = cur * i;
                } else {
                    newPos = cur + i;
                }

                if (0 > newPos || newPos > 100000) {
                    continue;
                }

                if (dist[newPos] == -1) { // 허용 가능 범위 + 방문 하지 않았을 경우
                    dist[newPos] = dist[cur] + 1;
                    cnt[newPos] = cnt[cur]; // 이 부분 이해하는게 가장 어려웠음!!! -> cur 수 까지 가는데 여러가지 경우가 있을 수 있음! 그러니까! 그대로 그 값을 이어 받기!! 첫 방문 이니까!! ex> 3 - 4 - 5 - 6 , 3 - 8 - 7 - 6 이런 느낌!!
                    q.add(newPos);
                } else if (dist[newPos] == dist[cur] + 1) { // 큐에 넣지 않고 그냥 cnt 값만 키워주기!!!!
                    cnt[newPos] += cnt[cur]; // 이 부분 이해하기도 어려웠음! 왜 cnt[newPos]++ 이 아니라  cnt[newPos] += cnt[cur]; 이거 인가? -> 이미 이 부분에 왔다면 cnt[newCur]에는 이미 값이 들어가 있음 근데 생각을 해보자 이 부분에 왔다는 것은 새로운 부모를 통해서 여기에 도착을 한 것 이다!
                    // 새로운 부모를 통해서 연결되었으니까 그것과 관련해서 새로운 경로 수를 통채로 더해 줘야지!!
                    // 정말 간단하게 생각하면 일차원 배열에서 좌측에서 값이 더해져온 거랑 우측에서 빼지면서 온 경로의 수 둘을 합해서 답을 구하는 것과 유사한 느낌!!
                }
            }
        }
        System.out.println(dist[K]);
        System.out.println(cnt[K]);
    }
}