package practice;

import java.util.Scanner;

public class BOJ1152 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine().trim();
        if (str.equals("")){
            System.out.println(0);
        }else{
            String[] arr = str.split(" ");
            System.out.println(arr.length);
        }
    }
}
