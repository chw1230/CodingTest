import java.util.Arrays;
class Solution {
    public static String solution(int[] numbers) {
        String answer = "";

        String[] str = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }

        // 앞자리가 가장큰 수를 먼저 찾기!
        // 910, 109 비교
        // 내림차순을 원하니까 b부터 오는 경우를 먼저 앞에다 적기!
        Arrays.sort(str, (a, b) -> (b + a).compareTo(a + b));

         // 0000 으로 나열되는 경우에는 0만 반환되도록!
        if (str[0].equals("0")) {
            return "0";
        }
        
        for (String s : str) {
            answer += s;
        }

        return answer;
    }
}