package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        char[] arr = st.nextToken().toCharArray();

        for (int i = 0; i < 10; i++) {
            map.put(i, 0);
        }

        int max = 0;
        for (char c : arr) {
//            System.out.println(c);
            if (c == '6' || c == '9') {
                if (map.get(6) > map.get(9)) {
                    map.put(9, map.get(9) + 1);
                } else if (map.get(6) < map.get(9)) {
                    map.put(6, map.get(6) + 1);
                } else{
                    map.put(c-'0', map.get(c-'0') + 1);
                }
            } else {
                map.put(c-'0', map.get(c-'0') + 1);
            }

            if (max < map.get(c-'0')) {
                max = map.get(c-'0');
            }
        }
        System.out.println(max);

    }
}
