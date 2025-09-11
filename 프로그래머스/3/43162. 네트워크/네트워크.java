import java.util.HashSet;
import java.util.Set;

class Solution {
    private static int[] visited;
    private static int[][] computer;

    public static int solution(int n, int[][] computers) {
        visited = new int[n];
        computer = computers;

        for (int i = 0; i < computers.length; i++) {
            if (visited[i] == 0) {
                dfs(i,i+1);
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i : visited) {
            set.add(i);
        }
        return set.size();
    }

    private static void dfs(int n, int k) {
        if ( visited[n] != 0 ) {
            return;
        }
        visited[n] = k;

        for (int i = 0; i < computer[n].length; i++) {
            if (n == i) {
                continue;
            }
            if (computer[n][i] == 1 && visited[i] == 0) {
                dfs(i,k);
            }
        }
    }
}