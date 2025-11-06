import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[i][0] = s;
            arr[i][1] = e;
        }

        Arrays.sort(arr, (s, e) -> { 
            if (s[0] == e[0] ) { // 수업 시작 시간이 같으면, 빨리 끝나는 순서로 정렬
                return s[1] - s[1];
            }
            return s[0] - e[0]; // 수업 시작 시간이 같지 않으면 수업이 빨리 끝나는 순으로 정렬
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(arr[0][1]); // 가장 처음 수업의 끝나는 시간 넣기

        for (int i = 1; i < N; i++) {
            if ( pq.peek() <= arr[i][0]) { // i-1의 수업의 종료 시간이 i 수업의 시작 시간 보다 작거나 같으면
                pq.poll(); // peak() 강의실을 그대로 이어 받아서 사용 가능!
            }
            pq.add(arr[i][1]);
        }
        System.out.println(pq.size());
    }
}