package thisisCodingTest.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 위치 정보를 넣을 노드 생성하기
class NodeEscape {
    private int x;
    private int y;

    public NodeEscape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}

public class EscapeMaze {
    public static int n, m;
    // 방문 여부를 담기 위한 그래프 만들기
    public static int[][] graph = new int[201][201];

    // 이동할 네 가지 방향 정의 (상, 하, 좌, 우)
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};

    // bfs 함수 정의하기
    private static int bfs(int x, int y) {
        // 큐(Queue) 구현을 위해 queue 라이브러리 사용
        Queue<NodeEscape> q = new LinkedList<>();
        q.offer(new NodeEscape(x, y));

        while(!q.isEmpty()) { // 큐가 빌 때까지 반복하기
            NodeEscape node = q.poll();
            x = node.getX();
            y = node.getY();
            // 현재 위치에서 4가지 방향으로의 위치 확인
            for (int i = 0; i < 4; i++) {
                // 다음이동 할 위치를 nx와 ny로 만들기
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 미로 찾기 공간을 벗어난 경우 무시
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                // 괴물이 있는 부분인 경우 무시
                if (graph[nx][ny] == 0) continue;

                // 해당 노드를 처음 방문하는 경우에만 최단 거리 기록
                if (graph[nx][ny] == 1) {
                    graph[nx][ny] = graph[x][y] + 1; // 최단 거리를 기록하기 위해 기존의 값에다가 1만큼 더해준 값을 처음 방문하는 노드에 넣어주기
                    q.offer(new NodeEscape(nx, ny)); // 큐에 추가하기
                }
            }
        }
        // 가장 오른쪽 아래까지의 최단 거리 반환
        return graph[n - 1][m - 1];
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N, M을 공백을 기준으로 구분하여 입력 받기
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine(); // 버퍼 지우기

        // 2차원 리스트의 맵 정보 입력 받기
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        // BFS를 수행한 결과 출력
        System.out.println(bfs(0, 0));
    }
}
