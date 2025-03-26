package thisisCodingTest.Greedy.ch11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 모험가 길드 문제 풀기
최대 그룹 수의 값을 구하기 위해서 오름차순 정렬후(함께할 인원이 적은 인원 부터 그룹을 만드는게 유리하기 때문에)
그룹에 포함된 인원이 공포도보다 크거나 같을 때 그룹을 형성할 수 있음을 이용하기
 */
public class AdventurerGuild {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }
        Arrays.sort(arr); // 오름차순 정렬

        int group = 0; // 형성된 그룹 수를 의미
        int cnt = 0; // 그룹에 들어간 사람의 수
        for (Integer i : arr) {
            cnt++;
            if (cnt >= i) {
                group++; // 그룹을 형성을 확정하고 증가
                cnt = 0;  // 그룹에 들어간 사람을 0명으로 초기화하는 과정
            }
        }
        System.out.println(group);
    }

}
