class Solution {
    // 개인설정 출근시간, 출근기록, 시작요일
    public static int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int cnt = 0;
        int sDay = startday;

        for (int i = 0; i < schedules.length; i++) {
            int limitTime = getLimit(schedules[i]);

            for (int j = 0; j < 7; j++) {
                if (startday != 6 && startday != 7) {
                    if ( timelogs[i][j] <= limitTime) {
                        cnt++;
                    }
                }
                startday = (startday % 7) + 1;
            }

            if (cnt == 5) {
                answer++;
            }
            startday = sDay;
            cnt = 0;

        }

        return answer;
    }

    private static int getLimit(int schedule) {
        int limit = schedule + 10;
        if (limit % 100 >= 60) {
            limit += 40;
        }
        return limit;
    }
}