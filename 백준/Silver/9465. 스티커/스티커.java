import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[][] score = new int[2][n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                score[0][i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                score[1][i] = Integer.parseInt(st.nextToken());
            }
            if (n == 1) {
                String max = String.valueOf(Math.max(score[0][0], score[1][0]));
                bw.append(max).append('\n');
                continue;

            }

            int[][] arr = new int[2][n];
            arr[0][0] = score[0][0];
            arr[1][0] = score[1][0];

            arr[0][1] = score[0][1] + arr[1][0];
            arr[1][1] = score[1][1] + arr[0][0];

            for (int i = 2; i < n; i++) {
                arr[0][i] = score[0][i] + Math.max(arr[1][i - 1], arr[1][i - 2]);
                arr[1][i] = score[1][i] + Math.max(arr[0][i - 1], arr[0][i - 2]);
            }
            String max = String.valueOf(Math.max(arr[0][n - 1], arr[1][n - 1]));
            bw.append(max).append('\n');
        }
        bw.flush();
        bw.close();
    }
}