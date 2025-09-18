import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /* 계속 오류나고 헷갈렸던 부분 : 집 사이 거리로 접근해야 하는데 인덱스 번호를 통해서 해결하려고 했음!! ㅜㅜ */

    private static int arr[];
    private static int N, C;

    private static int max = Integer.MIN_VALUE;

    private static int maximization() {
        int lo = 1; // 최소 거리
        int hi = arr[N - 1] - arr[0]; // 최대 거리
        int r = 0;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

           if (decision(mid)) { // mid 간격으로 설치 했을 때 C개 설치 할 수 있는지 보기
               r = mid;
               // 떨어뜨릴 거리를 늘리기
               lo = mid + 1; 
           } else {
               // 떨어트릴 거리를 줄이기
               hi = mid - 1;
           }
        }
        return r;
    }

    private static boolean decision(int cur) {
        int already = 0; // 설치된 곳의 idx 번호 -> 왜 0 부터임?
        int cnt = 1; // 왜 1부터 임?
        // 위에 둘다 공통적으로 0번 인덱스 집은 무조건 설치하고 시작하기 때문에!

        for (int j = 1; j < N; j++) {
            int dis = arr[j] - arr[already]; // 이미 설치된 곳에서 j번째까지의 거리 구하기
            if (dis >= cur) { // 설치된 경우를 의미 -> cur보다 더 떨어져 있으면 설치 가능
                cnt++;
                already = j; // 근방에 설치된 곳을 최신화 해주기!
                if (cnt >= C) { // 요구하는 조건을 만족했다면 
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr); // 정렬

        if (C == 2) {
            System.out.println(arr[N - 1] - arr[0]);
            return;
        }

        System.out.println(maximization());
    }
}