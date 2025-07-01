import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            Long arr[] = new Long[N+1];
            if (N <= 3) {
                for (int j = 1; j <= N; j++) {
                    arr[j] = 1L;
                }
            } else if (N <= 5) {
                for (int j = 1; j <= 3; j++) {
                    arr[j] = 1L;
                }
                for (int j = 4; j <= N; j++) {
                    arr[j] = 2L;
                }
            } else {
                for (int j = 1; j <= 3; j++) {
                    arr[j] = 1L;
                }
                for (int j = 4; j <= N; j++) {
                    arr[j] = 2L;
                }
                for (int j = 6; j <= N; j++) {
                    arr[j] = arr[j - 1] + arr[j - 5];
                }
            }
            System.out.println(arr[N]);
        }
    }
}