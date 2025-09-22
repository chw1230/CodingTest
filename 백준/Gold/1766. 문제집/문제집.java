import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int n, m;
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static PriorityQueue<Integer> pq = new PriorityQueue<>(); // 가능하면 쉬운 문제 부터 풀기 위해서!!
    private static int[] indegree; // 들어오는 간선(indegree)의 개수를 담는 배열

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

        for (int i = 1; i <= n ; i++) {
            if (indegree[i] == 0) {
                pq.add(i);
            }
        }

        while (!pq.isEmpty()) {
            int u = pq.poll();
            System.out.print( u + " ");
            for (Integer i : graph.get(u)) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    pq.add(i);
                }
            }
        }
    }
}