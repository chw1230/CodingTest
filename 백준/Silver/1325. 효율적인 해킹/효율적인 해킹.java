import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static int N, M, cnt;
    private static int[] visited;
    private static int[] r;
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // vertex 수
        M = Integer.parseInt(st.nextToken()); // edge 수

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(b).add(a);
        }

        int max = Integer.MIN_VALUE;
        r = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            cnt = 1;
            visited = new int[N + 1];
            dfs(i);
            r[i] = cnt;
            max = Math.max(max, cnt);
        }

        for (int i = 1; i <= N; i++) {
            if (r[i] == max) {
                System.out.print(i + " ");
            }
        }
    }

    private static void dfs(int i) {
        visited[i] = 1;

        for (Integer v : graph.get(i)) {
            if (visited[v] == 0) {
                cnt++;
                dfs(v);
            }
        }

    }
}