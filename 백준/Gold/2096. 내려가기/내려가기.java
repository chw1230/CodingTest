import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    처음 시도 : 3칸짜리 줄을 매번 내려가면서, 각 칸이 아래로 내려보낼 수 있는 칸(좌하/중앙/우하)에 값을 더해주는 방식으로 구현하기위해서
    열 크기를 5로 잡아서(0과 4는 더미), 인덱스 경계를 피하는 방식을 사용하려 했으나 더 복잡하고 최대 최소 최신화에 더 많은 어려움을 느껴서 구현이 꼬였음

    그래서 오히려 반대로 해당 위치에 들어올 수 있는 값을 구하는 방식으로 반대로 구하니 구현이 더 쉬웠음!
    그리고 메모리 초과 ->  후자의 방식으로 하면 입력값을 저장할 배열 없이 계산하기에 용이함! (메모리 초과 지옥 탈출,,,)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int max[] = new int[3];
        int min[] = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            min[i] = max[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int[] M = new int[3];
            int[] m = new int[3];

            // 0 열로 올 수 있는 경우 ( 1.위에서 그대로, 2.우측 대각에서 )
            M[0] = a + Math.max(max[0], max[1]);
            m[0] = a + Math.min(min[0], min[1]);

            // 1 열로 올 수 있는 경우 ( 1. 좌측 대각, 2. 위에서 그대로, 3. 우축 대각 )
            M[1] = b + Math.max(max[0], Math.max(max[1], max[2]));
            m[1] = b + Math.min(min[0], Math.min(min[1], min[2]));

            // 2 열로 올 수 있는 경우 ( 1. 좌측 대각, 2. 위에서 그대로 )
            M[2] = c + Math.max(max[1], max[2]);
            m[2] = c + Math.min(min[1], min[2]);

            max = M;
            min = m;
        }

        System.out.println(Math.max(Math.max(max[0], max[1]), max[2]) + " " + Math.min(Math.min(min[0], min[1]), min[2]));
    }
}