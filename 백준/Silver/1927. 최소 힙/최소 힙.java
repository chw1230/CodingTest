import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min-heap 구하기

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                if (pq.isEmpty()) { // 0인데 empty이면 0출력
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
            } else if (n > 0) {
                pq.add(n);
            } else {
                continue;
            }
        }
    }
}