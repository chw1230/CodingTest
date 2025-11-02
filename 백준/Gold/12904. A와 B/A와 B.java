import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class  Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        int s = 0;
        int e = T.length() - 1;
        while (!T.equals(S)) {
            if (T.charAt(e) == 'A') {
                T = T.substring(0, e);
            } else if (T.charAt(e) == 'B') {
                T = T.substring(0, e);
                T = new StringBuffer(T).reverse().toString();
            } else {
                System.out.println(0);
                return;
            }

            if (T.length() < S.length()) {
                System.out.println(0);
                return;
            }
            e = T.length() - 1;
        }
        System.out.println(1);
    }
}