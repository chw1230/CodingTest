import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int cnt = 0;

        // 종류, 개수
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int t : topping) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < topping.length - 1; i++) {
            int t = topping[i];
            map.put(t, map.get(t) - 1);
            set.add(t);

            if (map.get(t) == 0) {
                map.remove(t);
            }

            if ( map.size() == set.size()) {
                cnt++;
            }

        }

        return cnt;
    }
}