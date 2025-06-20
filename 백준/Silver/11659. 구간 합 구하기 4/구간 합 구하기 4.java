import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        // 처음에 2차원 배열 구상 -> 시간 복잡 + 메모리 문제 발생! => 구간합 특징에 맞지 않음!!!
        // 1차원 배열로만 해결하자!
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int arr[] = new int[N+1];

        st = new StringTokenizer(br.readLine());
        // 누적해서 합이 더해진 배열 생성
        for (int i = 0; i < N; i++) {
            arr[i+1] = Integer.parseInt(st.nextToken()) + arr[i];
        }

        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            System.out.println(arr[j] - arr[i-1]);
        }
    }
}
