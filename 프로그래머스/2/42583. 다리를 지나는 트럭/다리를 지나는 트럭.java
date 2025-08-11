import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    // 어려웠던 이유 : 뭐를 큐로 두고, 큐를 몇개 사용하고, 다리에 적용되는 무게는 뭘로 표현 하며, 시간은 언제 키워야 할지 감이 전혀 잡히지 않았음!
    // 특히 큐에 0을 넣는다는 생각 조차 하지 못했었음....
    public static int solution(int len, int weight, int[] truck_weights) {
        Deque<Integer> bridge = new ArrayDeque<>();

        int time = 0; // 시간
        int currWeight = 0; // 현재 다리에 적용되는 무게 합
        int idx = 0; // 대기 트럭 인덱스
        // 여기 까지는 수월하게 정의하였음!

        // 초기화 과정
        for (int i = 0; i < len; i++) {
            bridge.addLast(0);
        }

        while (idx < truck_weights.length) { // 대기하는 트럭이 없을 때 까지
            time++; // 1초 증가

            currWeight -= bridge.pollFirst(); //  초반에 0이 채워지니까 문제 없음! 초반엔 0이 빠짐

            if (currWeight + truck_weights[idx] <= weight) { // 만약에 다리에 올라 갈 수 있는 상황이라면
                bridge.addLast(truck_weights[idx]); // 큐에 넣기
                currWeight += truck_weights[idx++]; // 큐에 적용되는 무게 최신화하고 idx 값 키워주기
            } else { // 못 올라가면 0을 채워주기 -> 가장 생각하기 어려웠던 부분
                bridge.addLast(0); // 0을 채워서 트럭이 홀로 이동하는 것 표현!!!!!!
            }
        }

        // 마지막 트럭이 다리에 들어서면 끝나고 길이만큼 더해준다! -> 다리 길이가 곧 트럭 하나 홀로 온전히 건너는 시간이니까
        return time + len;
    }
}