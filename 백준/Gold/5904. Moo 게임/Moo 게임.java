import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static long[] len = new long[60];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        len[0] = 3;
        int k = 0;

        while (len[k] < N) {
            k++;
            len[k] = len[k - 1] * 2 + k + 3;
        }
        moo(k, N);
    }

    private static void moo(int k, long N) {
        if (k == 0) {
            if (N == 1) {
                System.out.println("m");
            } else {
                System.out.println("o");
            }
            return;
        }

        long left = len[k - 1]; //
        long mid = k + 3; // 중간의 m o o ..

        if (N <= left) { // 가장 왼쪽 일때
            moo(k - 1, N);
        } else if (N <= mid + left) { // moo..o 가 한 덩어리 밖에 없으니까 출력문 작성
            if (N == left + 1) {
                System.out.println("m");
            } else {
                System.out.println("o");
            }
        } else { // 가장 오른쪽 일때
            moo(k - 1, (int) (N - mid - left)); // left/mid/여기 해당되니까
            // (int) (N - mid - left) 이렇게 줄여서 넘기기!
        }
    }
}