import java.util.Stack;

class Solution {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0; // 터진 개수
        int len = board.length;

        Stack<Integer> arr[] = new Stack[len];
        for (int i = 0; i < len; i++) {
            arr[i] = new Stack<>(); // arr 초기화
        }

        for (int i = 0; i < len; i++) {
            for (int j = len-1; j > -1; j--) {
                int save = board[j][i];
                if (save != 0) {
                    arr[i].push(save);
                }
            }
        }

        Stack<Integer> answerArr = new Stack<>();
        for (int i = 0; i < moves.length; i++) {
            int idx = moves[i] - 1;
            if (!arr[idx].isEmpty()) { // 비어있지 않으면
                int value = arr[idx].pop();
                if (answerArr.empty()) { // 비어 있는 경우 그냥 일단 넣기
                    answerArr.push(value);
                } else {
                    if ( answerArr.peek() == value ) { // 정답 스택의 맨위 값과 새로 넣는 값이 같은 경우
                        answer += 2; // 같은거 터트려서 2점 획득
                        answerArr.pop(); // 맨위거 삭제
                    } else { // 같지 않으면
                        answerArr.push(value); // 그냥 정답 스택에 값 넣기
                    }
                }
            }

        }
        
        return answer;
    }
}