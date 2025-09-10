package thisisCodingTest.ShortestPath;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
[문제]
미래 도시에는 1번부터 N번까지의 회사가 있는데 특정 회사끼리는 서로 도로를 통해 연결되어 있다.

방문 판매원 A는 현재 1번 회사에 위치해 있으며, X번 회사에 방문해 물건을 판매하고자 한다.

미래 도시에서 특정 회사에 도착하기 위한 방법은 회사끼리 연결되어 있는 도로를 이용하는 방법이 유일하다.

또한 연결된 2개의 회사는 양방향으로 이동할 수 있다. 공중 미래 도시에서 특정 회사와 다른 회사가 도로로 연결되어

있다면, 정확히 1만큼의 시간으로 이동할 수 있다.

또한 오늘 방문 판매원 A는 기대하던 소개팅에도 참석하고자 한다. 소개팅의 상대는 K번 회사에 존재한다.

방문 판매원 A는 X번 회사에 가서 물건을 판매하기 전에 먼저 소개팅 상대의 회사에 찾아가서 함께 커피를 마실 예정이다.

따라서 방문 판매원 A는 1번 회사에서 출발하여 K번 회사를 방문한 뒤에 X번 회사로 가는 것이 목표다.

이때 방문 판매원 A는 가능한 한 빠르게 이동하고자 한다.

방문 판매원이 회사 사이를 이동하게 되는 최소 시간을 계산하는 프로그램을 작성하시오.

[입력 조건]
첫째 줄에 전체 회사의 개수 N과 경로의 개수 M이 공백으로 구분되어 차례대로 주어진다. (1 <= N, M <= 100)

둘째 줄부터 M + 1번째 줄에는 연결된 두 회사의 번호가 공백으로 구분되어 주어진다.

M + 2번째 줄에는 X와 K가 공백으로 구분되어 차례대로 주어진다. (1 <= K <= 100)

[출력 조건]
첫째 줄에 방문 판매원 A가 K번 회사를 거쳐 X번 회사로 가는 최소 이동 시간을 출력한다.
만약 X번 회사에 도달할 수 없다면 -1을 출력한다.
<입력 예시 1>
5 7
1 2
1 3
1 4
2 4
3 4
3 5
4 5
4 5

<출력 예시 1>
3

<입력 예시 2>
4 2
1 3
2 4
3 4

<출력 예시 2>
-1
 */
public class FutureCity {
    private static int[][] graph = new int[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 전체 회사 개수 N
        int M = Integer.parseInt(st.nextToken()); // 경로의 개수 M

        for (int i = 0; i <= N; i++) {
            Arrays.fill(graph[i], (int) 1e9);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 양뱡향 연결
            graph[a][b] = 1;
            graph[b][a] = 1;

//            // 루프는 0 처리
//            graph[a][a] = 0;
//            graph[b][b] = 0;
        }

        // 루프 0 처리 -> 위에 반복문에서 한번에 처리 하려고 했지만, 최악의 경우 루프가 0이 안되고 고립되는 일 발생하니 그냥 따로 처리!
        for (int i = 1; i <= N; i++) {
            graph[i][i] = 0;
        }

        st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken()); // 최종 목적지
        int K = Integer.parseInt(st.nextToken()); // 중간점

        for (int i = 1; i <= N; i++) {
            for (int a = 1; a <= N; a++) {
                for (int b = 1; b <= N; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[i][b] + graph[a][i]);
                }
            }
        }

//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                System.out.print(graph[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println(graph[1][K]);
//        System.out.println(graph[K][X]);
        int dis = graph[1][K] + graph[K][X];
        if ( dis >= (int) 1e9){
            System.out.println(-1);
        } else {
            System.out.println(dis);
        }
    }
}
/*
5 7
1 2
1 3
1 4
2 4
3 4
3 5
4 5
4 5
----
3
 */
