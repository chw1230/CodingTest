import java.util.HashMap;

class Solution {
     public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        System.out.println(map);

        int idx = 0;
        for (String[] strings : photo) {
            int sum = 0;
            for (String s : strings) {
                if (map.containsKey(s)) {
                    sum += map.get(s);
                }
            }
            answer[idx++] = sum;
        }
        return answer;
    }
}