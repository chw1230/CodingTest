import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
      public int[] solution(String[] operations) {
        int[] answer = {};

        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());

        for (String op : operations) {
            String[] parts = op.split(" ");
            int num = Integer.parseInt(parts[1]);

            if (parts[0].equals("I")) {
                minPq.offer(num);
                maxPq.offer(num);
            } else {
                // I 아니면 무조건 D임
                if ( !minPq.isEmpty() && !maxPq.isEmpty() ) {
                   if (parts[1].equals("1")) {
                        // max 꺼내기
                        int max = maxPq.poll();
                        minPq.remove(max); // minPq에서도 지워주기
                    } else {
                        int min = minPq.poll();
                        maxPq.remove(min);
                    }
                }
            }

        }

        if (minPq.isEmpty()) {
            return new int[]{0, 0};
        }
        return new int[]{maxPq.peek(), minPq.peek()};
    }
}