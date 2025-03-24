package thisisCodingTest.DFS_BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static boolean[] visited = new boolean[9]; // 노드 방문 처리를 담을 배열 생성
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    // BFS 함수 정의
    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);  // 큐에 다가 시작 노드 넣기!
        visited[start] = true; // 현재 노드를 방문 처리

        while(!q.isEmpty()) { // 큐가 빌 때까지 반복
            int x = q.poll(); // 큐에서 하나의 원소를 뽑아 출력
            System.out.print(x + " "); // 순서를 위해 출력

            // 해당 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
            for(int i = 0; i < graph.get(x).size(); i++) { //  노드 x에 연결된 노드의 개수 만큼 반복
                int y = graph.get(x).get(i); // y에 x노드와 연결된 노드의 '값'을 저장
                if(!visited[y]) { // 노드 Y에 방문 한 적이 없는 경우
                    q.offer(y);  //큐에 노드 추가
                    visited[y] = true;  // 노드 방문 처리 진행
                }
            }
        }
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

        System.out.print("노드의 탐색 순서: ");
        bfs(1); // 1을 시작 노드로 설정
    }
}
