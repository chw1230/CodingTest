package thisisCodingTest.implement;

import java.util.Scanner;

public class BOJ1193 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();
        int i = 1;
        while(X > 0){
            X -= i;
            i++;
            // 여기서 나온 (i - 1)는 분모나 분자의 시작임! ex> 1/3이거나 3/1 이란 뜻!
            // 여기서 나온 (X + i - 1)는 묶음에서의 번째 수를 의미함!
        }
        if((i-1) % 2 == 0){
            // 분모 시작
            System.out.println( ((X + i - 1)) +"/"+ (i - (X + i - 1)) );
        }else{
            // 분자 시작
            System.out.println( (i - (X + i - 1)) +"/"+ ((X + i - 1)) );
        }
    }
}
