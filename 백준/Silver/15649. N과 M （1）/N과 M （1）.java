import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 처음에 푸는데 이해하기 너무 어려웠다!! 너무 오랜 시간 소요됨!! */
public class Main {
    static int N;
    static int M;

    static boolean visited[]; // 방문을 담당하는 배열
    static int check[]; // 뽑은 수를 넣을 배열


    static void DFS(int a) {
        if (a == M) { // 개수가 3개가 쌓였다 => 출력
            for (int b : check) {
                System.out.print(b+" ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) { // 방문한 적이 없으면
                visited[i] = true; // 방문 처리
                check[a] = i; // a번째에 i 저장
                DFS(a + 1); // 다음 수 선택
                visited[i] = false; // 방문 처리 풀기
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // N까지
        M = Integer.parseInt(st.nextToken()); // 수열의 길이 M
        // 1부터 N까지에서 M개의 수 뽑기

        visited = new boolean[N+1];
        check = new int[M];

        DFS(0);
    }
}