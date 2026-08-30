class Solution {
    public int solution(int[][] signals) {
        int[] cnt = new int[signals.length]; // 주기배열
        long lcm = 1; // 최소공배수

        for (int i = 0; i < signals.length; i++) {
            cnt[i] = signals[i][0] + signals[i][1] + signals[i][2];
            lcm = getLcm(lcm, cnt[i]);
        } // 최종적으로 최소공배수가 저장됨

        // 1초 부터 최소공배수가 되는 부분 까지 돌면서 조건이 만족하는 부분을 찾기
        for (int t = 1; t <= lcm; t++) {
            boolean y = true;

            // 각 신호등 사이클 종류에 맞게 탐색
            for (int j = 0; j < signals.length; j++) {
                int pos = (t - 1) % cnt[j] + 1; // 각 신호등 주기에 맞게 t초일 때의 현 위치
                int green = signals[j][0]; // 초록 지속 시간 -> 노랑의 시작 시간을 의미
                int yellow = signals[j][1]; // 노랑 지속시간 -> green과 더하면 노랑의 종료 시간을 의미

                if (!(green < pos && pos <= green + yellow)) { // 현 위치가 노랑 범위를 벗어나면 그냥 멈추기!
                    y = false;
                    break;
                }
            }

            if (y) {
                return t;
            }
        }

        return -1;
    }

    // 최소 공배수 구하기
    private long getLcm(long a, long b) {
        return (a * b) / getGcd(a, b);
    }

    // 최대 공약수 구하기
    private long getGcd(long a, long b) {
        while (b != 0) {
            long tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}