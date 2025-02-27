package thisisCodingTest.binarySearch;

import java.util.*;

public class FindingParts2 {
    private static int N;
    private static int M;

    // Set 자료구조를 통해 부품 찾기 풀기
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("N = ");
        N = s.nextInt();
        HashSet<Integer> integers = new HashSet<>();
        for (int i = 0; i < N; i++) {
            integers.add(s.nextInt());
        }

        System.out.print("M = ");
        M = s.nextInt();
        for (int i = 0; i < M; i++) {
            if (integers.contains(s.nextInt())) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
