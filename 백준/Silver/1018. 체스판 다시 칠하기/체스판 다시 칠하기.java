import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        // 배열의 크기 받기
        char [][] arr = new char[N][M];
        int result = 100;

        // 배열에 저장
        for (int i = 0; i < N; i++) {
            String line = br.readLine(); // 줄 단위로 읽고
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j); // 문자 하나씩 저장
            }
        }

        // CNN 커널 느낌? -> 슬라이딩 윈도우 기법!
        // 고정된 크기의 윈도우(부분)를 전체 데이터에서 한 칸씩 이동시키며 검사하는 방식
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int cntW = 0;
                int cntB = 0;
                for ( int x = 0; x < 8; x++ ) {
                    for ( int y = 0; y < 8; y++ ) {

                        if ((x + y) % 2 == 0) {
                            // 처음으로 나오는 색상과의 비교
                            // 0이라면 처음으로 나오는 색상과 같아야 하는 경우이고 아니라면 반대되는 색상을 의미!!
                            if (arr[i + x][j + y] != 'W') { cntW++; } // 나오지 말아야 하는 곳에서 안 나오면 바꿔 줘야 할 개수 하나 추가 -> 처음에 W가 나와서 W가 나와야 하는 자리에 W가 안나온 경우 W를 바꿔줘야할 W의 개수 키워주기
                            if (arr[i + x][j + y] != 'B') { cntB++; } // 동일
                        } else {
                            if (arr[i + x][j + y] != 'B') { cntW++; } // B가 아니면 W임! 그니까 잘못나온 경우임 그래서 바꿔줘야할 W개수 키워주기
                            if (arr[i + x][j + y] != 'W') { cntB++; }
                        }
                    }
                }
                //  8 * 8 체스판에서 W B의 개수는 항상 일정!!
                result = Math.min(result, Math.min(cntW, cntB)); // 문제에서 요구한 바꾸는 것을 최소화 하는 수와 기존의 결과 값과 비교해서 최신화
            }
        }
        System.out.println(result);
    }
}