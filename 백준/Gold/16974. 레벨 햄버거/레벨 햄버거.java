import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static long[] hamburger; // 레벨 별 햄버거의 길이
    public static long[] P; // 레벨 별 패티의 개수만을 담을 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long X = Long.parseLong(st.nextToken());

        hamburger = new long[(int) (N + 1)];
        P = new long[(int) (N + 1)];
        hamburger[0] = 1;
        P[0] = 1;
        for (int i = 1; i <= N; i++) {
            hamburger[i] = hamburger[i - 1] * 2 + 3;
            P[i] = P[i - 1] * 2 + 1;
        }

        System.out.println(solve(N, X));
    }

    private static long solve(long n, long x) {
        if (n == 0) { // 0 레벨의 버거는 패티가 한개라서 1
            return 1;
        }
        if (x == 0) { // 아무것도 먹은 게 없으면 0
            return 0;
        }

        long preHamburger = hamburger[(int) (n - 1)];
        long preP = P[(int) (n - 1)];

        if (x == 1) { // 길이가 1인 위치를 먹는다 -> 그냥 번만 먹는 거 => 0 반환
            return 0;
        } else if (x <= 1 + preHamburger) { // 1 + preHamburger  의미  => 바닥에 번이 깔린 이전 레벨 햄버거
            return solve(n - 1, x - 1); // 레벨을 낮추고 x에는 번이 들어간 개수이니까 번의수 1개 빼주기
        } else if (x == 1 + preHamburger + 1) { // x가 정중앙( 이전 햄버거 길이 + 바닥에 번 + 중앙에 새로 깔리는 패티 ) 일때
            return preP + 1; // 이전 패티 + 중아에 새로 깔린 패티 한개
        } else if (x <= 1 + preHamburger + 1 + preHamburger) { // 번 + 이전 단계 햄버거 + 중간 패티 + 이전 단계 햄버거 보가 작거나 같으면
            return preP + 1 + solve(n - 1, x - 1 - preHamburger - 1); // 레벨을 하나 낮추고, x에서 패티수 하나 빼고, 번 하나 배고 이전 햄버거 빼기
        } else {
            return P[(int) n];
        }
    }
}