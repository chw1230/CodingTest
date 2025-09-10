import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    static boolean[] visited;

    private static void DFS(int a) {
        if (a == M) { // M개 이면
            for (int i : arr) {
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }

        if (a == 0) {
            for (int i = 1; i <= N; i++) {
                arr[a] = i;
                DFS(a+1);
            }
        } else { // 이 전 배열꺼 부터 시작하도록!
            for (int i = arr[a-1]; i <= N; i++) {
                arr[a] = i;
                DFS(a+1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        arr = new int[M];

        DFS(0);
    }
}