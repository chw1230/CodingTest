import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 노드 수
        int[][] arr = new int[N][N];

        // 인접 행렬 받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
            // i 번째와 연결된 노드 j
        }

        // 중간을 의미하는 k, 출발을 의미하는 i, 도착을 의미하는 j
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][k] == 1 && arr[k][j] == 1) {
                        // i 노드에서 k 노드로 갈 수 있고 k노드에서 j 노드로 갈 수 있다면
                        arr[i][j] = 1; // i 노드에서 j 노드로 갈 수 있음을 표시하기
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}