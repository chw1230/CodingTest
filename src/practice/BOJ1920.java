package src.practice;

import java.io.IOException;
import java.util.*;

public class BOJ1920 {

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int a = s.nextInt();
            set.add(a);
        }

        int m = s.nextInt();
        StringBuilder sb = new StringBuilder(); // 결과 저장

        for (int i = 0; i < m; i++) {
            int num = s.nextInt();
            if (set.contains(num)) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }

        System.out.println(sb); // 결과 한 번에 출력
    }
}
