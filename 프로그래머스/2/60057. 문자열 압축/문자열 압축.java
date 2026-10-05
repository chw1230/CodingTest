class Solution {
    public int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length() / 2; i++) { // i => 단어를 묶는 개수
            StringBuilder c = new StringBuilder();
            String token = s.substring(0, i); // i개수 만큼 단어를 묶었을 때의 단어
            int cnt = 1; // 단어 세트의 개수

            // 묶은 글자들 이후에 있는 글자들이  묶은 단어와 같은지 확인하는 작업하기
            for (int j = i; j < s.length(); j += i) { // i(단어의 개수 만큼) 늘어나야 함!

                // 최대 문자의 길이를 벗어나지 않도록 문자열의 길이와 비교했을 때 작읍 값을 선택하기
                int endIndx = Math.min(j + i, s.length());
                String str = s.substring(j, endIndx);

                if (token.equals(str)) {
                    cnt++;
                } else {
                    // 다르면
                    if (cnt > 1) { // cnt 1보다 크다는 것은 이미 반복된 세트가 있다는 거
                        // 반복된 수 만큼 숫ㅈ자를 추가
                        c.append(cnt);
                    }
                    // 단어 세트 추가
                    c.append(token);
                    token = str;
                    cnt = 1; // 초기화 - token과 str이 다른건 규칙이 틀어진 거니까 초기화
                }
            }
            // 남은 문자열 처리
            if (cnt > 1) { // 해당 부분은 token으로 문장을 딱 표현할 수 있을 때를 의미 숫자+token 형태!
                c.append(cnt);
            }
            c.append(token);

            // 가장 짧은 경우를 저장
            answer = Math.min(answer, c.length());
        }

        return answer;
    }
}