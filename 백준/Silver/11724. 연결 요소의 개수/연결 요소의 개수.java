import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static public int[] visited = new int[1001];
    static public ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int visit = 1;

    public static void dfs(int u) {
        visited[u] = visit; // 방문 처리
        for (int v : graph.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodes = Integer.parseInt(st.nextToken());
        int edges = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= nodes; i++) {
            graph.add(new ArrayList<>()); // 그래프 초기화 과정
        }

        for (int i = 0; i < edges; i++) { // 그래프에 내용 추가
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 1; i <= nodes; i++) {
            if (visited[i] == 0) { // 첫 방문 일때만 노드 따라서 dfs하기
                dfs(i); // dfs 후에는
                visit++; // 이전과 다른 방문 표시하기 -> 연결 요소 개수 구분하기 위해서
            }
        }
        System.out.println(--visit);
    }
}