import java.util.Scanner;

public class BOJ11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String numStr = sc.nextLine();
        char[] arr = numStr.toCharArray();
        int sum = 0;
        // 아스키코드 이용
        for(int i=0; i<n; i++) {
            sum += arr[i] - '0';
        }
        System.out.println(sum);
    }
}