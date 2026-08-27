class Solution {
    // 동영상의 길이, 기능 수행 전 재생위치, 오프닝 시작 시각, 오프닝이 끝나는 시각, 사용자의ㅡ입력
    public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";

        int videoLen = makeMin(video_len);
        int cur = makeMin(pos);
        int start = makeMin(op_start);
        int end = makeMin(op_end);


        // 무조건 오프닝 타임에 도달하면 무조건 오프닝 종료로 이동하기

        for (String command : commands) {
            // 오프닝 타임 체크 func
            if (opCheck(cur, start, end)) { // 오프닝 타임 속에 속하면 무조건 op_end로 이동하기
                cur = end;
            }

            if (command.equals("next")) {
                cur += 10;
                if ( videoLen < cur ) {
                    cur = videoLen;
                }
            } else {
                cur -= 10;
                if (cur < 0) {
                    cur = 0;
                }
            }
        }
        if (opCheck(cur, start, end)) { // 오프닝 타임 속에 속하면 무조건 op_end로 이동하기
            cur = end;
        }

        int m = cur / 60;
        int s = cur % 60;
        answer = String.format("%02d:%02d", m, s);
        return answer;
    }

    private static boolean opCheck(int cur, int start, int end) {

        if (start <= cur && cur <= end) {
            return true;
        }
        return false;
    }

    private static int makeMin(String time) {
        String[] times = time.split(":");
        return Integer.parseInt(times[1]) + Integer.parseInt(times[0]) * 60;
    }
}