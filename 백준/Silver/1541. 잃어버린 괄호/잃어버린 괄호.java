import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(),"+-",true); // "+-"를 기준으로 나누기!, +와 -도 하나의 토큰으로 사용하기

        int sum = 0;
        int signal = 0;
        int sub = 0;

        while(st.hasMoreTokens()){ // 존재 할 때 까지
            String s = st.nextToken();
            if (s.equals("-")){
                signal = -1;
            } else if (s.equals("+")) {
                continue;
            } else {
                if ( signal == -1 ){ 
                    sub += Integer.parseInt(s);
                } else {
                    sum += Integer.parseInt(s);
                }
            }
        }
        System.out.println(sum-sub);
    }
}