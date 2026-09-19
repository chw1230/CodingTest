import java.util.*;

public class Solution {
   public static int[] solution(int[] arr) {
        int pre = arr[0];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(pre);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != pre) {
                queue.offer(pre = arr[i]);
            }
        }

        int len = queue.size();
        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            answer[i] = queue.poll();
        }

        return answer;
    }
}