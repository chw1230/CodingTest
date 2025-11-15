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

        int[] top = new int[N];
        int[] bottom = new int[N];

        Deque<Integer> dq = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dq.addLast(Integer.valueOf(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dq.addLast(Integer.valueOf(st.nextToken()));
        }
        for (int i = 0; i < T; i++) {
            int n = dq.removeLast();
            dq.addFirst(n);
        }

        for (int i = 0; i < N; i++) {
            top[i] = dq.removeFirst();
            bottom[N - 1 - i] = dq.removeLast();
        }

        for (int i = 0; i < N; i++) {
            System.out.print(top[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < N; i++) {
            System.out.print(bottom[i] + " ");
        }
    }
}