import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int position;
        int priority;

        public Node(int position, int priority) {
            this.position = position;
            this.priority = priority;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCase = Integer.parseInt(st.nextToken());

        for (int i = 0; i < testCase; i++) {
            Queue<Node> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            int document = Integer.parseInt(st.nextToken());
            int position = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < document; j++) { // 큐 만들기
                q.add(new Node(j, Integer.parseInt(st.nextToken()))); // 큐에 (0,1), (1,1) - - - , (5,1)  이런식으로 들어감!
            }

            int cnt = 0;
            while (!q.isEmpty()) {
                Node a = q.poll(); // 일단 뽑기
                boolean ok = false;
                for ( Node node : q) {
                    if (a.priority < node.priority) { // 뽑은 것 보다 큰 우선순위를 가진 큐 속 노드를 만나면 
                        ok = true; // 다시 삽입 하는 신호 활성화
                        break; // 추가적으로 더 큰수를 만나서 2번 작동하는 것을 막기 위해서 바로 정지
                    }
                }
                
                if (ok) { // 신호 활성화 했다면
                    q.add(a); // 큐에다가 아까 뺀 수를 다시 넣어주기
                } else{ // 신호 없다면 
                    cnt++; // poll한 횟수를 측정하는 cnt 값(=> 출력 순서와 동일) 증가
                    if (a.position == position) { // 뽑은 값이  원래 뽑으려던 목적이였다면 
                        System.out.println(cnt);
                        break;
                    }
                }
            }
        }
    }
}