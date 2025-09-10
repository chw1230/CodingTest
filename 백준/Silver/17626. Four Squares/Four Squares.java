import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    // 그리디 방식으로 시도 => 성공하지 못하는 부분 존재해서 오답!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n+1]; // index 숫자를 구하는데 필요한 제곱수의 합을 의미!

        arr[0] = 0;

        for (int i = 1; i < arr.length; i++) {
            arr[i]= i;
            for (int j = 1; j*j <= i; j++) {
                arr[i] = Math.min(arr[i], arr[i - j * j] + 1); // 모두 1로만 채운 것과 j*j 제곱수를 사용한 것에 + 1 더한 것 중 최소값을 구하기
            }
        }
        System.out.println(arr[n]);
    }
}