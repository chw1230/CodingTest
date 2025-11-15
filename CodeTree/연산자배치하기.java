import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int min;
    private static int max;
    private static int[] num; // 숫자들
    private static int[] arr = new int[3]; // +의 개수, -의 개수, *의 개수
    private static ArrayList<Integer> op = new ArrayList<>(); // 선택된 연산자

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken()); // 입력된 정수의 순서를 바꿀 수 없음!
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // 합-0,차-1,곱-2
        }

        dfs(0);
        System.out.println(min + " " + max);

    }

    private static void dfs(int cnt) {
        if (cnt == n - 1) {
            int value = calc();
            min = Math.min(min, value);
            max = Math.max(max, value);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (arr[i] > 0) { // 개수가 아직 남은 연산자만 사용
                arr[i]--;        // 연산자 하나 사용
                op.add(i);       // 이 위치에 i번 연산자 사용

                dfs(cnt + 1);

                op.remove(op.size() - 1);
                arr[i]++;
            }
        }

    }
    private static int calc() {
        int r = num[0];

        for (int i = 0; i < op.size(); i++) {
            if (op.get(i) == 0) {
                r += num[i + 1];
            } else if (op.get(i) == 1) {
                r -= num[i + 1];
            } else {
                r *= num[i + 1];
            }
        }
        return r;
    }
}
