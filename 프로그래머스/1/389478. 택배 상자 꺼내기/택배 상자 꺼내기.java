class Solution {
    public static int solution(int n, int w, int num) {
        int answer = 0;

        // 전체 층 ( 0층 부터 시작하도록 ! )
        int floor = (n - 1) / w;

        // num이 위치한 행
        int numRow = (num - 1) / w;

        // num이 위치한 열 -> 홀수 층, 짝수 층에 따라 다름!
        int numCol;
        if (numRow % 2 == 0) {
            numCol = (num - 1) % w;
        } else {
            numCol = w - (num - 1) % w - 1;
        }

        // 찾으려는 수의 층 부터
        for (int i = numRow; i <= floor; i++) {
            int curIdx; // 실제 상자 값

            // 짝수 층이면
            if (i % 2 == 0) {
                curIdx = i * w + numCol;
            } else {
                curIdx = i * w + (w - 1 - numCol);
            }

            // 증가하는 층에서 특정 열의 값이 존재하면 (n보다 작으면 값이 존재하는 것) answer의 값을 키워주기
            if (curIdx < n) {
                answer++;
            }

        }

        return answer;
    }
}