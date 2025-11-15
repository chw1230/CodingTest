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
        for (int l = 0; l < 3; l++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                dq.addLast(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i < T; i++) {
            int right = dq.removeLast();
            dq.addFirst(right);
        }

        for (int i = 0; i < N*3; i++) {
            System.out.print(dq.removeFirst()+ " ");
            if ( i != 0 && (i+1) % 3 == 0) {
                System.out.println();
            }
        }
    }
}