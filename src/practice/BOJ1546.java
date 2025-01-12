package practice;

import java.util.Scanner;

public class BOJ1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n]; // 배열을 이용하기!!!!
        double max = 0;
        double sum = 0;

        // max 구하기
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
            if(max <= array[i]){
                max = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            sum += array[i]/max*100;
        }
        System.out.println(sum/n);
    }
}
