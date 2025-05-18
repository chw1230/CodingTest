import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        Integer[][] size = new Integer[2][6]; // 수량|묶음수

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            size[0][i] = Integer.parseInt(st.nextToken());
            if (size[0][i] == 0) {
                size[1][i] = 0;
            } else {
                size[1][i] = 1;
            }
        }

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        for (int i = 0; i < size[0].length; i++) {
            if ( size[0][i] > T){
                if ( size[0][i] % T != 0){
                    size[1][i] = size[0][i] / T + 1;
                } else{
                    size[1][i] = size[0][i] / T;
                }
            }
            sum += size[1][i];
        }
        System.out.println(sum);
        System.out.println(n / P + " " + n % P);
    }
}
