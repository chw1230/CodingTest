import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int arr[];
    private static int N,M, L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        arr = new int[N + 2];

        // 시작점과 끝점에서도 휴게소를 세울 수 있기에 시작점 끝점 미리 설정하기
        arr[0] = 0; // 시작점
        arr[N+1] = L; // 끝점

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        System.out.println(minimization());
    }

    private static int minimization() {
        int lo = 1; // 최소 간격
        int hi = L; // 가장 긴 간격
        while (lo < hi) {
            int mid = (lo + hi) / 2; // 이분 탐색으로!

            if (decision(mid)) { // mid 간격이라서 M개 이하의 휴게소인 경우라면
                hi = mid; 
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private static boolean decision(int cur) {
        int cnt = 0;
        for (int i = 1; i <= N + 1; i++) {
            int diff = arr[i] - arr[i - 1];
            cnt += (diff / cur);
            if ( diff % cur == 0 ) { // 배수 관계라면
                cnt--; // 개수를 하나 빼줘야함! 왜? -> 0부터 diff 까지 수가 쭉 놓여 있다고 생각을 해보자! 그러면 diff에는 이미 휴게소가 있는 것이니까! 마지막 가장 끝 diff 휴게소의 개수를 줄여주기!
            }
        }
        return cnt <= M; // M을 넘는 최소값중 가장 작은 값을 구하면 휴게소가 없는 구간의 최대값의 최소값을 구할 수 있는 것!
    }
}