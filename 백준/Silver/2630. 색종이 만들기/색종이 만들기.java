import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int white = 0;
    private static int blue = 0;
    private static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        div(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }

    private static void div(int x, int y, int size) { // 분할하는 함수
        if (check(x, y, size)) {
            if (arr[y][x] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        int newSize = size / 2; // 분할
        div(x, y, newSize); // 원래 자리에서 / 작아진 사이즈로
        div(x + newSize, y, newSize); // 원래 자리에서 우측으로만 / 작아진 사이즈로
        div(x, y + newSize, newSize); // 원래 자리에서 하단으로만 / 작아진 사이즈로
        div(x + newSize, y + newSize, newSize); // 원래 자리에서 우측으로, 하단으로 / 작아진 사이즈로
    }

    private static boolean check(int x, int y, int size) { // size * size 속 value들이 다 같은 값인지 확인하는 함수
        int save = arr[y][x]; // 저장값
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (arr[y + i][x + j] != save) { // 저장값과 하나라도 다르면 false
                    return false;
                }
            }
        }
        return true;
    }
}