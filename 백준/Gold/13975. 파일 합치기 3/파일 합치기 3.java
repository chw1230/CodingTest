import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            PriorityQueue<Long> pq = new PriorityQueue<>();
            for (int i = 0; i < K; i++) {
                pq.add(Long.parseLong(st.nextToken()));
            }

            long sum = 0;
            while (pq.size() > 1) {
                long a = pq.poll();
                long b = pq.poll();

                sum += (a + b);
                pq.add(a + b);
            }

            sb.append(sum).append('\n');
        }
        System.out.print(sb);
    }
}