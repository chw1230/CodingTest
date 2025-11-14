import java.util.Scanner;

public class Main {
    static int n,m;
    static int[] select;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
       
       select = new int[m];

       dfs(0,1); // 0개 뽑았고, 1부터 뽑는 상태부터 시작

       
    }

    static void dfs(int depth, int start) {
        if ( depth == m ) {
            for (int i = 0; i < m; i++) {
                System.out.print(select[i] +" ");
            }
            System.out.println();
            return;
        }


        for (int i = start; i <= n; i++) {
            select[depth] = i;
            dfs(depth + 1, i + 1);
        }
    }
}