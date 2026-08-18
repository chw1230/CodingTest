class Solution {
    static int max = 0;
    
    public static int solution(int k, int[][] dungeons) {
        int answer = -1;

        // 방문 여부를 담을 체크 배열 생성
        boolean[] visited = new boolean[dungeons.length];

        dfs(k, dungeons, visited, 0);

        return max;
    }

    private static void dfs(int k, int[][] dungeons, boolean[] visited, int d) {
        max = Math.max(max, d);

        for (int i = 0; i < dungeons.length; i++) {
            if ( !visited[i] && k >= dungeons[i][0]) { // 방문 하지 않았고, K(현재 피로도)가 던전에서 소모되는 피로도 보다 크면
                // 던전 진행
                
                // 방문 처리
                visited[i] = true;
                
                // 재귀적으로 호출
                dfs(k - dungeons[i][1], dungeons, visited, d + 1); // 피로도 감소시킨 값과 깊이 증가
                
                // 방문 철회
                visited[i] = false; 
            }

        }
    }
}