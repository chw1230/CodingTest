class Solution {
    static int cnt;

    public static int solution(int[] numbers, int target) {
        cnt = 0;

        dfs(numbers, target, 0, 0);

        return cnt;
    }

    // 숫자 배열, 목표 숫자, 배열에서 위치한 인덱스 번호, 타겟에 가기까지의 합을 더한 합
    private static void dfs(int[] number, int target, int idx, int sum) {
        if ( idx >= number.length) { // 끝에 도달했는데
            if (sum == target) { // sum이 target과 같다면
                cnt++; // 개수 증가
            }
            return;
        }

        // 증가하는 경우의 dfs
        dfs(number, target, idx + 1, sum + number[idx]);

        // 감소하느 경우의 dfs
        dfs(number, target, idx + 1, sum - number[idx]);
    }
}