import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        HashMap<Integer, Double> map = new HashMap<>(); // 스테이지 번호와 실패율 저장

        int sum = stages.length; // 스테이지에 도달한 전체 사용자 수
        for (int i = 0; i < N; i++) {
            int cnt = 0; // 아직 클리어하지 못한 사용자 수
            for (int j = 0; j < stages.length; j++) {
                if (i == stages[j] - 1) { // i+1 스테이지에 도전 중인 사람
                    cnt++;
                }
            }
            double rate = (sum == 0) ? 0.0 : (double) cnt / sum;
            map.put(i + 1, rate);
            sum -= cnt;
        }

        // 실패율 내림차순 정렬
        List<Map.Entry<Integer, Double>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.<Integer, Double>comparingByValue().reversed());

        // 정렬된 스테이지 번호 저장
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i).getKey();
        }
        return answer;
    }
}