import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 포켓몬 수
        int M = Integer.parseInt(st.nextToken()); // 문제의 개수

        Map<String, Integer> map = new HashMap<>(); // 이름, 도감에서의 순서
        String name[] = new String[N];
        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            map.put(s, i);
            name[i-1] = s;
        }

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            if (map.containsKey(input)) {
                System.out.println(map.get(input));
            } else {
                int idx = Integer.parseInt(input);
                System.out.println(name[idx-1]);
            }
        }
    }
}