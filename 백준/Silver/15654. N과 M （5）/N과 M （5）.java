import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M; // M개 만틈 출력
    static int arr[]; // 입력된 숫자를 담는 배열
    static int answer[]; // M개의 배열을 담아서 출력에 사용하는 배열
    static int visited[]; // arr 배열의 방문 정보를 담는 배열
    
    // 오래 걸린 이유 -> 조건문과 반복문으로 문제 요구 조건을 해결하려고 했음!
    // 방문 처리로 해결하니 금방해결함!
    private static void DFS(int a) {
        if (a == M) {
            for (int i : answer) {
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                answer[a] = arr[i];
                DFS(a+1);
                visited[i] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        answer = new int[M];
        arr = new int[N];
        visited = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); // 문제의 요구 사항에 맞게 오름차순 정렬

        DFS(0);
    }
}