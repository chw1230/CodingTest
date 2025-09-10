import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
        int T = Integer.parseInt(br.readLine());

        int max = 0;
        int num[] = new int[T];
        for (int i = 0; i < T; i++) {
            num[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, num[i]);
        }

        int arr[][] = new int[41][2];
        for (int i = 0; i <= max; i++) {
            if (i == 0) {
                arr[0][0] = 1;
                arr[0][1] = 0;
            } else if (i == 1) {
                arr[1][1] = 1;
                arr[1][0] = 0;
            } else {
                arr[i][0] = arr[i-1][0] + arr[i-2][0];
                arr[i][1] = arr[i-1][1] + arr[i-2][1];
            }
        }

        for (int i = 0; i < T; i++) {
            System.out.println(arr[num[i]][0] + " " + arr[num[i]][1]);
        }
    }
}