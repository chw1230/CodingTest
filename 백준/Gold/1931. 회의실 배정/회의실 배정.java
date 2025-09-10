import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 회의의 수

        int arr[][] = new int[N][2]; // 시작시간, 종료시간
        // 우선 입력 데이터를 정렬하기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i][0] = a;
            arr[i][1] = b;
        }
        Arrays.sort(arr, (a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[0], b[0]); // 끝나는 시간 같으면 시작 시간이 작은 것부터
            }
            return Integer.compare(a[1], b[1]); // 끝나는 시간 오름차순
        });

        int cnt = 0; // 회의의 개수
        int start = 0;
        int end = 0; 
        for (int i = 0; i < arr.length; i++) {
            if ( end <= arr[i][0] ) { // 선택할 회의 시간의 시작 시간이 이전 회의의 종료 시간보다 큰 경우
                start = arr[i][0];
                end = arr[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}