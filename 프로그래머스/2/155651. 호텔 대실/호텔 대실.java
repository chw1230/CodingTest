import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;

        // 종료 시간 오름차순 담기
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(book_time, (a, b) -> minutes(a[0]) - minutes(b[0]));

        for (int i = 0; i < book_time.length; i++) {
            int start = minutes(book_time[i][0]);
            int end = minutes(book_time[i][1]) + 10;

            // pq에서 제거 동작
            if (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }
            pq.offer(end);
        }

        return pq.size();
    }

    private int minutes(String s) {
        String[] arr = s.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }
}