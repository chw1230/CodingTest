import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int min = Integer.MAX_VALUE;
    private static int max = Integer.MIN_VALUE;
    private static int[] arr; // 수를 담을 배열
    private static int[] op; // +,-,*,/ 의 개수를 담는 배열
    private static ArrayList<Integer> opList = new ArrayList<>(); // 선택한 연산자를 담는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        op = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int cnt) {

        if (cnt == n - 1) {
            int r = calc();
            max = Math.max(max, r);
            min = Math.min(min, r);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                opList.add(i);
                op[i]--;

                dfs(cnt + 1);

                op[i]++;
                opList.remove(opList.size() - 1);
            }
        }
    }

    private static int calc() {
        int value = arr[0]; // 연산자 전에 가장 먼저 오는 숫자

        for (int i = 0; i < opList.size(); i++) {
            if (opList.get(i) == 0) {
                value += arr[i + 1]; // 다음 수 연산
            } else if (opList.get(i) == 1) {
                value -= arr[i + 1];
            } else if (opList.get(i) == 2) {
                value *= arr[i + 1];
            } else {
                value /= arr[i + 1];
            }
        }
        return value;
    }
}