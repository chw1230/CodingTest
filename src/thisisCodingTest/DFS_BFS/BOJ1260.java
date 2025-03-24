package thisisCodingTest.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
* 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고 -> Integer를 담는 Treeset을 이용하여 해결함!
*
*
* 어려 웠던점 graph.get(a).add(b); -> 이와 같은 방법을 사용하니 한방향으로 연결되는 현상이 일어났음
* 그래서 a와 b를 바꾸는 과정을 통해서  graph.get(a).add(b); -> 이 코드도 사용하면서 양쪽 다 연결해주고자 하였음
*  => 정리하면 한방향으로만 접근 가능 한 것을 양방향에서 접근 가능하도록하였다!
 */
public class BOJ1260 {
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

            // 양방향 접근하기!
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
        Deque<Integer> queue = new ArrayDeque<>(); // BFS를 구하는데 필요한 큐를 생성하기
        visited[V] = true;  // 시작 값 방문처리하기
        queue.offer(V); // 시작하는 값을 큐에 넣기

        while (!queue.isEmpty()) {
            int e = queue.poll(); // 큐에서 하나의 원소를 뽑아 출력
            System.out.print(e + " "); // 순서를 위해 출력

            for (Integer n : graph.get(e)) {
                if (!visited[n]) {  // 방문 하지 않은 경우에만 큐에 넣고, 방문처리하기
                    queue.offer(n);
                    visited[n] = true;
                }
            }
        }
    }

    private static void getDfs(int V) {
        if (!visited[V]) {  // 들어온 수 방문 확인 후 방문 처리하기
            visited[V] = true;
        }
        System.out.print(V + " ");
        for (Integer n : graph.get(V)) { // 재귀적으로 Dfs 호출하기!
            if(!visited[n]) getDfs(n);
        }
    }
}
