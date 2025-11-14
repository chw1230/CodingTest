import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static boolean[] pick;
    private static int[][] arr;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        pick = new boolean[n];
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(min);
    }

    private static void dfs(int idx, int cnt) {
        if (cnt == n / 2) {
            int value = calc();
            min = Math.min(min, value);
            return;
        }

        if (idx == n) {
            return;
        }

        pick[idx] = true;
        dfs(idx + 1, cnt + 1);

        pick[idx] = false;
        dfs(idx + 1, cnt);
    }

    private static int calc() {
        int sumMorning = 0;
        int sumEvening = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (pick[i] && pick[j]) {
                    sumMorning += arr[i][j];
                }
                if (!pick[i] && !pick[j]) {
                    sumEvening += arr[i][j];
                }
            }
        }
        return Math.abs(sumMorning - sumEvening);
    }
}