package thisisCodingTest.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ10989 {

    // 카운팅 정렬방식 사용!!! -> 이거를 쓸때 시간을 더 줄일 수 있는 방법
    // 1. max를 구하는 과정 통해 count 배열의 크기를 정하지 말고 문제에서 주어진 숫자입력 최대 범위를 가지고 count 배열을 만들어 버리기
    // 2. BufferedReader를 통해 시간 줄이기
    // 3. StringBuilder를 통해 시간 줄이기  -> 이거 생각 못했음 ㅜㅜ
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 개수 입력 받기
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];

        int[] cnt = new int[10001];  // 입력된 배열에서 최대값을 구해서 배열의 크기를 제한하는 것이 아니라
        // 문제에서 제공된 배열의 max값을 이용하여 구하기 -> 최대값을 구하는데 시간 사용 X
        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(br.readLine());
            cnt[num[i]]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 10001; i++) {
            for (int j = 0; j < cnt[i]; j++) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}
