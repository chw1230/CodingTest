import java.util.*;

public class Solution {
    static int[] moveX = new int[]{0, 0, -1, 1};
    static int[] moveY = new int[]{-1, 1, 0, 0};

    public static int solution(String[] storage, String[] requests) {
        int n = storage.length;
        int m = storage[0].length();

        // 패딩을 넣어보기
        char[][] chars = new char[n + 2][m + 2];
        for (int i = 0; i < chars.length; i++) {
            Arrays.fill(chars[i], ' ');
        }


        // 일단 배열에 값을 넣기
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                chars[i][j] = storage[i - 1].charAt(j - 1);
            }
        }


        for (String r : requests) {
            if (r.length() == 1) {
                // 공백에서 해당 문자를 찾기!
                bfs(chars, r.charAt(0));
            } else {
                // 전체에서 해당 문자를 제거하기!
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= m; j++) {
                        if (chars[i][j] == r.charAt(0)) {
                            chars[i][j] = ' ';
                        }
                    }
                }
            }
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (chars[i][j] != ' ') {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void bfs(char[][] chars, char s) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[chars.length][chars[0].length];
        q.add(new int[]{0, 0});
        visited[0][0] = true;

        List<int[]> list = new ArrayList<>();

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int r = curr[0] + moveX[i];
                int c = curr[1] + moveY[i];

                if (0 <= r && 0 <= c && r < chars.length && c < chars[0].length && !visited[r][c]) {
                    if (chars[r][c] == ' ') { // 빈공간인 경우
                        visited[r][c] = true;
                        q.add(new int[]{r, c});
                    } else if (chars[r][c] == s) { // 삭제 단어를 찾은 경우
                        visited[r][c] = true;

                        list.add(new int[]{r, c});
                        // 삭제할 단어를 다른 곳에 저장!!!! 그냥 막 바꾸면 bfs의 흐름에 영향을 줌!!!
                        // q에 넣지는 않음!!
                    }
                }
            }
        }

        // 지우기 리스트에서 빼서
        for (int[] ints : list) {
            chars[ints[0]][ints[1]] = ' '; // 지우기
        }
    }
}