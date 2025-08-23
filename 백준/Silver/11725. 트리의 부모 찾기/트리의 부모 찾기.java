import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static boolean[] visited;
    private static int[] answer;

    private static void DFS(int n) {
        visited[n] = true;

        for (int i : graph.get(n)) {
            // 이미 방문 했다면 부모 노드이니까
            if (!visited[i]) { // 방문 안했다면
                answer[i] = n; // n을 타고 통해 들어왔으니 idx(i)에 부모노드 n 저장하기
                DFS(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        /*
        graph.get(a).add(b) => 노드 a와 연결된 노드 b를 추가한다는 뜻!
         */

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited = new boolean[N+1];
        answer = new int[N+1];
        DFS(1);

        for (int i = 2; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}