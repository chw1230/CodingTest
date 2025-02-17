package src.thisisCodingTest.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ7568 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 개수 입력 받기
        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer>[] arr = new LinkedList[n];



        // 초기화
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new LinkedList<>();
        }

        for (int i = 0; i < arr.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i].add(x);
            arr[i].add(y);
        }
        // System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            int cnt = 1;
            for (int j = 0; j < arr.length; j++) {
                if ((arr[i].get(0) < arr[j].get(0)) && (arr[i].get(1) < arr[j].get(1))) {
                    cnt++;
                }
            }
            arr[i].add(cnt);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i].get(2)+" ");
        }
    }
}
