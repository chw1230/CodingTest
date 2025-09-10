import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N; // 1부터 N까지 자연수
    static int M; // M개 고르기
    static int check[]; // 숫자를 담을 배열

    static void DFS(int a,int b) {
        if ( a == M ) {
            for (int i : check) {
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }

        for (int i = b; i <= N; i++) {
            check[a] = i;
            DFS(a+1,i+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        check = new int[M];
        DFS(0,1);
    }
}