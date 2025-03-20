package src.thisisCodingTest.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ10451 {
    public static boolean visited[];
    public static ArrayList<Integer> graph = new ArrayList<Integer>();
    public static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph.add(Integer.valueOf(st.nextToken()));
            }

            visited = new boolean[N + 1];
            for (int k = 0; k < N; k++) {
                if (!visited[k+1]) {
                    visited[k+1] = true;
                    int n = graph.get(k);
//                    System.out.println(n);
                    getBfs(n);
                }
            }
//            System.out.println(graph);
            System.out.println(cnt);
            cnt = 0;
            graph = new ArrayList<Integer>();
        }


    }

    private static void getBfs(int n) {
        if (!visited[n]) {
            visited[n] = true;
            n = graph.get(n-1);
            getBfs(n);
        } else {
            cnt++;
        }
    }
}
