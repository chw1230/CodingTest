import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static int N, M;

    static int BFS(int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        int d[] = new int[N+1]; // 노드로 가는데 걸리는 길이

        q.offer(n);
        visited[n] = true;
        
        while (!q.isEmpty()) {
            n = q.poll();
            for (int num : graph[n]) {
                if (!visited[num]) {
                    visited[num] = true;
                    q.offer(num);
                    d[num] = d[n] + 1; // n과 연결된 num 노드에 길이 + 1 해주기
                }
            }
        }

        int distance = 0;
        for (int i : d) {
            distance += i;
        }
        return distance;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // user 수
        M = Integer.parseInt(st.nextToken()); // 관계 수

        graph = new ArrayList[N + 1]; // 인접 리스트 생성하기
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i  < M ; i++) {
            st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b); 
                graph[b].add(a);
        }

        int min = Integer.MAX_VALUE;
        int idx = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            int value = BFS(i);
            if (value < min) {
                min = value; // 최소값 최신화
                idx = i;  // 앞에서 부터 순서 대로 하기 때문에 -> 케빈 베이컨의 수가 가장 작은 사람을 출력한다. 그런 사람이 여러 명일 경우에는 번호가 가장 작은 사람을 출력 => 조건 성립
            }
        }
        System.out.println(idx);
    }
}