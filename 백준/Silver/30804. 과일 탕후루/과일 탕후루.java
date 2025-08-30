import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 푸는데 너무 오래 걸림
    // 아직 익숙하지 않은 것 같음....
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int arr[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 과일 값 저장하기
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> map = new HashMap<>(); // 숫자 , 개수
        int left = 0; // 왼쪽 과일을 의미하는 인덱스
        int max = Integer.MIN_VALUE; // 최대 과일 개수

        // 왼쪽 부터 오른쪽으로 가면서 과일 종류가 2개보다 크면 개수 조절
        for (int i = 0; i < N; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1); // 우측 과일을 하나 포함시키는 경우
            // 이미 존재하고 있었다면 과일의 종류(map.size)는 그대로임! 아니라면 과일의 종류가 하나 늘어남!

            while (map.size() > 2) { // 종류가 2개 초과인 경우
                int leftValue = arr[left]; // 가장 좌측의 과일 저장
                int remove = map.get(leftValue) - 1; // 가장 좌측의 과일 개수 줄이기
                if (remove == 0) { // 줄였는데 개수가 0이라면
                    map.remove(leftValue); // map에서 제거
                } else { // 개수가 0이 아니라면 줄인 값으로 최신화
                    map.put(leftValue, remove);
                }
                left++; // 가장 좌측을 의미하는 인덱스 값 키우기
            }

            // 과일의 종류가 무조건 2종류 이하인 상태에서 여기에 도달
            max = Math.max(max, i - left + 1); // i는 점점 늘어나고 , left는 종류가 2개 초과일 때만 늘어나니까 이와 같이 max값을 초기화 한다.
        }
        System.out.println(max);
    }
}