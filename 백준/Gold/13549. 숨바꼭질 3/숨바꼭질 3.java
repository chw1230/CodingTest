import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[] arr;
    private static int[] visited;
    private static Queue<Integer> q = new ArrayDeque<>();
    private static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[100_001];
        visited = new int[100_001];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }

        arr[N] = 0;
        BFS(N);
    }

    private static void BFS(int n) {
        visited[N] = 1;
        q.add(n);

        while (!q.isEmpty()) {
            int cur = q.poll();
            visited[cur] = 1;
            if (cur == K) {
                System.out.println(arr[K]);
                return;
            }

            if (cur * 2 <= 100_000) {
                if (visited[cur * 2] == 0 && arr[cur * 2] == -1) {
                    arr[cur * 2] = arr[cur];
                    q.add(cur * 2);
                }
            }
            
            if (cur - 1 >= 0) {
                if (visited[cur - 1] == 0 && arr[cur - 1] == -1) {
                    arr[cur - 1] = arr[cur] + 1;
                    q.add(cur - 1);
                }
            }

            if (cur + 1 <= 100_000) {
                if (visited[cur + 1] == 0 && arr[cur + 1] == -1) {
                    arr[cur + 1] = arr[cur] + 1;
                    q.add(cur + 1);
                }
            }
        }
    }
}