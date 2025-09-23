import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static int[] visited;
    private static Stack<Integer> s = new Stack<>();
    private static boolean cycle = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // PD가 가져온 a 명의 가수 인원
            int start = Integer.parseInt(st.nextToken());
            for (int j = 1; j < a; j++) {
                int end = Integer.parseInt(st.nextToken());
                graph.get(start).add(end);
                start = end;
            }
        }

        visited = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (visited[i] == 0) { // 사이클 처리하가
                DFS(i);
            }
            if (cycle) {
                System.out.println(0);
                return;
            }
        }

        while (!s.isEmpty()) {
            System.out.println(s.pop() + " ");
        }
    }

    private static void DFS(int i) {
        if (visited[i] == 1) {
            cycle = true;
            return;
        }

        if (visited[i] == 2) {
            return;
        }

        visited[i] = 1; // 방문 중 체크
        for (Integer v : graph.get(i)) {
            DFS(v);
        }
        s.push(i);
        visited[i] = 2; // 방문 종료
    }
}