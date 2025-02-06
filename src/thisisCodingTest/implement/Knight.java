package thisisCodingTest.implement;

import java.util.Scanner;

public class Knight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        // 입력을 통해서 나이트의 처음위치 구하기
        int row = input.charAt(1) - '0';
        int column = input.charAt(0) - 'a' + 1; // 알파벳 숫자로 바꾸기

        // 나이트가 이동할 수 있는 8가지 방향 정의 -> 짝을 지어서 정의 시킴!
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

        // 8가지 방향에 대하여 각 위치로 이동이 가능한지 확인
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            // 이동하고자 하는 위치 확인
            int nextRow = row + dx[i];
            int nextColumn = column + dy[i];
            // 해당 위치로 이동이 가능하다면 카운트 증가
            if (nextRow >= 1 && nextRow <= 8 && nextColumn >= 1 && nextColumn <= 8) {
                cnt += 1;
            }
        }
        System.out.println("cnt = " + cnt);
    }
}