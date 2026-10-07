import java.util.*;

class Solution {
     public int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;

        Arrays.sort(citations); // 특정한 index 이후의 논문들은 모두 citations[index]번 이상의 인용이 된 것!

        for (int i = 0; i < n; i++) {
            int remain = n - i; // 남아있는 논문 개수

            if (remain <= citations[i] ) {
                return remain;
            }
        }
        return 0;
    }
}