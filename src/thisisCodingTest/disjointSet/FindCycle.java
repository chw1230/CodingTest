package thisisCodingTest.DisjointSets;

import java.util.Scanner;

public class FindCycle {

    // 노드의 개수는 최대 100,000개라고 가정
    public static int v, e;
    public static int[] parent = new int[100001]; // 부모 테이블 초기화하기

    private static int findParent(int v) {
        if (v == parent[v]) {
            return v;
        }
        return parent[v] = findParent(parent[v]); // 경로 압축 사용
    }

    private static void unionParent(int a, int b) {
        // 루트를 찾기!
        a = findParent(a);
        b = findParent(b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();

        // idx 노드의 부모를 담는 배열에서 먼저, 부모를 자기 자신으로 초기화하기!
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            // 사이클이 발생한 경우 종료
            if (findParent(a) == findParent(b)) { // 이미 같은 집합이라면 사이클이라고 판정하기
                System.out.println("사이클 발생");
                return;
            } else { // 사이클이 발생하지 않았다면 합집합 연산 수행하기
                unionParent(a, b);
                // 수행 후에는 같은 집합이 됨!!
            }
        }
        System.out.println("싸이클이 발생 X");
    }
}
