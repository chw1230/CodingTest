import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static int M;
    private static int N;
    private static int[] checked;
    private static int[] arr;
    private static Map<String,Integer> map;

    private static void DFS(int cnt) {
        if (cnt == M) {
            String s = "";
            for (int i : checked) {
                s += i + " ";
            }
            if (map.getOrDefault(s, 0) == 0) {
                System.out.println(s);
                map.put(s,1);
            }
            return;
        }
        for (int i = 0; i < N; i++) {
            if ( 1 <= cnt ) {
                if (checked[cnt - 1] <= arr[i]) {
                    checked[cnt] = arr[i]; // 체크 배열에 넣기
                    DFS(cnt + 1);
                }
            } else {
                checked[cnt] = arr[i]; // 체크 배열에 넣기
                DFS(cnt + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }
        Arrays.sort(arr);

        checked = new int[M];
        map = new HashMap<>();
        DFS(0);
    }
}