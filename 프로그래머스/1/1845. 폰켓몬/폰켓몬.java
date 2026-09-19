import java.util.*;

class Solution {
   public int solution(int[] nums) {
        int answer = 0;

        // 잡아가야하는 포켓몬 개수
        int getCnt = nums.length / 2;

        // 포켓몬 목록
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // 잡아가야 하는데 목록에 겹치는게 너무 많으면 종류의 수 만큼만 가져가는 것이 최대값
        if (getCnt >= set.size()) {
            return set.size();
        }

        return getCnt;
    }
}