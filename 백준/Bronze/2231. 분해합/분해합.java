import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /* 한 번에 못 푼 이유 -> for문으로 해결하고자 해서 + 입력된 숫자의 길이(length)를 이용해 푸려고 계속 시도해서*/
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int r = 0;

        for (int i = 1; i < n; i++) {
            int sum = i;
            int tmp = i;
            while (tmp > 0) {
                sum += tmp % 10;
                tmp /= 10;
            }
            if (sum == n) {
                r = i;
                break;
            }
        }
        System.out.println(r);
    }
}