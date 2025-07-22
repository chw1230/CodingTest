class Solution {
    public static long[] solution(int n, long left, long right) {
        // 기존의 2차원 배열을 생성하고 배열을 잘라서 1차원 배열을 만드는 방식 -> 메모리 초과 오류!
        // 필요한 만큼만 계산으로 배열에 추가하기
        // 2차원 배열을 생성한다고 했을 때 대각을 기준으로 우측은 [0][1],[0][2] 처럼 행이 더큼! 이때 배열의 값은 행의 인덱스 + 1을 해줬으니
        // max에서 큰 것만 배열로 취급하면 됨!
        long arr[] = new long[(int) (right-left+1)];

        for (long i = left; i <= right; i++) {
            arr[(int) (i-left)] = Math.max(i / n + 1, i % n + 1);
        }

        return arr;
    }
}