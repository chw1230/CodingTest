package thisisCodingTest.DisjointSets;

import java.util.Scanner;

public class DisjointSetUnion {

    // 노드의 개수는 최대 100,000개라고 가정
    public static int v, e;
    public static int[] parent = new int[100001]; // 부모 테이블 초기화하기

    // 특정 원소가 속한 집합을 찾기
    public static int findParent(int x) {
        // 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출하기
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = findParent(parent[x]); // 경로 압축 기법을 사용해서 최악의 경우 오래걸리는 시간을 피하기!
        // 재귀를 여러번 할 필요 없이 연속적으로 최산화하고 반환하고 그 값으로 최신화하기!!
    }

    // 두 원소가 속한 집합을 합치기
    public static void unionParent(int a, int b) {
        // 집합인데 왜 루트가 필요한거지? -> 집합을 하나의 트리로 표현하기 위해서!
        // 그래서 해당 루트의 집합으로 최대한 묶는 것!
        a = findParent(a);
        b = findParent(b);
        // 루트 노드들을 찾아서

        // 작은 숫자일수록 루트 노드!
        if (a < b) { // a보다 b가 크다면
            parent[b] = a; // b의 부모 노드를 a로 바꾸기
        } else {
            parent[a] = b;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt(); // 노드의 개수
        e = sc.nextInt(); // 엣지의 개수

        // idx 노드의 부모를 담는 배열에서 먼저, 부모를 자기 자신으로 초기화하기!
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        // Union(합치기) 연산을 각각 수행 (a 집합과 b 집합을 합치기)
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            unionParent(a, b);
        }

        // 각 원소가 속한 집합 출력하기
        System.out.print("각 원소가 속한 집합: ");
        for (int i = 1; i <= v; i++) {
            System.out.print(findParent(i) + " ");
        }
        System.out.println();

        // 부모 테이블 내용 출력하기
        System.out.print("부모 테이블: ");
        for (int i = 1; i <= v; i++) {
            System.out.print(parent[i] + " ");
        }
        System.out.println();
    }
}
