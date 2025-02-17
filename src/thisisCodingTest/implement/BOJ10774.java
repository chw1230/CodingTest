package thisisCodingTest.implement;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ10774 {
    public static int J;
    public static int A;


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        J = s.nextInt();
        A = s.nextInt();
        s.nextLine(); // 버퍼 삭제

        String[] size = new String[J]; // 재고 사이즈 배열 입력 받기
        for (int i = 0; i < size.length; i++) {
            size[i] = s.nextLine();
        }

        int cnt = 0;
        boolean[] visited = new boolean[J];
        for (int i = 0; i < A; i++) {
            String[] want = s.nextLine().split(" ");  // 공백을 사이에 둔 입력 배열화 하기
            String wantSize = want[0];
            int wantNum = Integer.parseInt(want[1]);

            if (!visited[wantNum-1]) { // 원하는 숫자의 저지를 가져간 사람이 있는지 방문 확인 -> 방문 없는 경우에 코드 실행
                if (hashSize(wantSize) <= hashSize(size[wantNum-1])) { // 원하는 사이즈보다 재고 사이즈가 더 큰 경우에 지급!
                    visited[wantNum-1] = true; // 방문 처리
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    private static int hashSize(String s) {
        if (s.equals("S")) {
            return 0;
        } else if (s.equals("M")) {
            return 1;
        }else{
            return 2;
        }
    }
}
