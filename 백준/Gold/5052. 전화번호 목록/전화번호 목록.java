import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    // Trie 공부 해서 Trie로 풀어보기

    public static class Node {
        Map<Character, Node> child = new HashMap<>(); // 자식 노드는 (문자, 노드)를 가지도록하기
        boolean end; // 단어의 마지막을 의미하는 변수

        Node(){};

        public void insert(String str) {
            Node node = this; // trie의 출발 루트 노드 아무 것도 없음
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                node.child.putIfAbsent(c, new Node()); // 자식 노드 비어 있으면 새로 만들어서 연결
                node = node.child.get(c); // 연결한 노드로 최신화

                if (i == str.length() - 1) { // 마지막 문자인 경우에
                    node.end = true; // 마지막이라는 신호 true하기
                    return;
                }
            }
        }

        public boolean contain(String str) {
            Node node = this;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                Node child = node.child.get(c);
                if ( child == null ) { // 찾는 문자의 다음 노드가 null 이라면
                    return false;
                }
                node = child; // 노드를 더 깊은 노드로 최신화
            }

            // 여기까지 오면 마지막 문자열의 노드로 오게됨!
            if(node.end) { // 우리가 생성할 때 마지막이면 true가 도도록 했음! 그래서 true 일때
                if(node.child.isEmpty()) { // 자식이 비어 있다면 그냥 그 단어 이후에 뭐가 추가된 적이 없는 것! 그러면 유일한 것이니까 false 반환
                    return false;
                }
            }
            // 하지만 마지막 신호가 true인데 자기 뒤에 무언가 있다? 그러면 유일하게 하니라 접두 부분이 다른 부분과 겹친다는 것!!
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        A : for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            String s[] = new String[N];
            Node node = new Node();

            for (int j = 0; j < N; j++) {
                String str = br.readLine();
                node.insert(str);
                s[j] = str;
            }

            for (String string : s) {
                if ( node.contain(string) ) {
                    System.out.println("NO");
                    continue A;
                }
            }
            System.out.println("YES");
        }
    }
}