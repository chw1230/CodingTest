import java.util.Arrays;

class Solution {
    public int solution(int[][] scores) {

        int wa = scores[0][0];
        int wb = scores[0][1];
        int wSum = wa + wb;

        // 정렬의 조건 앞 사람은 나보다 근무태도가 높거나 같음
        // 근무 태도가 같다면 동료 평가 오름차순
        // 이렇게 설정한 이유 : 둘 중 하나만 같거나 크면 배제되지 않음, 그래서 둘다 작은 경우를 찾아야 함!
        // 둘 다 작은 것을 찾으려면
        // 앞 쪽의 근무 태도보다 작아지는 경우에 동료 평가 지수 그것 보다
        // 작은 경우에 가장 큰 동료 평가 지수를 통해서 배제하는 데 사용하기 위해서!
        Arrays.sort(scores, (a, b) -> a[0] != b[0]
                ? Integer.compare(b[0], a[0])
                : Integer.compare(a[1], b[1])
        );

        int maxPeerScore = 0; // 가장 큰 동료 평가 점수를 담을 변수
        int rank = 0; // 완호앞에 있는 사람의 수 = 순위-1과 동일함

        for (int[] score : scores) {
            if (score[1] < maxPeerScore) {
                // 배제되는 조건
                if (wa == score[0] && wb == score[1]) { // 배제되는 조건이 완호인 경우
                    return -1;
                }
                continue;
            }
            // 우리의 특정 정렬이 합을 기준으로 정렬한 것이 아닌 경우도 존재!!
            // 예> 완호 - {5,4} 앞에 {6,1}-> 이거 근데 사실 합이 더 작아서 완호 보다 더 뒤에 위치함!
            if (score[0] + score[1] > wSum) {
                rank++;
            }
            maxPeerScore = Math.max(maxPeerScore, score[1]);
        }

        return rank + 1;
    }
}