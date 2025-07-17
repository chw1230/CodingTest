import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int num[] = new int[n];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            num[i] = a;
            if (a > max){
                max = a;
            }
        }

        int[] arr = new int[max+1];
        arr[1] = 1; // 1
        arr[2] = 2; // 1+1 , 2
        arr[3] = 4; // 1+1+1, 1+2, 2+1, 3

        for (int j = 4; j <= max; j++) {
            arr[j] = arr[j - 1] + arr[j - 2] + arr[j - 3];
        }

        for (int i : num) {
            System.out.println(arr[i]);
        }
    }
}