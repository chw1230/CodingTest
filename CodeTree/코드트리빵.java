import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[] mr = {-1, 0, 0, 1};
    static int[] mc = {0, -1, 1, 0};
    static int[][] map;
    static ArrayList<Position> people;
    static ArrayList<Position> storeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        people = new ArrayList<>();
        storeList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            storeList.add(new Position(r - 1, c - 1));
        }

        int clock = 1;
        while (true) {
            // 사람이 있으면 원하는 편의점으로 이동
            movePeople();

            // 편의점 도착하면 멈추고, 편의점 방문 처리
            store();

            // t <= m을 만족한다면, t번 사람은 자신이 가고 싶은 편의점과 가장 가까이에 있는 베이스 캠프에 들어가기
            if (clock <= m) {
                enterBaseCamp(clock);
            }

            int cnt = 0;
            for (int i = 0; i < people.size(); i++) {
                Position person = people.get(i);
                Position store = storeList.get(i);

                if (person.r == store.r && person.c == store.c) {
                    cnt++;
                }
            }
            if (cnt == m) {
                break;
            }

            clock++;
        }

        System.out.println(clock);
    }

    private static void store() {
        for (int i = 0; i < people.size(); i++) {
            Position person = people.get(i);
            Position store = storeList.get(i);

            if (person.r == store.r && person.c == store.c) {
                map[person.r][person.c] = 2;
            }
        }
    }

    // 전체 사람들 이동
    private static void movePeople() {
        for (int i = 0; i < people.size(); i++) {
            Position person = people.get(i);
            Position store = storeList.get(i);

            if (person.r == store.r && person.c == store.c) {
                continue;
            }

            int[][] dis = BFS(store);

            int min = Integer.MAX_VALUE;
            Position minPos = new Position(-1, -1);

            for (int j = 0; j < 4; j++) {
                int nr = person.r + mr[j];
                int nc = person.c + mc[j];

                // 벗어나는 것 빼기
                if (nr < 0 || nc < 0 || nr >= n || nc >= n) {
                    continue;
                }

                if (dis[nr][nc] < min) {
                    min = dis[nr][nc];
                    minPos = new Position(nr, nc);
                }
            }

            if (min == Integer.MAX_VALUE) {
                // 갈 수 있는 칸이 없다면 이동하지 않음
                continue;
            }
            people.set(i, minPos);
        }
    }

    private static void enterBaseCamp(int clock) {
        Position store = storeList.get(clock - 1);
        // 베이스 캠프 선정하기
        int[][] dis = BFS(store);

        int min = Integer.MAX_VALUE;
        Position minPos = new Position(-1, -1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && dis[i][j] < min) {
                    min = dis[i][j];
                    minPos = new Position(i, j);
                    // 배열의 탐색 순서에 의해서
                }
            }
        }


        // 사람 추가
        people.add(minPos);
        map[minPos.r][minPos.c] = 2; // 못 지나가도록 2로 처리
    }

    private static int[][] BFS(Position store) {

        // 스토어를 시작점에서 최단 거리 돌려서 나온 베이스 캠프! 선정!

        /** 최단 거리 찾기 부분 **/
        Queue<Position> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        int[][] dis = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dis[i], 1_000_000_000);
        }

        // 시작 점 처리 부분
        q.add(store);
        visited[store.r][store.c] = true;
        dis[store.r][store.c] = 0;

        while (!q.isEmpty()) {
            Position s = q.poll();
            int r = s.r;
            int c = s.c;

            for (int i = 0; i < 4; i++) {
                int nr = r + mr[i];
                int nc = c + mc[i];

                // 벗어나는 것 빼기
                if (nr < 0 || nc < 0 || nr >= n || nc >= n) {
                    continue;
                }

                // 최단 거리를 갱신 가능 하고, 방문 하지않고, 해당 칸으로 갈 수 있는 경우(!=2)인 경우에만
                if (dis[nr][nc] > dis[r][c] + 1 && !visited[nr][nc] && map[nr][nc] != 2) {
                    dis[nr][nc] = dis[r][c] + 1;
                    visited[nr][nc] = true;
                    q.add(new Position(nr, nc));
                }
            }
        }
        return dis;
    }

    static class Position {
        int r;
        int c;

        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
