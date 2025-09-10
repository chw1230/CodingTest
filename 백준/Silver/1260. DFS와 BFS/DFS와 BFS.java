import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static boolean[] visited; // 노드 방문 처리를 담을 배열
    public static ArrayList<TreeSet<Integer>> graph = new ArrayList<TreeSet<Integer>>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N,M,V;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        // 그래프 초기화
        for (int i = 0; i < N+1; i++) {
            graph.add(new TreeSet<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
            // 한쪽에만 생성되는 것을 막기위해서 양쪽에 생성하기!
        }
        // System.out.println(graph);

        // 방문 초기화
        visited = new boolean[N+1];
        getDfs(V);

        System.out.print("\n");

        // 방문 초기화
        visited = new boolean[N+1];
        getBfs(V);
    }

    private static void getBfs(int V) {
        Deque<Integer> queue = new ArrayDeque<>();
        visited[V] = true;  // 시작 값 방문처리하기
        queue.offer(V); // 시작하는 값을 큐에 넣기

        while (!queue.isEmpty()) {
            int e = queue.poll(); // 큐에서 하나의 원소를 뽑아 출력
            System.out.print(e + " "); // 순서를 위해 출력

            for (Integer n : graph.get(e)) {
                if (!visited[n]) {
                    queue.offer(n);
                    visited[n] = true;
                }
            }
        }
    }

    private static void getDfs(int V) {
        if (!visited[V]) {
            visited[V] = true;
        }
        System.out.print(V + " ");
        for (Integer n : graph.get(V)) {
            if(!visited[n]) getDfs(n);
        }
    }
}