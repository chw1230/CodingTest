import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) ->{
            int A = Math.abs(a);
            int B = Math.abs(b);
            if (A == B) {
                return a - b; // 절대값이 같은 경우에는 오름 차순으로!
            }
            return A - B; // 절댓값 오름차순
        });
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if ( x != 0) {
                pq.add(x); // 값 넣기
            } else { // 0 입력
                if (pq.isEmpty()) { // 근데 비어있다면
                    System.out.println(0); // 0 출력
                } else {
                    System.out.println(pq.poll());
                }
            }
        }
    }
}