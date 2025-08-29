import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static int[] d = new int[300001];
    private static Queue<Integer> q = new LinkedList<>();

    private static void BFS(int s) {
        q.offer(s);
        d[s] = 0;

        int cnt = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : graph.get(u)) {
                if (d[v] == Integer.MAX_VALUE) {
                    d[v] = d[u] + 1; // 이전 노드가 왔던 길 에다가 1만 더해주기!
                    q.offer(v);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

//        System.out.println(graph);

        Arrays.fill(d,Integer.MAX_VALUE);
        BFS(X);

        int cnt = 0;
        for (int i = 0; i <= N; i++) {
            if ( d[i] == K) {
                cnt++;
                System.out.println(i);
            }
        }
        if (cnt == 0) {
            System.out.println(-1);
        }
    }
}