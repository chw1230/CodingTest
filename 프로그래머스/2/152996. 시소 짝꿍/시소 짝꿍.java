import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        solution(new int[]{100, 180, 360, 100, 270});
    }

    public static long solution(int[] weights) {
        long answer = 0;
        // 무게, 인원 수
        HashMap<Double, Long> map = new HashMap<>();

        for (int i = 0; i < weights.length; i++) {
            // map에 수를 넣기!!!!
            map.put((double) weights[i], map.getOrDefault((double) weights[i], 0L) + 1);
        }

        for (Double v : map.keySet()) {
            long cnt = map.get(v); // 인원 수

            // 같은 몸무게 처리하기
            if (cnt > 1) {
                answer += (cnt * (cnt - 1) / 2);
            }

            // 비율 별로 존재하는지 확인하기 위해 만들기
            double t1 = (v * 2) / 3;
            double t2 = (v * 1) / 2;
            double t3 = (v * 3) / 4;

            if (map.containsKey(t1)) {
                answer += cnt * map.get(t1);
            }
            if (map.containsKey(t2)) {
                answer += cnt * map.get(t2);
            }
            if (map.containsKey(t3)) {
                answer += cnt * map.get(t3);
            }
        }
        System.out.println(answer);
        return answer;
    }
}