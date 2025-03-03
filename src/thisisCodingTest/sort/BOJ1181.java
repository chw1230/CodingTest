package thisisCodingTest.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> strings = new HashSet<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            // set으로 중복 날리기!!
            strings.add(br.readLine());
        }

        // 정렬을 위해서 set을 배열로 바꾸기!
        String[] array = strings.toArray(new String[0]);

        // 정렬 기준 정하기
        Arrays.sort(array, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() == s2.length()) { // 길이가 같은 경우 사전 순 정렬
                    return s1.compareTo(s2);
                    // String의 compareTo() 메서드는 두 문자열이 사전순으로 동일한 경우 0 값을 반환하는 것을 이용!!
                    } else { // 길이가 다르면 길이가 짧은 순서로 정렬
                    return s1.length() - s2.length();
                }
            }
        });

        // 결과 출력
        for (String word : array) {
            System.out.println(word);
        }
    }
    /*
     * 생각의 흐흠
     * set으로 중복 없애자 -> 정렬하자 -> 그러면 배열로 바꿔야 하니까 set을 배열로 바꾸자 -> 정렬 기준을 만들어 배열을 정렬하자
     * 문제에서 힘들 었던 것
    * 정렬 기준 정하기 -> 연습 많이 하자! 헷갈리는 부분이 많았음! -> 복습 -> 백준 풀기
     */
}
