class Solution {
     public static String solution(String new_id) {
        String answer = "";

        // step 1 - 소문자로
        new_id = new_id.toLowerCase();

        // step 2 - 특정 기호 빼고 지우기
        new_id = new_id.replaceAll("[^-_.a-z0-9]", "").replaceAll("[.]{2,}", ".").replaceAll("^[.]|[.]$", "");

        // step 3 - 마침표 2번 이상 연속 지우기
        while (new_id.contains("..")) {
            new_id = new_id.replaceAll("..", ".");
        }

        // step 4 - 마침표 끝이면 제거
        if (!new_id.isEmpty() && new_id.charAt(0) == '.') {
            new_id = new_id.substring(1);
        }
        if (!new_id.isEmpty() && new_id.charAt(new_id.length() - 1) == '.') {
            new_id = new_id.substring(0, new_id.length() - 1);
        }

        // step 5 - 빈 문자열이면 "a" 대입
        if (new_id.isEmpty()) {
            new_id = "a";
        }

        // step 6 - new_id의 길이가 16자 이상이면, 16자 부터 제거
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
        }
        if (!new_id.isEmpty() && new_id.charAt(new_id.length() - 1) == '.') {
            new_id = new_id.substring(0, new_id.length() - 1);
        }

        // step 7 - new_id의 길이가 2 이하면
        if (new_id.length() <= 2) {
            while (new_id.length() != 3) {
                String s = String.valueOf(new_id.charAt(new_id.length() - 1));
                new_id = new_id + s;
            }
        }

        answer = new_id;
        System.out.println(answer);
        return answer;
    }
}