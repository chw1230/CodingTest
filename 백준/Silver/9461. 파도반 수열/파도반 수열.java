import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 처음에 int 로 시도 -> 오답 => 타입의 문제인가? 그러네! long으로 변경!
    /* 코드 리펙토링! -> 입력을 받고 만들면 중복되는 부분이 많이 생기고 하드코딩하게 되어서 그냥 배열을 첨부터
    * 만들고 입력 받아서 해당 위치의 값을 출력하기
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        long[] arr = new long[101];
        arr[1] = arr[2] = arr[3] = 1;
        arr[4] = arr[5] = 2;

        for (int i = 6; i <= 100; i++) {
            arr[i] = arr[i - 1] + arr[i - 5];
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(arr[N]);
        }
    }
}