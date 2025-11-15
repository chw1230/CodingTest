import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    private static int[] dir;
    private static Deque<Integer>[] dq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dq = new ArrayDeque[4];
        for (int i = 0; i < 4; i++) {
            dq[i] = new ArrayDeque<>();
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                dq[i].addLast((int) str.charAt(j) - 48); // 숫자 넣기 / dp[n] => 하나의 톱니바퀴를 쭉 핀 모습
            }
        }

        int K = Integer.parseInt(br.readLine()); // 회전 횟수

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int di = Integer.parseInt(st.nextToken());

            // 돌릴 수 있는지 판단하고 '한번에' 돌리는 것이 핵심
            dir = new int[4];
            dir[num] = di;

            // 좌측에 바꿀 것이 있는지 확인
            for (int j = num; j >= 1; j--) {
                if (canRotate(j - 1, j)) {
                    dir[j - 1] = -dir[j]; // 시계면 반시계로 좌측 di를 설정하고, 반시계면 시계로 좌측 di를 설정
                }
            }

            // 우측에 바꿀 것이 있는지 확인
            for (int j = num; j < 3; j++) {
                if (canRotate(j, j + 1)) {
                    dir[j + 1] = -dir[j]; // 우측도 마찬 가지로!
                }
            }

            rotate();
        }

        int sum = 0;
        int v = 1;
        for (int i = 0; i < 4; i++) {
            Integer n = dq[i].removeFirst();
            sum += n * v;
            v *= 2;
        }
        System.out.println(sum);
    }

    private static void rotate() {
        for (int i = 0; i < dir.length; i++) {
            if (dir[i] == 1) {
                Integer n = dq[i].removeLast();
                dq[i].addFirst(n);
            } else if (dir[i] == -1) {
                Integer n = dq[i].removeFirst();
                dq[i].addLast(n);
            }
        }
    }

    static boolean canRotate(int l, int r) { // 넘어 오는게 톱니바퀴 번호
        Integer[] L = dq[l].toArray(new Integer[0]);
        Integer[] R = dq[r].toArray(new Integer[0]);

        return L[2] != R[6];
    }
}