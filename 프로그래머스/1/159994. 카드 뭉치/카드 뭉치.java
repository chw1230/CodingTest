
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer;
        Deque<String> dqCard1 = new ArrayDeque<>();
        Deque<String> dqCard2 = new ArrayDeque<>();
        Deque<String> dqGoal = new ArrayDeque<>();

        for (String s : cards1) {
            dqCard1.addLast(s);
        }
        for (String s : cards2) {
            dqCard2.addLast(s);
        }
        for (String s : goal) {
            dqGoal.addLast(s);
        }

        while (!dqGoal.isEmpty()) {
            if ( !dqCard1.isEmpty() && dqGoal.peek().equals(dqCard1.peek())) {
                dqGoal.poll();
                dqCard1.poll();
            } else if ( !dqCard2.isEmpty() && dqGoal.peek().equals(dqCard2.peek())) {
                dqGoal.poll();
                dqCard2.poll();
            } else {

                return "No";
            }
        }
        return "Yes";
    }
}