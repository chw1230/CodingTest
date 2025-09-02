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
    private static boolean[] visited;
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
            if (!visited[i]) { // 방문 안했다면
                visited[i] = true;
                checked[cnt] = arr[i]; // 체크 배열에 넣기
                DFS(cnt + 1);
                visited[i] = false;
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
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            max = Math.max(max, num);
        }
        Arrays.sort(arr);

        visited = new boolean[N];
        checked = new int[M];
        map = new HashMap<>();
        DFS(0);
    }
}