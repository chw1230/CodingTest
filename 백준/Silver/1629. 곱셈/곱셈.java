import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int A;
    private static int B;
    private static int C;

    // int의 최대 값들의 곱을 고려하기
    private static long div(int a, int b, int c) {
        if ( b == 0 ){
            return 1 % c; // c가 1인 경우를 고려하기 위해서!!
        }
        // 홀수 : <반띵 + 반띵 + 1> 구조 or 짝수 : <반띵 + 반띵> 구조
        long save = div(a, b / 2, c); // 어차피 반띵 된 구조는 같으니 한번 계산해서
        long result = save * save % c; // 그 둘을 곱하기! / 반복문으로 2번 재귀하면 시간 오래 걸림!

        if (b % 2 == 1) { // 홀수라면 한번 더 곱해주기
            result = (result * (a % c)) % c;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(div(A % C, B, C));
    }
}