import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 도시의 개수
        int m = Integer.parseInt(br.readLine()); // 버스의 개수
        int arr[][] = new int[n + 1][n + 1];

        // 초기화
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(arr[i], (int) 1e9 );
        }
        for (int i = 0; i <= n; i++) {
            arr[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // start
            int b = Integer.parseInt(st.nextToken()); // end
            int c = Integer.parseInt(st.nextToken()); // cost

            arr[a][b] = Math.min(arr[a][b], c); // 시작 도시와 도착 도시를 연결하는 노선 -> 여러개 일 수 있음!
        }

        for (int mid = 1; mid <= n ; mid++) {
            for (int s = 1; s <= n; s++) {
                for (int e = 1; e <= n; e++) {
                    arr[s][e] = Math.min(arr[s][e], arr[s][mid] + arr[mid][e]);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] == (int) 1e9) { // 갈 수 없는 경우에는 그 자리에 0을 출력 -> 이거를 고려하지 않아 한번에 못맞춤 ㅜㅜ
                    System.out.print(0 + " ");
                } else {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}