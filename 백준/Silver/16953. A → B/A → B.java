import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int cnt =  1;
        while (B != A) {
            cnt++;
            String str = "" + B;
            if ( B % 2 == 0) {
                B = B / 2;
            } else if ((str).charAt(str.length() - 1) == '1') {
                B = Integer.parseInt(str.substring(0, str.length() - 1));
            } else {
                System.out.println(-1);
                return;
            }

            if (B < A) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(cnt);
    }
}