import java.util.ArrayList;

class Solution {
    static int c;
    
    public int solution(String word) {

        String[] str = new String[]{"A", "E", "I", "O", "U"};

        dfs(str, word, new int[]{0}, new ArrayList<>());
        
        return c;
    }

    // 문자 배열, 찾으려는 문자열, 숫자 카운트를 담을 배열, 문자를 담을 리스트
    // 왜 숫자 카운트를 배열로 관리하는가? -> 그냥 일반 변수를 사용하면 백트래킹 과정에서 값의 누적이 존재하지 않음!
    /* 5 -> 6,7,8,9에서
       다시 6부터 시작하는 문제 해결 */
    private void dfs(String[] str, String word, int[] cnt, ArrayList<String> answer) {
        // 정답인 경우
        if (word.equals(String.join("", answer))) {
            c = cnt[0];
        }

        // 최대 길이인 5를 넘으면 더 이상 탐색하지 않음
        if (answer.size() == 5) {
            return;
        }

        // 5가지로 분기하기
        for (int i = 0; i < str.length; i++) {
            cnt[0]++; // 탐색 횟수 증가
            answer.add(str[i]); // 추가

            dfs(str, word, cnt, answer);

            answer.remove(answer.size() - 1); // 마지막에 넣은 것은 제거하기
        }
    }
}