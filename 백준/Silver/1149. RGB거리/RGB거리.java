import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 집의 수
        int arr[][] = new int[N][3]; // 집의 수, 3색 / 열을 지나며 행 별로 가장 작은 값만들 더해서 넣기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            if (i == 0) {
                arr[0][0] = Integer.parseInt(st.nextToken());
                arr[0][1] = Integer.parseInt(st.nextToken());
                arr[0][2] = Integer.parseInt(st.nextToken());
            }else {
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
                arr[i][2] = Integer.parseInt(st.nextToken());
                int min = Math.min(arr[i-1][0], Math.min(arr[i-1][1], arr[i-1][2]));
                for (int j = 0; j < 3; j++) {
                    if (arr[i - 1][j] == min) { // 전 값(앞에 있는 열)에서 최소값을 가진 idx랑 동일하면
                        int save = Integer.MAX_VALUE;
                        for (int k = 0; k < 3; k++) {
                            if (k != j) {
                                save = Math.min(arr[i-1][k], save); // 그 다음 작은 값 구해서
                            }
                        }
                        arr[i][j] += save; // 더하기
                    } else {
                        arr[i][j] += min;
                    }
                }
            }
        }
        System.out.println(Math.min(arr[N-1][0], Math.min(arr[N-1][1], arr[N-1][2])));
    }
}