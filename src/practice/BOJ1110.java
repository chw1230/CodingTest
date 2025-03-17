package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int num = n,cnt = 0;

        while (true){
            int a = n /10;
            int b = n % 10;
            int sum = a+b;
            n = b * 10 + sum % 10;
            cnt++;
            if (n == num) {
                break;
            }
        }
        System.out.println(cnt);
    }
}
