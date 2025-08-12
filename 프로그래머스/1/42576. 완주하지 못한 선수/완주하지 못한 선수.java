import java.util.HashMap;

class Solution {
    public static String solution(String[] participant, String[] completion) {
        HashMap<String,Integer> map = new HashMap<>();

        for (String s : completion) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (String s : participant) {
            if ( map.getOrDefault(s, 0) == 0) { // 완주자가 없어서 0이 나오는 경우와 n명의 참가자 중 n-1명의 참가자만 완주를 한 경우를 신경씀!
                return s;
            }
           // if (map.containsKey(s)) { // -> 해당 코드를 위에처럼 리펙토링 가능!!
           //     if (map.get(s) == 0) {
           //         return s;
           //     }
           // } else {
           //     return s;
           // }
            map.put(s, map.getOrDefault(s, 0) - 1);
        }

        return "";
    }
}