import java.util.Arrays;

class Solution {
     public long solution(int n, int[] times) {
        Arrays.sort(times);

        long left = 1;
        long right = (long) times[times.length - 1] * n; // 가장 오래 걸리는 시간

        while (left < right) {
            long mid = left + (right - left) / 2;

            long cnt = 0;

            // 나눌 수 있는 사람의 수를 구하기
            for (int time : times) {
                cnt += (mid / time);
            }

            if (n <= cnt) { // 더 많은 사람을 심사할 수 있으니까 시간이 충분한 상황! -> 시간을 더 줄이기
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}