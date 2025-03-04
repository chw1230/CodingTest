package thisisCodingTest.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ11650 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];


        for (int i = 0; i < arr.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2) {
                if (a1[0] == a2[0]) { // an[0]은 첫번째 자리를 의미함 -> 첫째 자리 숫자가 같으면
                    return a1[1] - a2[1]; // an{1]은 두번째 자리를 의미함 -> 둘째 자리 숫자가 비교
                }else { // 첫째 자리 숫자가 다르면 첫째 자리 숫자 비교
                    return a1[0] - a2[0];
                }
            }
        });

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }
}
