import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 문제를 계속 틀린 이유
    /*
    1. 이진 탐색에서 시작점을 0으로 줌 이렇게 하면 BS(1,0,...) 이라면 mid 가 1이 되는일 발생!
    2. 타입 long 미사용
     */
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long K = Integer.parseInt(st.nextToken()); // 가지고 있는 랜선의 개수
        long N = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수

        arr = new long[(int) K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        BS(1, arr[arr.length - 1], arr, N);
    }

    private static void BS(long start, long end, long[] arr, long n) {
        while (start <= end) {
            long cnt = 0;
            long mid = (start + end + 1) / 2;
            for (long i : arr) {
                cnt += i / mid;
            }

            if (cnt >= n) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(end);
    }
}
