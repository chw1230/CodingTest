import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int idx = s.indexOf('*');
        int sum = 0;

        for (int i = 0; i < 13; i++) {
            if (i == idx) {
                continue;
            }
            int num = s.charAt(i) - '0';
            sum += (i % 2 == 0) ? num : num * 3; // 짝은 곱하기 3
        }

        for (int x = 0; x <= 9; x++) {
            int a = sum + ((idx % 2 == 0) ? x : x * 3);
            if (a % 10 == 0) {
                System.out.println(x);
                break;
            }
        }
    }
}