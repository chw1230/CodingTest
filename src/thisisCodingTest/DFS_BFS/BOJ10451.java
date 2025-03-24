package thisisCodingTest.DFS_BFS;

/*
* DFS를 사용한 이유는? -> 순열 사이클 개수 찾기 -> 연결된 하나의 순열에서 자신으로 돌아오는 사이클의 개수를 찾는 것!
* 연결된 하나의 순열? -> 하나의 순열을 쭉 탐색하는 DFS를 이용하자 라고 생각했음!
 */

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

        int T = Integer.parseInt(st.nextToken()); // 테스트 케이스의 개수

        for (int i = 0; i < T; i++) { // 테스트 케이스 만큼 반복
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 순열의 크기

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) { // 순열의 크키 만큼 반복하여 그래프에 데이터 넣기!
                graph.add(Integer.valueOf(st.nextToken()));
            }

            visited = new boolean[N + 1]; // 방문 처리를 위한 배열 생성
            for (int k = 0; k < N; k++) { // 1부터 N까지 커지며 그래프와 연결
                if (!visited[k+1]) {
                    visited[k+1] = true;
                    int n = graph.get(k);
//                    System.out.println(n);
                    getBfs(n);
                }
            }
//            System.out.println(graph);
            System.out.println(cnt);
            cnt = 0;  // cnt 초기화
            graph = new ArrayList<>();  // 기존에 입력된 그래프 버리고 새롭게 데이터 넣기 위해서!
        }


    }

    private static void getBfs(int n) {
        if (!visited[n]) {  // DFS 재귀적으로 호출하며 끝까지 쭉!
            visited[n] = true;
            n = graph.get(n-1);
            getBfs(n);
        } else { // 방문 처리가 true인 경우에 cnt++ -> 순열 사이클을 찾기 위해서!!
            cnt++;
        }
    }
}
