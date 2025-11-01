import java.util.Arrays;

class Solution {
    public static int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        int i = 0; // 가장 가벼운 사람을 가리키는 idx
        int j = people.length - 1; //  가장 무거운 사람을 가리키는 idx

        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++; // 다음 가벼운 사람으로 넘어가기
            }
            j--; // 덜 무거운 사람으로 넘어가기
            answer++; // case 1 : if 만족해서 가벼운 사람과 무거운 사람 짝지어 지는 경우 / case2 : if 만족하지 않아서 무거운 사람만 보트에 담는 경우
        }

        return answer;
    }
}