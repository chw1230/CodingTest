import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < report.length; i++) {
            String s1 = report[i].split(" ")[0];
            String s2 = report[i].split(" ")[1];

            if (map.containsKey(s1)) {
                if (!map.get(s1).contains(s2)) {
                    map.get(s1).add(s2);
                }
            } else {
                List<String> list = new ArrayList<>();
                list.add(s2);
                map.put(s1, list);
            }
        }

        Map<String , Integer> cnt = new LinkedHashMap<>();
        for (String s : id_list) {
            cnt.put(s, 0);
        }

        for (List<String> value : map.values()) {
            for (String s : value) {
                if (cnt.containsKey(s)) {
                    cnt.put(s, cnt.get(s) + 1);
                } else {
                    cnt.put(s, 1);
                }
            }
        }

        int i = 0;
        for (String s : cnt.keySet()) {
            if ( map.get(s) != null) {
                for (String str : map.get(s)) {
                     if ( cnt.get(str) >= k) {
                         answer[i]++;
                     }
                }
            }
            i++;
        }

        return answer;
    }
}