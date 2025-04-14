package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        int gcd = getGcd(n1, n2);
        System.out.println(gcd);
        System.out.println(n1*n2/gcd);

    }

    private static int getGcd(int n1, int n2) {
        while (n2 != 0){
            int tmp = n1 % n2;
            n1 = n2;
            n2 = tmp;
        }
        return n1;
    }
}
