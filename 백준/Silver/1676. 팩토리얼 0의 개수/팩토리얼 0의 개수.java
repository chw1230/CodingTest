import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(br.readLine());
        int cnt = 0;

        // 5가 key
        /* 짝수는 많이 존재함 그러니 5의 개수를 따라가면 0이 몇개 나오는지 알 수 있음
         * 틀린 이유 : 25에서 5가 2개 존재하는 것 고려하지 못함(5의 거듭제곱 꼴 고려 X)
         */
        // 그렇다면 5의 거듭제곱을 어떻게 처리해야할까? -> 반복문으로 처리 'i=5, i*=5' 5의 거듭제곱
        for (int i = 5; i <= n; i *= 5) { // i는 5, 25, 125, 625 이렇게 증가
            cnt += n / i;
        }
        System.out.println(cnt);
    }
}
