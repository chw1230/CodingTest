import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        String str = "666";
        int num = 0;

        while (cnt != n) {
            num++;
            if ( (String.valueOf(num).contains(str))){
                cnt++;
            }
        }
        System.out.println(num);
    }
}