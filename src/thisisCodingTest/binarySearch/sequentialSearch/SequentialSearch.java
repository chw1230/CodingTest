package thisisCodingTest.binarySearch.sequentialSearch;

import java.util.Scanner;

public class SequentialSearch {
    // 순차 탐색 코드 구현
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("찾을 문자열 입력");
        String str = s.next();
        s.nextLine();

        System.out.println("생성할 원소 개수 만큼의 문자열을 공백을 두고 입력하기");
        String[] strArr = s.nextLine().split(" ");

        int cnt = 1;
        for (String string : strArr) {
            if (string.equals(str)) {
                System.out.println("cnt = " + cnt);
                break;
            }cnt++;
        }
    }
}
