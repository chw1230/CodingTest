package src.practice;

import java.util.Scanner;

public class BOJ2018 {
    public static void main(String[] args) {
        // 투포인터를 잘 이동해 가면서 시간복잡도 작게 가져갈 수 있음
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int s_idx = 1, e_idx = 1;
        int cnt = 1;
        int sum = 1;
        while (e_idx != N) {
            if (sum == N) {
                cnt++;
                e_idx++;
                sum += e_idx;
            } else if (sum > N) {
                sum -= s_idx;
                s_idx++;
            } else {
                e_idx++;
                sum += e_idx;
            }
        }
        System.out.println(cnt);
    }
}
