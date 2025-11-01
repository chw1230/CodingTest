import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Solution {
    public static int solution(int k, int[] tangerine) {
        int answer = 0; // 종류의 수
        HashMap<Integer, Integer> map = new HashMap<>(); // size, 개수
        for (int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>(map.values());
        list.sort(Collections.reverseOrder()); // 개수 기준 내림 차순 정렬

        for (Integer l : list) {
            if (k <= 0) {
                return answer;
            }
            k -= l;
            answer++;
        }
        return answer;
    }
}