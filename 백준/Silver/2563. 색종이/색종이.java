import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class Rac {
        int x1,y1;

        public Rac(int x1,int y1){ //
            this.x1 = x1;
            this.y1 = y1;
        }
    }
    // 좌표계산 (어렵다) -> 배열 방문을 통한 색칠 이용!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int maxX = 0, maxY = 0; // 최대 X,Y를 활용한 배열 만들기

        Rac[] racs = new Rac[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            maxX = Math.max(maxX, x);
            maxY = Math.max(maxY, y);
            racs[i] = new Rac(x, y);
        }

        // 색칠 배열
        int arr[][] = new int[maxX+10][maxY+10]; // 칠해지면 1, 아니면 0
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = racs[i].x1; j < racs[i].x1+10; j++) {
                for (int k = racs[i].y1; k < racs[i].y1+10; k++) {
                    if (arr[j][k] == 0) {
                        arr[j][k] = 1;
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}