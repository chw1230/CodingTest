import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long r = 1;
            for (int j = 0; j < b; j++) {
                r = (r * a)%10; // 마지막 값 확인에 신경쓰면 되기 때문에! 문제 풀이의 포인트
            }
            if (r == 0) {
                r = 10;
            }
            System.out.println(r);
        }
    }
}