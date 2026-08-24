import java.util.TreeMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        TreeMap<String, Integer> map = new TreeMap<>();

        int i = 0;
        for (String player : players) {
            map.put(player, i++);
        }

        for (String calling : callings) {
            int callIdx = map.get(calling);
            if (callIdx != 0) {
                --callIdx;
            }

            // 바꾸기 과정
            String tmp = players[callIdx];
            players[callIdx] = players[callIdx + 1];
            players[callIdx + 1] = tmp;

            map.put(calling, callIdx);
            map.put(tmp, callIdx + 1);
        }

        return players;
    }
}