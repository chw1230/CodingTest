package thisisCodingTest.sort;

import java.util.Arrays;
import java.util.Scanner;

public class ShellSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("정렬할 숫자의 수를 입력: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("수 입력 : ");
            arr[i] = scanner.nextInt();
        }

        System.out.print("Before sort : ");
        System.out.println(Arrays.toString(arr));

        shellSort(arr);
        System.out.print("After shell sort : ");
        System.out.println(Arrays.toString(arr));

    }

    private static void shellSort(int[] arr) {
        int len = arr.length;

        for (int gap = len / 2; 0 < gap; gap = gap / 2) {
            for (int i = gap; i < len; i++) {
                for (int j = i - gap; 0 <= j && arr[j+gap] < arr[j]; j = j - gap) { // gap 만큼의 격차를 가진 인덱스 값을 비교
                    // A --gap-- B
                    // i와 gap의 차이가 0보다 커야하고, 좌측에 있는 값이 더 큰 경우(정렬이 안되어 있는 경우) 바꾸기
                    // 그리고 j의 값은 또 gap 만큼 작는 인덱스와 비교하게 하기 위해 gap 만큼을 빼주기
                    int tmp = arr[j];
                    arr[j] = arr[j + gap];
                    arr[j + gap] = tmp;
                }
            }
        }

    }


}
