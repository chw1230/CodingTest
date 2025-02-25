package thisisCodingTest.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ31403 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        System.out.println(a + b - c);

        // 사용 시기 명확히 알아두기!!!
        System.out.println(Integer.parseInt(Integer.toString(a)+Integer.toString(b))-c);
    }
}
