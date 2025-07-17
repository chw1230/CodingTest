import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n + 1];
        arr[1] = 1;
         if ( n == 1 ) { // 기본으로 정해준 값이 나온 경우 먼저 출력해주기!! -> 오답 이유
            System.out.println(1);
            return;
        }
        arr[2] = 2;

        for (int i = 3; i <= n; i++) {
            arr[i] = (arr[i-1] + arr[i-2]) % 10007;
        }
        System.out.println(arr[n]);
    }
}