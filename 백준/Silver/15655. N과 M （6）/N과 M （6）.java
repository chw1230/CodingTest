import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int M;
    private static int[] arr;
    private static int[] checked;
    private static boolean[] visited;


    private static void DFS(int cnt) {
        if (cnt == M) {
            for (int i : checked) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                if ( 1 <= cnt ) {
                    if (checked[cnt-1] < arr[i]) {
                        visited[i] = true;
                        checked[cnt] = arr[i];
                        DFS(cnt+1);
                        visited[i] = false;
                    }
                } else {
                    visited[i] = true;
                    checked[cnt] = arr[i];
                    DFS(cnt+1);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        checked = new int[M];
        visited = new boolean[N];
        DFS(0);

    }
}