package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2720 {
    private static int[] cost = {25, 10, 5, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int[] change = new int[4];
            int num = Integer.parseInt(br.readLine());
            for (int j = 0; j < change.length; j++) {
                change[j] = num / cost[j];
                num = num % cost[j];
            }
            for (int i1 : change) {
                System.out.print(i1 +" ");
            }
        }


    }
}
