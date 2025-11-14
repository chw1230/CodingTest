package 삼성;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 조삼모사 {
    private static int n;
    private static int[][] arr;
    private static boolean[] picked;

    private static int r = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        picked = new boolean[n];
        dfs(0, 0);
        System.out.println(r);
    }

    // 고려중인 사람의 번호, 아침 조에 포함된 인원
    private static void dfs(int idx, int cnt) {
        // 아침 인원이 정확하게 절반이 되면 값차이 게산
        if (cnt == n / 2) {
            r = Math.min(r, calc()); // 계산
            return;
        }

        // 더 할게 없으면
        if (idx == n) {
            return;
        }

        picked[idx] = true; // 아침 조에 넣기
        dfs(idx + 1, cnt + 1);

        picked[idx] = false; // 저녁 조에 넣기
        dfs(idx + 1, cnt);
    }

    private static int calc() {
        int sumMorning = 0;
        int sumEvening = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                
                if (picked[i] && picked[j]) { // 둘다 아침 조인 경우에
                    sumMorning += arr[i][j];
                }

                if (!picked[i] && !picked[j]) { // 둥다 저녁 조인 경우
                    sumEvening += arr[i][j];
                }
            }
        }

        return Math.abs(sumMorning - sumEvening);
    }
}
