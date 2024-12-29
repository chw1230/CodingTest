package src.thisisCodingTest.implement;

import java.util.Arrays;
import java.util.Scanner;

public class LRUD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        String[] move = scanner.nextLine().split(" "); // 공백으로 문자열을 잘라 move 문자열 만들기
        int x = 1, y = 1; // 기본 좌표 설정 / 배열 사용이 아니라 정수형 사용!

        int[] dy = {0, 0, -1, 1};
        int[] dx = {-1, 1, 0, 0};
        String[] plans = {"L", "R", "U", "D"};
        // dx,dy를 paln의 인덱스에 맞는 움직임으로 맞게 선언시키기 여기 부분이 리펙토링의 핵심!

        for (String m : move) { // 입력한 값을 배열에 넣은 것을 하나하나 뽑아주고
            int idx = Arrays.asList(plans).indexOf(m); // Arrays를 이용하여 인덱스를 찾아주는 indexOf() 메서드를 활용하여 idx를 구함!
            x += dx[idx]; // 구한 인덱스를 이용하여 x,y에 값 더하기
            y += dy[idx];
            if ((x < 1) || (y < 1) || (N < x) || (N < y)) { // 문제에서 제시한 불가능한 상황
                x += -1 * dx[idx];
                y += (-1) * dy[idx];
                // -1을 곱한 것을 더해주면-> 원상 복구 가능! 0인 경우라면 곱해도 0이라서 문제 없음!
            }
        }
        System.out.println(y + " " + x);
    }
}
