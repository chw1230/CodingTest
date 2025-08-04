import java.util.ArrayDeque;
import java.util.Deque;

public class Solution{
    public int[] solution(int[] progresses, int[] speeds) {
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < progresses.length; i++) {
            int days = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            q.addLast(days);
        }

        Deque<Integer> q2 = new ArrayDeque<>();
        int days = q.removeFirst();
        int cnt = 1;

        while (!q.isEmpty()) {
            int next = q.removeFirst();
            if (days >= next) {
                cnt++;
            } else {
                q2.addLast(cnt);
                cnt = 1;
                days = next;
            }
        }
        q2.addLast(cnt); 

        int len = q2.size();
        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            answer[i] = q2.removeFirst();
        }

        return answer;
    }
}