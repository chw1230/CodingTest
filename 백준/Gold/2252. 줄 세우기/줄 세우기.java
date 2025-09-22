import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // dag
    private static int[] visited;
    private static int N;
    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        visited = new int[N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i] == 0) {
                DFS(i);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private static void DFS(int i) {
        if (visited[i] == 1) {
            return;
        }
        if (visited[i] == 2) {
            return;
        }

        visited[i] = 1; // 방문 중 처리
        for (Integer vertex : graph.get(i)) {
            DFS(vertex);
        }
        stack.push(i);
        visited[i] = 2;
    }
}