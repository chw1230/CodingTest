import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int arr[] = new int[N+1]; // 소수만 들어 갈 수 있는 배열 ( 소수 아니면 0 처리하기 )

        for (int i = 2; i <= N; i++) { // 배열 초기화
            arr[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(N); i++) {
            // 2를 제외한 2의 배수 , 3을 제외한 3의 배수를 지우기 위해서 Math.sqrt(N) 까지 반복문이 돌아가도록 하기
            if (arr[i] == 0) {
                continue;
            }

            for (int j = 2*i; j <= N; j += i) { // 소수의 2배 부터 배열의 길이 까지 배수씩 늘려주면서
                arr[j] = 0; // 소수에서 없애주기
            }
        }

        for (int i = M; i <= N; i++) {
            if (arr[i] != 0) {
                System.out.println(arr[i]);
            }
        }
    }
}