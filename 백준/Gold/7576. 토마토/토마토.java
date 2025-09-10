import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /* 문제점 :
    정답은 맞았지만 시간 초과 -> 처음에 arr 값이 1인 토마토의 좌표를 받고 이것을 보두 저장했다가
    이 좌표를 통해서 모든 케이스를 BFS 돌려고 시도
    도는 과정에서 처음 온 경우 -> 그대로 이전 arr값 + 1 데이터 저장
    이미 방문 한 적이 있는데 현재 값이 arr 보다 작다면 작은 값의 데이터 저장 하는 방식 사용
    시간 초과 문제 발생
    => 처음에 좌표를 모두 큐에 넣고 BFS 사용하기!!!로 해결!!
    여러 시작점에서 동시에 퍼지는 상황을 BFS에서 해결할 방법을 떠올리지 못해서 발생한 문제
    떠올리지 못한 이유 : BFS에 대한 이해가 부족했던 것 같음
     */
    private static int M;
    private static int N;
    private static int[][] arr; // 입력 받는 배열 + 토마토가 익는 시간을 넣을 배열
    private static int moveX[] = {1, -1, 0, 0};
    private static int moveY[] = {0, 0, 1, -1};
    private static Queue<int[]> q = new LinkedList<>();

    private static void BFS() {
        while(!q.isEmpty()) {
            int[] curr = q.poll(); // 큐에서 빼기

            for(int k = 0; k < 4; k++) {
                int newY = curr[0] + moveY[k];
                int newX = curr[1] + moveX[k];
                if (0 <= newX && newX < M && 0 <= newY && newY < N) {
                    if (arr[newY][newX] == 0) {
                        arr[newY][newX] = arr[curr[0]][curr[1]] + 1;
                        q.add(new int[]{newY, newX});
                    }
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로
        boolean all = true;

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) { // 좌표 값 큐에 넣기 시작점을 넣고 BFS 돌리기
                    q.add(new int[] {i, j});
                } else if (arr[i][j] == 0) { // 안익은 토마토를 발견한 경우
                    all = false;
                }
            }
        }

        if (all) { // 전부 익은 토마토인 경우
            System.out.println(0);
            return;
        }

        BFS();

        int max = Integer.MIN_VALUE;
        for (int[] ints : arr) {
            for (int i : ints) {
                max = Math.max(max, i);
                if (i == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(max-1);
    }
}