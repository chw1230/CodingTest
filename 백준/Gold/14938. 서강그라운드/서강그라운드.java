import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());


        int item[] = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < item.length; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

        int dis[][] = new int[n + 1][n + 1]; // 최단 거리 배열
        for (int[] d : dis) {
            Arrays.fill(d, (int) 1e9);
        }
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dis[a][b] = c;
            dis[b][a] = c;
        }
        for (int i = 0; i < dis.length; i++) {
            dis[i][i] = 0;
        }

        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    dis[a][b] = dis[b][a] = Math.min(dis[a][b], dis[a][k] + dis[k][b]);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < dis.length; i++) {
            int sum = item[i];
            for (int j = 0; j < dis[i].length; j++) {
                if (dis[i][j] <= m & i != j) {
                    sum += item[j];
                }
            }
            max = Math.max(sum, max);
        }
        System.out.println(max);
    }
}