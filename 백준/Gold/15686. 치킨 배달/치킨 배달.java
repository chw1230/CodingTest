import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    // 집이랑 가게랑 따로 저장하려하지 않음!
    // -> Point로 해결
    // 가게를 여러개 중 선택하는 경우는 어떻게 해야하는거지? 에 대한 의문! (?ㅜ,ㅜ?)
    // -> open을 통해서 특정 가게(1번 가게)를 열고 그다음 가게(1번 열고 2번 가게 열기)를 열었을 때의 경우를 구하고 또 다른가게(1번 열고 3번 열고)를 열고 이런식으로! DFS를 통해서 해결!!!!!
    // 한 집에서 모든가게까지의 거리를 구해서 해결해야 할지, 한 가게에서 모든 집까지의 거리를 구해야하는지 어쩌면 좋을까???...
    // -> 이거는 결론이 났다 한 집에서 모든 가게까지의 거리를 구해서 해결을 해야한다!! 왜냐 한 가게에서 모든 집까지의 거리를 구하면 가게가 여러개 일때의 치킨 거리의 값을 정확하게 구할 수 없음!
    // => 문제에서도 집을 기준으로 치킨 거리가 정해진다고 했다. 문제를 잘 읽자...
    // 시간 초과 발생!! -> 중복을 고려하지 않아서 1번 가게로 시작했는데 왜 또 1번 가게 부터함? 1번 다음부터 해야지!

    private static int N;
    private static int M;
    private static boolean[] open; // 열린 가게를 표시할 배열 (왜? 열린 가게를 표시 해야해? -> 여러개의 가게 중 M개만 선택되는 경우에 어떤 M개를 남길지 구하는 과정에서 사용하기 위해서!!
    private static List<Point> home; // 집 좌표를 넣을 list
    private static List<Point> store; // 가게 좌표를 넣을 list
    private static int result; // '다른 열린 가게의 경우와 비교했을 때' 가장 작은 치킨 거리 합을 담을 변수

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void DFS(int start, int cnt) {
        if (cnt == M) {
            int sum = 0; // 치킨 거리 총합

            for (int i = 0; i < home.size(); i++) { // 한 집에서 열린 가게에 대해서 거리를 구하자
                int min = Integer.MAX_VALUE; // 집에서 열린 가게까지의 최소 거리를 담을 변수

                for (int j = 0; j < store.size(); j++) { // 여러개의 가게 중 열린 가게에 대해서
                    if (open[j]) {
                        int dis = Math.abs(home.get(i).x - store.get(j).x) + Math.abs(home.get(i).y - store.get(j).y);
                        min = Math.min(min, dis); // 한 집에서 열린 여러 가게들까지의 거리중 최소 거리를 담기
                    }
                }
                sum += min; // 각자의 집에서 가장 가까운 가게까지의 최소 치킨 거리를 합하기
            }
            result = Math.min(sum, result); // 열린 가게가 다른 가게인 경우와 비교해서 가장 작은 치킨 거리의 합으로 최신화!
            return;
        }

        for (int j = start; j < store.size(); j++) {
            open[j] = true;
            DFS(j + 1, cnt + 1);
            open[j] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        home = new ArrayList<>();
        store = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (n == 1) { // 집인 경우
                    home.add(new Point(j, i)); // 집의 좌표를 저장하기!
                } else if (n == 2) { // 가게이면
                    store.add(new Point(j, i)); // 가게 저장
                }
            }
        }

        result = Integer.MAX_VALUE;
        open = new boolean[store.size()];
        DFS(0,0);
        System.out.println(result);
    }
}