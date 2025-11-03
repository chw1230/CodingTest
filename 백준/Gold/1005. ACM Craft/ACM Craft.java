import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static int[] sum;
    private static int[] arr;
    private static int[] visited;
    private static ArrayList<ArrayList<Integer>> Rgraph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());


        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            Rgraph = new ArrayList<>();
            for (int j = 0; j <= N; j++) {
                Rgraph.add(new ArrayList<>());
            }

            sum = new int[N + 1];
            arr = new int[N + 1];
            visited = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j <= K; j++) {
                StringTokenizer st1 = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st1.nextToken());
                int b = Integer.parseInt(st1.nextToken());
                Rgraph.get(b).add(a); // 역방향
            }

            for (int j = 1; j <= N; j++) {
                dfs(j);
            }
            int w = Integer.parseInt(br.readLine());
            System.out.println(sum[w]);
        }
    }

    private static int dfs(int j) {
        if (visited[j] == 1) {
            return 0;
        }
        if (visited[j] == 2) {
            return sum[j];
        }

        visited[j] = 1;
        int n = 0;
        for (Integer a : Rgraph.get(j)) {
            n = Math.max(dfs(a), n);
        }
        sum[j] = n + arr[j];
        visited[j] = 2;
        return sum[j];
    }
}