import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    // 우측으로 이동, 좌측으로 이동, 아래로 이동, 위로 이동
    static int[] moveX = {1, -1, 0, 0};
    static int[] moveY = {0, 0, 1, -1};
    static int arr[][];

    public static boolean DFS(int x, int y) {
        // 배열 밖으로 넘어가는 것 false 처리
        if (x <= -1 || y <= -1 || x >= M || y >= N) {
            return false;
        }

        // 배추 있는 곳!
        if (arr[y][x] == 1) {
            arr[y][x]++; // 방문 흔적 남기기
            for (int k = 0; k < 4; k++) { // 움직이기
                DFS(x+moveX[k], y+moveY[k]);
            }
            return true; // 무조건 1이였던 곳은 true를 반환하게 됨!
            // 무조건 ture가 나오면 개수 증가인가? -> 아니다 재귀 안에서의 true가 아니라 처음에 main에서 호출한 ture에 따라서 개수++ 인것!
        }
        return false;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for (int i = 0; i < test; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로
            N = Integer.parseInt(st.nextToken()); // 세로
            int K = Integer.parseInt(st.nextToken()); // 배추 심어진 개수

            arr= new int[N][M];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()); // 배추 인덱스 위치 x
                int y = Integer.parseInt(st.nextToken()); // 배추 인덱스 위치 y
                arr[y][x]++;
            }

//            배열 출력
//            for (int j = 0; j < N; j++) {
//                for (int k = 0; k < M; k++) {
//                    System.out.print(arr[j][k]);
//                }
//                System.out.println("");
//            }

            int cnt = 0;
            for (int y = 0; y < arr.length; y++) {
                for (int x = 0; x < arr[0].length; x++) {
                    if (DFS(x,y)){ // 1로 쭉 연결된 곳은 ture를 반환하니까 ture를 받을 때만 cnt++하기
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}