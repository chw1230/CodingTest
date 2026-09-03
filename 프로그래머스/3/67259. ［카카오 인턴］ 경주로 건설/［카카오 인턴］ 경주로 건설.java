import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class Solution {
    static int[] moveR = new int[]{0, 0, -1, 1};
    static int[] moveL = new int[]{-1, 1, 0, 0};

    public static int solution(int[][] board) {
        int n = board.length;
        int[][][] cost = new int[n][n][4]; // 같은 칸이라도 진입 방향에 따라 코너 비용이 달라지니까 상태를 방향에 따라서도 나누기
        // 최소 비용을 구하는 것을 감안
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
            }
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0, 0, -1)); // 시작점에서의 출발은 방향이 존재하기 않기에 -1로 설정해서 큐에 넣기

        int min = Integer.MAX_VALUE; // 최소 비용 값

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            // 목적지에 도달했다면 일단 값을 저장하고 패스! -> 다른 경로에서 최소 비용으로 접근 가능한 경우도 존재할 수 있기에!
            if (cur.r == n - 1 && cur.c == n - 1) {
                min = Math.min(min, cur.cost);
                continue;
            }

            for (int d = 0; d < 4; d++) {
                int nR = cur.r + moveR[d];
                int nC = cur.c + moveL[d];

                if (nR < 0 || nR >= n || nC < 0 || nC >= n || board[nR][nC] == 1) { // 벗어나기 + 벽
                    continue; // 통과
                }

                int nCost = cur.cost;
                if (cur.direction == -1 || cur.direction == d) {
                    nCost += 100;
                } else {
                    nCost += 600;
                }

                // 해당 방향으로 진입한 때의 cost와 다음 비용을 비교했을 때
                // 다음 비용(nCost)이 더 작거나 같아야 탐색을 진행
                if (nCost <= cost[nR][nC][d]) {
                    cost[nR][nC][d] = nCost; // 해당 방향으로 진입한 때의 cost 값으로 최신화
                    queue.add(new Node(nR, nC, nCost, d));
                }
            }
        }
        return min;
    }

    // record 사용해서 간략하게 이용하기
    record Node(int r, int c, int cost, int direction) {
    }
}