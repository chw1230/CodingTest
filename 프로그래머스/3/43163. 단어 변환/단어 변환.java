import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
       public static int solution(String begin, String target, String[] words) {
        if (!List.of(words).contains(target)) { // 단어 리스트에 타겟이 없다면
            return 0; // 바로 0 반환
        }

        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[words.length]; // 단어 배열에서 이미 방문한 단어를 표시

        q.add(new Node(begin, 0)); // 시작 단어를 넣기

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.str.equals(target)) { // 단어가 타겟과 같은 경우
                return node.n;
            } else { // 타겟과 다르면 이동
                for (int i = 0; i < words.length; i++) {
                    if (!visited[i]) {
                        if (check(node.str, words[i])) {
                            visited[i] = true;
                            q.add(new Node(words[i], node.n + 1));
                        }
                    }
                }
            }
        }

        return 0;
    }

    private static boolean check(String nodeStr, String wordStr) {
        int cnt = 0;

        // 무조건 길이는 동일 동일한 인덱스의 글자가 다른 것을 확인
        for (int i = 0; i < nodeStr.length(); i++) {
            if (nodeStr.charAt(i) != wordStr.charAt(i)) {
                cnt++;
            }
        }

        if (cnt == 1) {
            return true;
        }
        return false;
    }

    static class Node {
        String str;
        int n;

        Node(String str, int n) {
            this.str = str;
            this.n = n;
        }
    }
}