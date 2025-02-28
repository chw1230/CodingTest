package src.thisisCodingTest.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ10816 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st1.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
            // 맵에 일단 값을 넣은 건데 키는 당연히 num로 넣고 value 값을 넣어애 하는데
            // 조건문으로 cnt++ 해서 값을 넘기지 말고 map의 메서드를 활용하여
            // getOrDefault(num, 0) -> value가 비었으면 0, 값이 있으면 value에 있는 값을 빼오는 메서드에 1을 더하는 방식 사용
            // 그러면 없어서 0이면 새로 들어가니까 1이 될테고, 있었으면 있었던 value에 1을 더하는 형식으로 값을 바꿀 수 있음
            // getOrDefault(num, 0) 이걸 바로 기억해 내지 못해서 아쉽다 ㅜㅜ
        }

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st2.nextToken());
            sb.append(map.getOrDefault(num, 0)).append(" ");
            // 여기서도 이것을 활용할 생각을 하지 못해서 시간 초과 발생함!
            // 당연히 contains으로 찾으려면 시간 엄청 오래 걸리자나 ㅜㅜ
        }
        System.out.println(sb);
    }
}
