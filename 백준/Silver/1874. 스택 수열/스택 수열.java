import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> s1 = new ArrayDeque<>();
        Deque<Integer> s2 = new ArrayDeque<>();


        int j = 1;
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
//            System.out.println(a);
            if (a >= j) {
                for (j = j; j <= a; j++) {
                    s1.push(j);
                    sb.append("+\n");
                }
            }
            int save = s1.pop();
            if (a == save) {
                s2.push(save);
                sb.append("-\n");
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb.toString());
    }
}