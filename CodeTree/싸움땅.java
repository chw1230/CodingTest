import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int n, m, k;
    // 상,우,하,좌 시계방향
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static ArrayList<Integer>[][] gun; // 땅에 있는 총의 공격력을 저장(같은 자리에 총이 여러개 있을 수 있음)
    static ArrayList<Player> players; // 사람을 담는 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        gun = new ArrayList[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                gun[i][j] = new ArrayList<>();
                int g = Integer.parseInt(st.nextToken());
                if (g > 0) {
                    gun[i][j].add(g);
                }
            }
        }

        players = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            players.add(new Player(i, x, y, d, s));
        }

        while (k-- > 0) {
            for (Player curPlayer : players) {
                move(curPlayer);

                Player enemy = null;
                for (Player p : players) {
                    // 자기 자신 아니고, 위치가 같으면
                    if (p.num != curPlayer.num && p.x == curPlayer.x && p.y == curPlayer.y) {
                        enemy = p; // 동일한 위치에 사람이 있다
                        break;
                    }
                }

                if (enemy != null) {
                    // 동일한 위치에 잇는 사람과 싸우기
                    fight(curPlayer, enemy);
                } else {
                    // 총 최신화
                    updateGun(curPlayer);
                }
            }
        }

        for (Player p : players) {
            System.out.print(p.score +" ");
        }
        System.out.println();
    }

    private static void move(Player p) {
        int nx = p.x + dx[p.d];
        int ny = p.y + dy[p.d];

        if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
            p.d = (p.d + 2) % 4; // 원형 생각하기
            // 다음 위치 구하기
            nx = p.x + dx[p.d];
            ny = p.y + dy[p.d];
        }
        // 다음 위치로 최신화
        p.x = nx;
        p.y = ny;
    }

    private static void fight(Player p1, Player p2) {
        // !!!!!
        Player winner, loser;
        // !!!!!

        if (p1.getTotal() != p2.getTotal()) {
            if ( p1.getTotal() > p2.getTotal()) {
                winner = p1;
                loser = p2;
            } else {
                winner = p2;
                loser = p1;
            }
        } else {
            if ( p1.s > p2.s) {
                winner = p1;
                loser = p2;
            } else {
                winner = p2;
                loser = p1;
            }
        }
        // !!!!!
        winner.score += winner.getTotal() - loser.getTotal();
        // !!!!!

        moveLoser(loser);
        updateGun(winner);
    }

    private static void moveLoser(Player loser) {
        if (loser.gun > 0) { // 총이 있으면
            gun[loser.x][loser.y].add(loser.gun); // 땅에 두기
            loser.gun = 0; // 가진 총 0으로 초기화
        }

        for (int i = 0; i < 4; i++) {
            int next = (loser.d + i) % 4; // 방향 (시계방향)
            // 새로운 위치
            int nx = loser.x + dx[next];
            int ny = loser.y + dy[next];

            boolean here = false;
            for (Player p : players) {
                // 자기 자신이 아닌데 같은 위치라면
                if (p.num != loser.num && p.y == ny && p.x == nx) {
                    here = true; // 존재 처리
                    break;
                }
            }

            // 위치에 다른 사람이 존재하지 않고, 범위 안에 잘 있다면
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && !here) {
                // 방향과 위치 최신화
                loser.d = next;
                loser.x = nx;
                loser.y = ny;
                break;
            }
        }

        // 이동한 곳에서
        updateGun(loser);
    }

    // 총 획득/교체 처리
    private static void updateGun(Player p) {
        if (gun[p.x][p.y].isEmpty()) return;

        // 바닥에 있는 가장 공격력이 높은 총을 찾음
        int maxGunPower = Collections.max(gun[p.x][p.y]);

        if (maxGunPower > p.gun) {
            if (p.gun > 0) {
                gun[p.x][p.y].add(p.gun);
            }
            p.gun = maxGunPower;
            // Integer.valueOf()를 사용하여 값으로 객체를 삭제
            gun[p.x][p.y].remove(Integer.valueOf(maxGunPower));
        }
    }

    static class Player {
        int num; // num번째 사람
        int x, y; // 위치
        int d; // 방향
        int s; // 초기 능력치
        int gun; // 총의 공격력
        int score;   // 획득한 포인트

        public Player(int id, int x, int y, int d, int s) {
            this.num = id;
            this.x = x;
            this.y = y;
            this.d = d;
            this.s = s;
            this.gun = 0; // 처음 총을 안가지고 생성됨
            this.score = 0; // 점수도 0으로 생성됨
        }

        // total 공격력 ( 초기 공격력 + 총 )
        public int getTotal() {
            return this.s + this.gun;
        }
    }
}
