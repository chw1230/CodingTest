import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static int[] visited;
    private static ArrayList<ArrayList<Integer>> Rgraph = new ArrayList<>();
    private static ArrayDeque<Integer> stack = new ArrayDeque<>();
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + 1; i++) {
            Rgraph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Rgraph.get(b).add(a);
        }

        visited = new int[N + 1];
        arr = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            System.out.print(dfs(i) + " ");
        }
    }

    private static int dfs(int i) {
        if (visited[i] == 1) {
            return arr[i];
        }
        if (visited[i] == 2) {
            return arr[i];
        }

        int n = 1;
        visited[i] = 1; 
        for (int b : Rgraph.get(i)) {
            n = Math.max(n, dfs(b) + 1);
            dfs(b);
        }
        arr[i] = n;
        visited[i] = 2;

        return arr[i];
    }
}