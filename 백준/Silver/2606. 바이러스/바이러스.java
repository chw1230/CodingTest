import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int[] visited = new int[101]; // 방문을 담을 노드
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    public static void dfs(int u) {
        visited[u] = 1; // 1. 방문처리
        for (int v : graph.get(u)) { // 2. 연결되어 있는 것 찾기
            if (visited[v] == 0) { // 3. 연결되면 넘어가고, 안되어 있으면 재귀적으로 불러서 해당 노드로 넘어가기
                dfs(v);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nodes = java.lang.Integer.parseInt(br.readLine()); // 노드 수
        int edges = java.lang.Integer.parseInt(br.readLine()); // 엣지 수

        for (int i = 0; i <= nodes; i++) {
            graph.add(new ArrayList<>()); //  그래프 초기화
        }

        for (int i = 0; i < edges; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = java.lang.Integer.parseInt(st.nextToken());
            int b = java.lang.Integer.parseInt(st.nextToken());
            // 연결
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dfs(1);

        int cnt = 0;
        for (int i = 2; i <= nodes; i++) { // 1번을 제외하고 1번으로 인해 바이러스에 걸린 것 개수 카운트
            if (visited[i] == 1) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
