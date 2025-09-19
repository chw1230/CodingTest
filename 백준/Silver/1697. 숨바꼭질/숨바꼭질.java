import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    /* 경계값을 잘 다루자!!!!!!!!!!!!!!!!!*/
    private static int N, K;
    private static int arr[];
    private static int visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            return;
        }

        arr = new int[100001]; // 최단 거리를 담을 배열
        visited = new int[100001];
        Arrays.fill(arr, (int) 1e9);
        arr[N] = 0; // 시작점 0 처리

        BFS(N);
    }

    private static void BFS(int n) {
        Queue<Integer> q = new ArrayDeque<>();
        visited[n] = 1;
        q.add(n);

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == K) {
                System.out.println(arr[cur]);
                return;
            }

            for (int i = 0; i < 3; i++) {
                if (i == 0 && cur >= 1 && visited[cur - 1] == 0 ) {
                    arr[cur - 1] = Math.min(arr[cur - 1], arr[cur]) + 1;
                    q.add(cur - 1);
                    visited[cur - 1] = 1;
                } else if (i == 1 && cur + 1 <= arr.length - 1 && visited[cur + 1] == 0) {
                    arr[cur + 1] = Math.min(arr[cur + 1], arr[cur]) + 1;
                    q.add(cur + 1);
                    visited[cur + 1] = 1;
                } else if (i == 2 && cur * 2 <= arr.length - 1 && visited[cur * 2] == 0) {
                    arr[cur * 2] = Math.min(arr[cur * 2], arr[cur]) + 1;
                    q.add(cur * 2);
                    visited[cur * 2] = 1;
                }
            }
        }
    }
}