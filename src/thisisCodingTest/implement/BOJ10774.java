package src.thisisCodingTest.implement;

import java.util.Arrays;
import java.util.Scanner;


public class BOJ10774 {
    public static int J;
    public static int A;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        J = scanner.nextInt(); // 저지의 수
        scanner.nextLine();
        A = scanner.nextInt(); // 학생의 수
        scanner.nextLine();
        int cnt = 0; // 가능한 경우

        String[] size = new String[J];
        boolean[] visited = new boolean[J];

        for (int i = 0; i < J; i++) {
            size[i] = scanner.nextLine(); // 재고 입력 받기
        }
        // System.out.println(Arrays.toString(size));

        for (int i = 0; i < A; i++) {
            String[] input = scanner.nextLine().split(" ");
            String wantSize = input[0];
            int num = Integer.parseInt(input[1]);

            int hashWantSize = hashSize(wantSize);
            if (!visited[num-1]) { // 방문 확인
                int hashSize = hashSize(size[num-1]);
                if (hashSize >= hashWantSize) {
                    visited[num-1] = true; // 방문 처리
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    private static int hashSize(String wantSize) {
        if (wantSize.equals("S")) {
            return 0;
        } else if (wantSize.equals("M")) {
            return 1;
        } else {
            return 2;
        }
    }
}
