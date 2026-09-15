class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;

        int n = players.length; // 전체 시간 길이

        int[] plus = new int[n]; // idx 시간에 돌아가는 서버의 수

        int sum = 0; // 서버 증설 횟수 합

        for (int i = 0; i < players.length; i++) {
            int p = players[i]; // i 시간에서의 게임 이용자 수

            int sCnt = p / m; // i 시간에 필요한 서버의 수

            // 서버 증설이 필요한 경우
            if (sCnt > plus[i]) {
                // 필요한 서버의 수
                int needS = sCnt - plus[i];

                answer += needS;

                // k 시간 동안 운영
                for (int j = 0; j < k && (i + j < n); j++) {
                    plus[i + j] += needS;
                }
            }
        }

        return answer;
    }
}