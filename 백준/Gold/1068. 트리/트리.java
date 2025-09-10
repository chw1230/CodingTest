import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static boolean[] visited;
    private static int remove;
    private static boolean[] leaf; // 리프 노드인지 아닌지 저장할 배열

    private static void DFS(int n) {
        int count = 0;
        visited[n] = true;
        for (Integer child : graph.get(n)) {
            if (!visited[child] && child != remove) { // 걍 삭제 노드를 타고 내려가지를 말자!
                DFS(child);
                count++; // DFS를 도는(삭제 노드가 아닌경우에만 돌기) 횟수를 이용해서
            }
        }
        if (count == 0) { // DFS를 도는 회수와 리프 노드의 성질을 통해서 리프 여부 확인하기
            leaf[n] = true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int root = 0;
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (n == -1) {
                root = i;
            } else {
                graph.get(n).add(i);
            }
        }

        remove = Integer.parseInt(br.readLine());
        if (remove == root) {
            System.out.println(0);
            return;
        }

        visited = new boolean[N];
        leaf = new boolean[N];
        DFS(root);

        int cnt = 0;
        for (boolean b : leaf) {
            if (b) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}