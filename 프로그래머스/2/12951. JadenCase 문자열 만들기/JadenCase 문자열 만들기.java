class Solution {
    public String solution(String s) {
        String answer = "";

        boolean startWord = true; // 단어 시작

        for (char c : s.toCharArray()) {
            if ( c == ' ') {
                answer = answer + c;
                startWord = true; // 단어 시작
                // 공백이 연속으로 와도 단어 시작 상태를 유지만 함!
            } else {
                if (startWord) {
                    answer = answer + Character.toUpperCase(c);
                } else {
                    answer = answer + Character.toLowerCase(c);
                }
                startWord = false;
            }
        }

        return answer;
    }
}