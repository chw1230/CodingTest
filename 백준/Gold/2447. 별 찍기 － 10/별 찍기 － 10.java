import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = ' ';
            }

        }
        s(0, 0, N, false);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append('\n');
        }
        System.out.print(sb);
    }

    private static void s(int i, int j, int N, boolean flag) {
        if (flag) {
            return;
        }

        if (N == 1) {
            arr[i][j] = '*';
            return;
        }

        int s = N / 3;
        int cnt = 0;
        for (int k = i; k < i + N; k += s) {
            for (int l = j; l < j + N; l += s) {
                cnt++;
                if (cnt != 5) { // 공백 출력
                    s(k, l, s, false);
                } else {
                    s(k, l, s, true);
                }
            }
        }

    }
}