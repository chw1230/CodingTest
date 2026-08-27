import java.util.ArrayList;
import java.util.Collections;

class Solution {
    
    static boolean[] visited;
    static ArrayList<String> list = new ArrayList<>();
    
    public static String[] solution(String[][] tickets) {
        // DFS 쓸거야 그러면 방문 배열 사용해야해!
        visited = new boolean[tickets.length];

        dfs(0, "ICN", "ICN", tickets);

        Collections.sort(list); // 알파벳 순으로 정리하기

        return list.get(0).split(" "); 
    }

    // 사용한 티켓 수, 시작 도시, 도착 도시, 티켓배열
    private static void dfs(int cnt, String start, String end, String[][] tickets) {
        if (cnt == tickets.length) {
            list.add(end); // 이렇게 하면 list에는 모든 도시를 돌 수 있는 모든 경우가 저장이 됨!
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            String[] ticket = tickets[i];

            // 사용하지 않ㅇ은 티켓이고, 티켓의 시작점이 같다면
            if (!visited[i] && ticket[0].equals(start)) {
                visited[i] = true;

                // 티켃은 하나 사용하고, 시작점은 티켓의 종료지점으로 수정, end에는 이전 도시에 문자열로 추가해서 넘기기
                dfs(cnt + 1, ticket[1], end + " " + ticket[1], tickets);

                visited[i] = false;
            }
        }
    }
}