package thisisCodingTest.ShortestPath;

import java.util.Arrays;
import java.util.Scanner;

public class FloydWarshall {
    private static int n, m;
    private static int[][] graph = new int[501][501];
    // 모든 노드쌍에 대한 최단 거리 정보가 담긴 테이블(2차원 배열)
    // 인접 행렬 역할과 얼마큼의 가중치(비용)이 드는지 이 2가지 정보가 담긴 2차원 배열임!

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        // graph 초기화
        for (int i = 0; i < 501; i++) {
            Arrays.fill(graph[i], (int) 1e9);
        }

        // 루프는 0으로 처리하기
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                }
            }
        }

        // 각 간선에 대한 정보를 입력받아 기초적인 연결 관계로 초기화 진행
        for (int i = 0; i < m; i++) {
            // a와 b는 c라는 비용으로 연결됨
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph[a][b] = c;
        }

        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    // <a에서 b로 가는 비용>과 <a에서 k를 거처서 b로 가는 비용> 중 더 작은 비용을 저장하기!
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                if (graph[a][b] == (int) 1e9) {
                    System.out.print("INFINITY ");
                }
                else {
                    System.out.print(graph[a][b] + " ");
                }
            }
            System.out.println();
        }
    }
}
/*
4
7
1 2 4
1 4 6
2 1 3
2 3 7
3 1 5
3 4 4
4 3 2
------
0 4 8 6
3 0 7 9
5 9 0 4
7 11 2 0

-> graph 설명 
루프는 0 자기 자신으로 가는 비용은 0

0 4 8 6 (1행 보기)
-> 노드 1에서 노드 2로 가능 비용 4, 노드 1에서 노드 8로 가는 비용 8
=> 자 그러면 이게 한번에 가도록 연결되어 있나? -> 아니다

그래서 큰 값으로 초기화 한 뒤에 처음에 입력값에 대해서 기초 연결된 부분으로 초기화를 한번 더 진행
이후에 3 중첩 배열로 k(중간),a(시작),b(끝) 순서로 <a에서 b로 가는 비용>과 <a에서 k가는 비용 + k에서 b로 가는 비용> 중 작은 값을 저장하기!
 */
