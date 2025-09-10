package SWEA.D4.서로소집합_3289;

import java.io.*;
import java.util.StringTokenizer;

public class 서로소집합 {
    private static int[] parent;

    private static int findParent(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = findParent(parent[x]);
    }

    private static void union ( int a, int b ) {
        a = findParent(a);
        b = findParent(b);
        if (a == b) {
            return;
        }
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        int testCnt = 1;
        while (T != 0) {
            bw.write("#" + testCnt + " ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken()); // 연산의 개수

            parent = new int[n+1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int option = Integer.parseInt(st.nextToken());
                if (option == 0) { // union
                    union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                } else { // find
                    if (findParent(Integer.parseInt(st.nextToken())) == findParent(Integer.parseInt(st.nextToken()))) {
                        bw.write("1");
                    } else {
                        bw.write("0");
                    }
                }
            }
            bw.write("\n");
            bw.flush();
            T--;
            testCnt++;
        }
        bw.close();
    }
}
