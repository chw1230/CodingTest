import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.util.Collections.sort;

public class Main {
    private static int V;
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static ArrayList<ArrayList<Integer>> graphR = new ArrayList<>();
    private static int ccFlag;
    private static int[] ccArr;
    private static int[] pre;
    private static int[] post;
    private static int[] visited;
    private static int clock;
    private static ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken()); // 정점의 개수
        int E = Integer.parseInt(st.nextToken()); // 간선의 개수

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
            graphR.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graphR.get(b).add(a);
        }

        for (int i = 1; i <= V; i++) {
            sort(graph.get(i));
            sort(graphR.get(i));
        }

        visited = new int[V + 1];
        ccArr = new int[V + 1];
        pre = new int[V + 1];
        post = new int[V + 1];

        clock = 1;
        // 리버스 그래프 DFS 실행하기
        for (int i = 1; i <= V; i++) {
            if (visited[i] == 0) {
                dfs_R(i);
            }
        }

        // 새로운 DFS를 위한 방문 초기화!
        visited = new int[V + 1];
        ccFlag = 1;

        for (int i = 0; i <= V; i++) {
            res.add(new ArrayList<>());
        }

        // post 최대값 기반의 DFS 실행!
        for (int i = 1; i <= V; i++) {
            int maxPost = maxPost();
            if (maxPost == -1) {
                break;
            }
            dfs(maxPost);
            ccFlag++;
        }

        System.out.println(--ccFlag);
        for (int i = 1; i <= ccFlag; i++) {
            sort(res.get(i));
        }

        // 문제 조건에 맞게 정렬하기!!
        ArrayList<ArrayList<Integer>> sorted = new ArrayList<>();
        for (int i = 1; i <= ccFlag; i++) {
            if (!res.get(i).isEmpty()) sorted.add(res.get(i));
        }
        sorted.sort((a, b) -> Integer.compare(a.get(0), b.get(0)));

        for (ArrayList<Integer> s : sorted) {
            for (int v : s) {
                System.out.print(v + " ");
            }
            System.out.println(-1);
        }
    }

    private static void dfs(int i) {
        visited[i] = 1;
        ccArr[i] = ccFlag;
        res.get(ccFlag).add(i);

        for (Integer v : graph.get(i)) {
            if (visited[v] == 0) {
                dfs(v);
            }
        }
    }

    private static int maxPost() {
        int max = -1;
        int idx = -1; // 가장 큰 post 값을 가진 노드의 idx
        for (int i = 1; i <= V; i++) {
            if (visited[i] == 0 && post[i] > max) {
                max = post[i];
                idx = i;
            }
        }
        // 만약 전 부다 방문 했다면 -1을 반환할 것!
        return idx;
    }

    private static void dfs_R(int i) {
        visited[i] = 1;
        pre[i] = clock++;

        for (Integer v : graphR.get(i)) {
            if (visited[v] == 0) {
                dfs_R(v);
            }
        }
        post[i] = clock++;
    }
}