import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String s = br.readLine();
        long sum = 0;

        char c[] = new char[L];
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < L; i++) {
            c[i] = s.charAt(i);
            map.put(c[i], c[i] - 'a' + 1);
        }

        for (int i = 0; i < L; i++) {
            sum += map.get(c[i])*Math.pow(31, i);
        }
        System.out.println(sum % 1234567891);

    }
}