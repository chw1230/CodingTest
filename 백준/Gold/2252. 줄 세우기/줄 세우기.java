import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int n, m;
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static Queue<Integer> q = new ArrayDeque<>();
    private static int[] indegree; // 들어오는 간선(indegree)의 개수를 담는 배열
    // 위상 정렬 BFS로 풀기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        indegree = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            indegree[b]++;
        }

        // indegree가 0이면 큐에 넣기
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            System.out.print(cur + " ");
            for (Integer i : graph.get(cur)) { // cur와 연결되어 있는 것들
                indegree[i]--; // indegree 감소시켜주기
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }
        }
    }
}