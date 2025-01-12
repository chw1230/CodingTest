package thisisCodingTest.Greedy;

import java.util.Arrays;
import java.util.Scanner;

// 큰 수의 법칙
public class LawOfLargeNumbers {
    public static void main(String[] args) {
        int n,m,k;
        Scanner scanner = new Scanner(System.in);
        n =  scanner.nextInt(); // 배열의 크기
        m =  scanner.nextInt();
        k =  scanner.nextInt();

        int[] arr = new int[n];
        // 배열 입력받기
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        // 배열 정렬하기 - 오름차순 정렬
        Arrays.sort(arr);
        /*내 코드
        int sum = 0,cnt = 0; // 합과 가장큰 수가 더해지는 횟수(cnt) 선언
        for (int i = 0; i < M; i++) {
            if(K == cnt){ // 문제에서 제공되는 더해지는 횟수와 동일한 경우
                sum += arr[arr.length-2]; // 2번째로 큰 수 더하기
                cnt = 0; // 초기화
            }else { // 아닌 경우
                sum += arr[arr.length - 1]; // 가장 큰 수 더하기
                cnt++; // 하나씩 늘려주기
            }
        }
         */
        int first = arr[n - 1]; // 가장 큰 수
        int second = arr[n - 2]; // 두 번째로 큰 수

        // 가장 큰 수가 더해지는 횟수 계산
        int cnt = (m / (k + 1)) * k + m % (k + 1);

        int result = 0;
        result += cnt * first; // 가장 큰 수 더하기
        result += (m - cnt) * second; // 두 번째로 큰 수 더하기
        System.out.println(result);
    }
}
