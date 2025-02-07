package thisisCodingTest.DFS_BFS;

import java.util.Scanner;


public class IceBeverage {
    private static int n,m;
    private static int[][] graph = new int[1000][1000];

    public static boolean dfs(int i, int j){ // 배열 인덱스를 전달하며 시작위치 전달

        if (i <= -1 || i >= n || j <= -1 || j >= m) { // 범위 제한 하기
            return false;
        }

        if (graph[i][j] == 0) {  // 방문 한 적 없으면
            graph[i][j] = 1; // 방문 남기기 (0 -> 1)
            // 재귀적으로
            dfs(i-1,j);  // 상
            dfs(i,j-1);  // 좌
            dfs(i+1,j);  // 하
            dfs(i,j+1);  // 우
            return true;
        }
        return false;

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // n m 형식으로 입력 받기
        n = scanner.nextInt();
        m = scanner.nextInt();
        scanner.nextLine(); // 버퍼 없애기

        // 2차 비열 입력 받기
        for (int i = 0; i < n; i++) {
            String string = scanner.nextLine(); // 입력되는 값을 고려하여 문자열 한줄로 입력받기
            for (int j = 0; j < m; j++) {
                graph[i][j] = string.charAt(j) - '0'; // 입력된 한줄 문자열을 하나씩 떼서 문자에서 숫자로 바꾸기
            }
        }

        int cnt = 0; // 개수

        // 0으로 연결된 부분들 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(dfs(i,j)){ // true 면
                    cnt++; // 개수 늘리기
                }
            }
        }
        System.out.println(cnt);
    }
}