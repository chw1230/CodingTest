import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    int solution(int[] priorities, int location) {

        Queue<process> q = new ArrayDeque<>();

        // 우선 순위를 역순으로 저장하는 pq 설정
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // q 설정
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new process(priorities[i], i));
            pq.offer(priorities[i]);
        }

        process p = q.poll();
        int cnt = 1; // q에서 뺀 횟수
        while (p.pos != location || p.priority != pq.peek()) {
            if (p.priority == pq.peek()) {
                pq.remove();
                cnt++;
                p = q.poll();
                continue;
            }
            q.add(p);
            p = q.poll();
        }
        return cnt;
    }

    class process {
        int priority;
        int pos;

        public process(int priority, int pos) {
            this.priority = priority;
            this.pos = pos;
        }
    }
}