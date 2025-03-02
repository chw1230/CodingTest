package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 1;
        int num = Integer.parseInt(st.nextToken());
        if (num== 1) {
            for (int i = 2; i < 9; i++) {
                if (i == Integer.parseInt(st.nextToken())) {
                    cnt++;
                }
            }
            if (cnt == 8) {
                System.out.println("ascending");
                return;
            }
        }else if (num== 8){
            for (int i = 7; i > 0; i--) {
                if (i == Integer.parseInt(st.nextToken())) {
                    cnt++;
                }
            }
            if (cnt == 8) {
                System.out.println("descending");
                return;
            }
        }
        System.out.println("mixed");
    }
}
