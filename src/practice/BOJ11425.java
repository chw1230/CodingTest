package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ11425 {
    /*
    set으로 중복 잡고 contain 활용해서 있느지 여부 확인 후 cnt 늘려서 답 출력하자
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> s = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        for (int i = 0; i <N; i++) {
            s.add(br.readLine());
        }
        for (int i = 0; i < M ; i++) {
            if (s.contains(br.readLine())) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
