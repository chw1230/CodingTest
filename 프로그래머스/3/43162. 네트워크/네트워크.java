class Solution {
    public static int solution(int n, int[][] computers) {
        int answer = 0;

        // 방문 처리 배열
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) { // 방문하지 않았다면
                answer++; // 네트워크의 수를 하나 증가
                dfs(i, computers, visited);
            }
        }
        return answer;
    }

    private static void dfs(int start, int[][] computers, boolean[] visited) {
        visited[start] = true;

        for (int i = 0; i < computers[start].length; i++) {
            if (!visited[i]) {
                if (computers[start][i] == 1) {
                    dfs(i, computers, visited);
                }
            }
        }
    }
}