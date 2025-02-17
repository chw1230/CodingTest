package thisisCodingTest.Greedy;

import java.io.*;
import java.util.Arrays;

public class BOJ2217 {
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 개수 입력 받기
        int n = Integer.parseInt(br.readLine());
        int[] weight = new int[n];
        int[] maxWeight = new int[n];

        // 개수 만큼 받아서 리스트에 넣기
        for (int i = 0; i < weight.length; i++) {
            weight[i] = Integer.parseInt(br.readLine());
        }
        // 이때 리스트 오름차순으로 정렬하기
        Arrays.sort(weight);

        // 작은수 * 로프수 한 값을 리스트에 또 넣는다
        // 그리고 반복문을 써서 그 다음 작은 수 * (로프수 - i) 도 리스트에 넣는다
        // 이런식으로 끝까지 한뒤에 들을 수 있는 무게를 내림차순해서 가장 큰 수를 출력하면 됨
        for (int i = 0; i < maxWeight.length; i++) {
            maxWeight[i] = weight[i] * (maxWeight.length - i);
        }
        Arrays.sort(maxWeight);
        System.out.println(maxWeight[maxWeight.length - 1]);
    }
}
