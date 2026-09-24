import java.util.Arrays;

class Solution {
      public static int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        int l = 0;
        int h = people.length - 1;

        while (l <= h) {
            int sum = people[l] + people[h];
            if (sum <= limit) {
                l++;
            } 
            h--;
            answer++;
        }
        return answer;
      }
}