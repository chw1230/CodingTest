import java.util.Arrays;
import java.util.TreeSet;

class Solution {
   public static int[] solution(int[] answers) {
        int arr[][] = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int cnt[] = new int[3];
        int max = 0;

        for (int a = 0; a < cnt.length; a++) {
            for (int i = 0; i < answers.length; i++) {
                if (answers[i] == arr[a][(i)%(arr[a].length)]) {
                    cnt[a]++;
                }
            }
            if (cnt[a] > max) {
                max = cnt[a];
            }
        }

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == max) {
                set.add(i+1);
            }
        }

        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}