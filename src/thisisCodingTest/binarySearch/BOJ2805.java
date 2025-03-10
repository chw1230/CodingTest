package thisisCodingTest.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] tree = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tree);

        BinarySearch(0, tree[N-1],tree,M);
    }

    private static void BinarySearch(int start, int end,int[] tree,int M) {
        int r = 0;
        while (start <= end) {
            long sum = 0;
            int mid = (start + end) / 2;
            for (int i : tree) {
                if (i > mid) {
                    sum += i - mid;
                }
            }

            if (M <= sum) { // 적어도 M미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최댓값 -> 의미 파악을 잘못했음!!!
                r = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(r);
    }
}
