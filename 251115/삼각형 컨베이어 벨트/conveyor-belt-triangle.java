import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new ArrayDeque<>();

        // 3줄에 걸쳐 각 줄마다 N개씩 읽기
        for (int line = 0; line < 3; line++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                dq.addLast(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i < T; i++) {
            int right = dq.removeLast();
            dq.addFirst(right);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(dq.removeFirst()).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}