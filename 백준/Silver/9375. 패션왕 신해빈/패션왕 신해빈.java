import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int cases = 1; // 최종 경우의 수
            Map<String,Integer> map = new HashMap<>(); // type과 해당 type에 대한 수
            int n = Integer.parseInt(br.readLine()); // 의상의 수
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String type = st.nextToken();

                map.put(type,map.getOrDefault(type,0)+1);
            }
//            System.out.println(map);
            for (String s : map.keySet()) {
                cases *= (map.get(s) + 1);
            }
            System.out.println(cases - 1); // 알몸 상태 빼기
        }
    }

}