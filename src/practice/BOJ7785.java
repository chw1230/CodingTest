package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ7785 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> m = new TreeMap<>(Collections.reverseOrder()); // 사전 역순 출력을 위한 기초작업!!
        StringTokenizer st1 = new StringTokenizer(br.readLine());


        // 데이터 적립
        int N = Integer.parseInt(st1.nextToken());
        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            String name = st2.nextToken();
            String state = st2.nextToken();
            m.put(name, state); // 값 넣기
            if (state.equals("leave")) {
                m.remove(name);
            }
        }

        // 출력
        for (String string : m.keySet()) {
            System.out.println(string);
        }


    }
}
