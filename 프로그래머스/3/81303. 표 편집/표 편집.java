import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {
    public static String solution(int n, int k, String[] cmd) {
        Deque<Integer> stack = new ArrayDeque<>();
        int idx[][] = new int[n + 2][2]; // i번째 행번호에서 idx[i][0] -> 위의 어떤 행과 연결되어 있는지, idx[i][1] -> 아래 어떤 행과 연결되어 있는지 => 연결? 연관? 관계로 생각하기!

        for (int i = 0; i < idx.length; i++) {
            idx[i][0] = i - 1; // 가상 공간을 고려하여 값 넣기
            idx[i][1] = i + 1;
        }

        k++; // 가상 공간 (배열)로 인해 현재 위치 값 하나 키워주기

        for (String s : cmd) {
            if (s.charAt(0) == 'C') { // 선택항 삭제 + 아래 행 선택 ( 선택 항이 가장 마지막인 경우 바로 윗 항 선택 )
                stack.push(k); // 삭제항 stack에 보관
                // idx 배열 정리
                idx[idx[k][0]][1] = idx[k][1]; // 삭제된 항을 인식하지 않도록 내렸을 때
                idx[idx[k][1]][0] = idx[k][0]; // 삭제된 항을 인식하지 않도록 올렸을 때
                k = (idx[k][1] <= n ? idx[k][1] : idx[k][0]); // 마지막인 경우 고려

            } else if (s.charAt(0) == 'Z') {
                int re = stack.pop();
                idx[ idx[re][0] ][1] = re;
                idx[ idx[re][1] ][0] = re;

            } else {
                int move = Integer.parseInt(s.substring(2));


                for (int i = 0; i < move; i++) {
                    k = (s.charAt(0) == 'U') ? idx[k][0] : idx[k][1];
                }
            }
        }

        char[] answer = new char[n];
        Arrays.fill(answer, 'O'); // 모두 O로 채우고

        for (Integer i : stack) { // 삭제된 요소들에 대해서
            answer[i - 1] = 'X'; // X 표시
        }

        return new String(answer);
    }
}
