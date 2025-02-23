package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ1427 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Integer[] c = new Integer[s.length()];

        for (int i = 0; i < c.length; i++) {
            c[i] = s.charAt(i)-'0';
        }
        Arrays.sort(c, Collections.reverseOrder());
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i]);
        }
    }
}
