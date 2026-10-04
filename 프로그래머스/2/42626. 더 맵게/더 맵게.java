
import java.util.PriorityQueue;

class Solution {
    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int sco : scoville) {
            pq.offer(sco);
        }

        int cnt = 0;
        while( pq.peek() < K) {
            // 계산
            int n1 = pq.poll();
            int n2 = pq.poll();
            int sum = n1 + n2 * 2;

            // 넣기
            pq.offer(sum);

            // 수 증가
            cnt++;

            // 불가 조건
            if (pq.size() == 1 && pq.peek() < K) {
                return -1;
            }
        }

        return cnt;
    }
}