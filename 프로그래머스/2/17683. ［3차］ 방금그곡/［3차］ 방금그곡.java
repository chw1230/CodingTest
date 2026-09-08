import java.util.ArrayList;

class Solution {
   public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxPlayTime = -1;

        // 기억한 멜로디의 반음들 변환
        m = convert(m);

        for (int i = 0; i < musicinfos.length; i++) {
            String[] musicinfo = musicinfos[i].split(",");
            String start = musicinfo[0];
            String end = musicinfo[1];
            String name = musicinfo[2];
            String melody = convert(musicinfo[3]);

            int playTime = getTime(start, end);

            StringBuilder sb = new StringBuilder();
            while (sb.length() < playTime) {
                sb.append(melody); // sb에 송출된 멜로리를 송출시간보다 길게 저장
            }

            // 실제 송출된 멜로디
            String play = sb.substring(0, playTime);

            // 송출된 멜로디가 기억한 멜로디를 가지고 있고, 재생된 시간이 같은 경우에 더 길게 재생된 음악 제목을 반환
            if (play.contains(m) && (playTime > maxPlayTime)) {
                maxPlayTime = playTime;
                answer = name;
            }
        }

        return answer;
    }

    private int getTime(String start, String end) {
        String[] s = start.split(":");
        String[] e = end.split(":");

        int startMin = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
        int endMin = Integer.parseInt(e[0]) * 60 + Integer.parseInt(e[1]);

        return endMin - startMin;
    }

    // 반음 문자들을 소문자로 표기 (예: "C#" -> "c")
    private String convert(String melody) {
        ArrayList<Character> melodyConverted = new ArrayList<>();

        for (int i = 0; i < melody.length(); i++) {
            char ch = melody.charAt(i);

            if (i + 1 < melody.length() && melody.charAt(i + 1) == '#') {
                ch = Character.toLowerCase(ch); // 소문자로 변환하기
                i++;
            }
            melodyConverted.add(ch);
        }

        StringBuilder sb = new StringBuilder();
        for (char c : melodyConverted) {
            sb.append(c);
        }
        return sb.toString();
    }
}