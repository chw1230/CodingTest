import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import static java.lang.Math.pow;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        Map<Integer,Integer> map = new HashMap<>();
        int save = 0;

        while(true) {
            int n = 0;
            if (!map.containsKey(A)){
                map.put(A,0);
            } else{
                map.put(A,save=map.get(A)+1);
            }
            if (save == 2) {
                break;
            }
            while (A != 0){
                n += (int) pow((A % 10),P);
                A /= 10;
            }
            A = n;
//            System.out.println(n);
        }

        int cnt = 0;
        for (Integer value : map.values()) {
            if (value == 0) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}