import java.util.HashMap;

class Solution {
  public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        HashMap<String, Integer> userMap = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < want.length; i++) {
            userMap.put(want[i], number[i]);
            sum += number[i];
        }

        for (int i = 0; i <= discount.length - sum; i++) {
            HashMap<String, Integer> tempMap = new HashMap<>(userMap);
            boolean m = true;

            for (int j = 0; j < sum; j++) {
                String key = discount[i + j];
                if (tempMap.containsKey(key) && tempMap.get(key) > 0) {
                    tempMap.put(key, tempMap.get(key) - 1);
                } else {
                    m = false;
                    break; // 조건 안 맞으면 안쪽 반복문 탈출
                }
            }

            if (m) {
                answer++;
            }
        }
        return answer;
    }
}