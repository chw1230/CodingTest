import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[][] arr;
    private static int[] type; //  -1,0,1
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

        type = new int[3];
        div(0, 0,N);
        for (int i : type) {
            System.out.println(i);
        }
    }

    private static void div(int y, int x, int size) {
        if (ckeck(y, x, size)) {
            if (arr[y][x] == -1) {
                type[0]++;
            } else if (arr[y][x] == 0) {
                type[1]++;
            } else {
                type[2]++;
            }
            return;
        }

        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                div(y+i*newSize,x+j*newSize,newSize);
            }
        }
    }

    private static boolean ckeck(int y, int x, int size) {
        int save = arr[y][x];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (arr[y + i][x + j] != save) {
                    return false;
                }
            }
        }
        return true;
    }
}
