package thisisCodingTest.DFS_BFS;

import java.util.ArrayList;

public class DFS {

    public static boolean[] visited = new boolean[9]; // 노드 방문 처리를 담을 배열 생성
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    // Integer 타입의 요소를 담을 수 있는 ArrayList를 요소로 가지는 또 다른 ArrayList를 의미

    // DFS 함수 정의
    public static void dfs(int x) {
        visited[x] = true; // 현재 노드를 방문 처리하기
        System.out.print(x + " ");
        // 현재 노드와 연결된 다른 노드를 재귀적으로 방문
        for (int i = 0; i < graph.get(x).size(); i++) {  //  노드 x에 연결된 노드의 개수 만큼 반복
            int y = graph.get(x).get(i);  // y에 x노드와 연결된 노드의 '값'을 저장
            if (!visited[y]) dfs(y);  // 노드 Y에 방문 한 적없는 경우에만 노드 Y에서의 DFS 함수 실행하기 -> 재귀적!
        }
        /*
        graph.get(x)의 의미 x 번째 arrayList에 있는 arraylsit를 의미함!
        for (Integer n : graph.get(x)) {
            if(!visited[n]) dfs(n);
        }
         */
    }



    public static void main(String[] args) {
        // 그래프 초기화
        for (int i = 0; i < 9; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // 노드 1에 연결된 노드 정보 저장
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);

        // 노드 2에 연결된 노드 정보 저장
        graph.get(2).add(1);
        graph.get(2).add(7);

        // 노드 3에 연결된 노드 정보 저장
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);

        // 노드 4에 연결된 노드 정보 저장
        graph.get(4).add(3);
        graph.get(4).add(5);

        // 노드 5에 연결된 노드 정보 저장
        graph.get(5).add(3);
        graph.get(5).add(4);

        // 노드 6에 연결된 노드 정보 저장
        graph.get(6).add(7);

        // 노드 7에 연결된 노드 정보 저장
        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);

        // 노드 8에 연결된 노드 정보 저장
        graph.get(8).add(1);
        graph.get(8).add(7);

        System.out.println(graph);
        System.out.print("노드의 탐색 순서: ");
        dfs(1); // 1을 시작 노드로 설정
    }
}
