package practice;

import java.util.Scanner;

public class BOJ29699 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String str = "WelcomeToSMUPC";
        num = num % str.length();
        if (num == 0){
            System.out.println(str.substring(str.length()-1,str.length()));
        }else{
            System.out.println(str.substring(num-1,num));
        }

    }
}
