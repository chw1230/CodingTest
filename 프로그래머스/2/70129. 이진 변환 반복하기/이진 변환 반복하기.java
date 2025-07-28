class Solution {
    public static int[] solution(String s) {
        int[] answer = new int[2];
        while (!s.equals("1")) {
            String str = "";
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    answer[1]++;
                } else {
                    str += s.charAt(i);
                }
            }
            int len = str.length();

            str = "";
            while (len > 0) {
                str += len % 2;
                len /= 2;
            }
            s = str;
            answer[0]++;
        }
        return answer;
    }
}