import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt; i++) {
            map.put(i + 1, Integer.valueOf(st.nextToken()));
        }

        int student = Integer.parseInt(br.readLine());
        for (int i = 0; i < student; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            map = OnOff(sex,num,map);
        }
        int count = 0;
        for (int i = 1; i <= map.size(); i++) {
            System.out.print(map.get(i) + " ");
            count++;
            if (count % 20 == 0) {
                System.out.println();
            }
        }
    }

    private static  Map<Integer, Integer> OnOff(int sex, int num,Map<Integer, Integer> map) {
        if (sex == 1) {
            for (int i = num; i <= map.size(); i=i+num) {
                if (map.get(i) == 0) {
                    map.put(i, 1);
                }else{
                    map.put(i, 0);
                }
            }
        } else {
            if (map.get(num) == 0) {
                map.put(num, 1);
            }else{
                map.put(num, 0);
            }
            int left = num - 1;
            int right = num + 1;

            while (left >= 1 && right <= map.size()) {
                if (!map.get(left).equals(map.get(right))) break;

                map.put(left, 1 - map.get(left));
                map.put(right, 1 - map.get(right));

                left--;
                right++;
            }
        }
        return map;
    }
}
