import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    private static int visited[];
    private static ArrayList<TreeSet<Integer>> graph = new ArrayList<>();
    private static int cnt;

    private static void DFS(int u) {
        if ( visited[u] == 0 ){
            visited[u] = cnt++;
        }

        for (Integer i : graph.get(u)) {
            if (visited[i] == 0) {
                DFS(i);
            }
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N+1; i++) {
            graph.add(new TreeSet<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        // System.out.println(graph);
        visited = new int[N+1];

        cnt = 1;
        DFS(R);

        for (int i = 1; i < N+1; i++) {
            System.out.println(visited[i]);
        }
    }
}