import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 뱀과 사다리를 분리할까 말까 고민했는데 그냥 무조건 a->b로 그냥 a,b 그대로 인덱스로 사용해서 해결하기로함!
    // 처음에 문제를 푸는데 뱀이 오는 곳이면 방문을 안하고 피하는 방법으로 풀었음 -> 계속 오답 ㅜ
    // 문제 해결 오류 : 사다리인 칸 + 뱀인 칸 같이 그냥 커치는 곳도 큐에 넣어서 해결함! 그냥 그럴 필요 없이 바로 해당 지점의 목적지로 가서 목적지에 대해서 BFS를 진행하는 방법으로 진행!!!
    private static Queue<Integer> q;
    private static int[] moves = new int[101];
    private static int[] cnt = new int[101]; // 주사위 던진 횟수
    private static int[] visited = new int[101];
    private static Queue<Integer> queue = new ArrayDeque<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            moves[a] = b; // 무조건 a에서 b로 이동!
        }

        bfs();      
        System.out.println(cnt[100]);
    }

    private static void bfs() {
        queue.add(1); // 큐에 넣기
        visited[1] = 1; // 방문 처리
        cnt[1] = 0; // 자기 자신의 거리 넣기

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == 100) {
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int tmp = cur + i; // 기존 수 + 주사위에서 나온 수
                if (tmp > 100) {
                    continue;
                }

                if ( moves[tmp] != 0 ) { // 뱀 또는 사다리 관계가 있다면
                    tmp = moves[tmp]; // 그 즉시 연결된 곳으로 바로 이동
                }

                if ( visited[tmp] == 0) { // 방문 한 적 없으면
                    visited[tmp] = 1;
                    queue.add(tmp);
                    cnt[tmp] = cnt[cur] + 1;
                }
            }
        }
    }
}