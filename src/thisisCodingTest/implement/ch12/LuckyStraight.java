package thisisCodingTest.implement.ch12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LuckyStraight {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int len = s.length();
        int left = 0;
        int right = 0;

        for (int i = 0; i < len/2 ; i++) {
            left += s.charAt(i) - '0';
        }
        for (int i = len/2; i < len ; i++) {
            right += s.charAt(i) - '0';
        }

        if (left == right) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }
}
