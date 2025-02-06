package thisisCodingTest.implement;
import java.util.Scanner;

public class BOJ13458 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] Ai = new int[N];
        for (int i = 0; i < Ai.length; i++) {
            Ai[i] = scanner.nextInt();
            
        }
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        long cnt = 0;
        for (int i = 0; i < Ai.length; i++) {
            if((Ai[i] - B) <= 0){
                cnt += 1;
            }else {
                cnt += 1;
                int k = Ai[i] - B;
                cnt += k/C;
                if(k%C > 0){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

}
