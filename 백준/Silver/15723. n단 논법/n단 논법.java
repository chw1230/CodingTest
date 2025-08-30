import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static boolean[][] graph = new boolean[27][27];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 루프 T 처리
        for (int i = 1; i <= 26; i++) {
            graph[i][i] = true;
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String start = st.nextToken();
            String is = st.nextToken(); // is는 버리기!
            String end = st.nextToken();

//            System.out.println((start.charAt(0) - 'a') + " " + (end.charAt(0) - 'a'));
            graph[start.charAt(0) - 'a' + 1][end.charAt(0) - 'a' + 1] = true;
        }

//        for (int i = 1; i <= 26; i++) {
//            for (int j = 1; j <= 26; j++) {
//                System.out.print(graph[i][j] + " ");
//            }
//            System.out.println();
//        }

        for (int i = 1; i <= 26; i++) {
            for (int j = 1; j <= 26; j++) {
                for (int k = 1; k <= 26; k++) {
                    if ( graph[j][i] && graph[i][k]) {
                        graph[j][k] = true;
                    }
                }
            }
        }

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String start = st.nextToken();
            String is = st.nextToken(); // is는 버리기!
            String end = st.nextToken();

            if (graph[start.charAt(0) - 'a' + 1][end.charAt(0) - 'a' + 1]) {
                System.out.println("T");
            } else {
                System.out.println("F");
            }
        }
    }
}