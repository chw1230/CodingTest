import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String s = br.readLine();
        long sum = 0;
        long pow = 1;

        for ( int i  = 0; i < L ; i++ ) {
            sum = ( sum + (s.charAt(i) - 'a' + 1) * pow) % 1234567891;
            pow = (pow * 31) % 1234567891; // pow에 계속 31을 곱해주기 -> 즉시 나눠서 오류 없애기
        }
        System.out.println(sum);
    }
}