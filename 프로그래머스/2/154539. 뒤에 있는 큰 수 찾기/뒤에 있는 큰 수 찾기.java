import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < numbers.length; i++) {

            // 스택에 자기보다 큰 수가 없는 경우에
            // 스택에 자신의 인덱스 번호를 넣기
            // s에 넣은 수보다 큰 수가 온다면
            while ( !s.isEmpty() && numbers[i] > numbers[s.peek()]) {
                // s에서 해당 수를 빼기
                int p = s.pop();
                answer[p] = numbers[i];
            }
            s.push(i);
        }

        while (!s.isEmpty()) {
            int p = s.pop();
            answer[p] = -1;
        }

//        for (int i : answer) {
//            System.out.print(i+ " ");
//        }
//        System.out.println();

        return answer;
    }
}