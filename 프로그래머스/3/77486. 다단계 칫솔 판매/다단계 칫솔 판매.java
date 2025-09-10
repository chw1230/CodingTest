import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
    // map으로 부모 자식 관계를 만들어서 부모를 계속 불러내는 방식으로 해결하는 게 어려웠음
    // 문제 파악의 오류 -> 최종값이 해당 사람이 총 얻은 금액을 반환하는 건데 나는 돈을 한번 벌었을 때 각각 얼마 받는지를 구하는 문제인 줄 알았음
    // while 문 조건에서 money가 0보다 큰 조건 설정하지 않은 오류
    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        Map<String,String> relation = new LinkedHashMap<>(); // 자식, 부모 / N : 1 관계이니까
        for (int i = 0; i < enroll.length; i++) {
            relation.put(enroll[i], referral[i]);
        }

        Map<String, Integer> map = new HashMap<>(); // 사람, 수익금
        for (int i = 0; i < seller.length; i++) {
            int money = amount[i] * 100;
            while (!seller[i].equals("-") && money > 0) { // 센터에 도달할 때까지 반복
                map.put(seller[i], map.getOrDefault(seller[i], 0) + (money - money / 10));
                seller[i] = relation.get(seller[i]); // 부모 소환하기
                money = money / 10; // 부모가 받는 돈
            }
        }

        int i = 0;
        for (String s : relation.keySet()) {
            if (map.containsKey(s)) {
                answer[i] = map.get(s);
            }
            i++;
        }

        return answer;
    }
}