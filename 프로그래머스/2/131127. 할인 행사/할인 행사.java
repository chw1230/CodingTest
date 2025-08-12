import java.util.HashMap;

class Solution {
   public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        for (int i = 0; i < discount.length - 9; i++) {
            HashMap<String,Integer> map = new HashMap<>();
            for (int k = 0; k < want.length; k++) {
                map.put(want[k], number[k]);
            }
            for (int j = i; j < 10+i; j++) {
                if (map.containsKey(discount[j])) {
                    map.put(discount[j], map.get(discount[j]) - 1);
                    if (map.get(discount[j]) == 0) {
                        map.remove(discount[j]);
                    }
                }

            }
            if (map.isEmpty()){
                answer++;
            }
        }
        return answer;
    }
}