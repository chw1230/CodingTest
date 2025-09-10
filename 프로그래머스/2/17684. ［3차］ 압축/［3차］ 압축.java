import java.util.*;

class Solution {
    // 너어어어엉 무 어려워용   푸푸푸푸ㅜ푸ㅠㅜㅠㅜㅠㅜㅠㅠㅜ
// 내가 생각하면 겁나 복잡한데 왜 정답은 왜이렇게 간단한거임??
// 내가 푼거는 s에 값을 누적해서 계속 더하는 과정으로 풀었음 -> 그러니까 또 lsit에 추가하는 과정에서 잘라서 map에서 찾아서 넣고 이런과정이 오류를 유발했음!
// 이전 풀이 방법은 map에 없는 단어를 만드는데 집중해서 붙이고 떼는 과정이 복잡했음
// 정답 코드는 현 위치에서 사전에 있는 가장 긴 문자열을 고랄내는 것이에게 lsit에 추가하거나 map에 추가하는 과정이 복잡하지 않음!
// 결국 list을 반환해주는 건데 map 만들기에 더 치중해서 문제 푸는데 더 어려웠던 것 같음 잘 안풀리면 문제가 요구하는 것을 다시 한번 살펴서 거기에 집중해서 풀어보자!
        public static Integer[] solution(String msg) {
        Map<String, Integer> map = new LinkedHashMap<>();
        // 초기화
        for (int i = 0; i < 26; i++) {
            map.put(String.valueOf((char) ('A' + i)), i + 1);
        }
        // 새로 추가되는 것은 27부터!
        int nextIdx = 27;

        List<Integer> list = new ArrayList<>();
        int idx = 0;

        while (idx < msg.length()) {
            String s = "";
            // 현 인덱스에서 가장 길이가 긴 문자열 찾기
            for (int len = 1; len + idx <= msg.length(); len++) {
                String curr = msg.substring(idx, len + idx); // 문자열을 잘라서

                if (map.containsKey(curr)) { // 있으면
                    s = curr; // 최신화
                } else { // 없으면
                    map.put(curr, nextIdx++); // 넣기
                    break;
                }
            }

            list.add(map.get(s));
            idx += s.length();
        }

        return list.toArray(new Integer[0]);
    }
}