import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Character,Integer> map = new HashMap<>();

        String s = br.readLine().toUpperCase();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }
        List<Character> keySet = new ArrayList<>(map.keySet());
        // Value 값으로 내림차순 정렬
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));

        if (map.size() == 1) {
            System.out.println(keySet.get(0));
            return;
        }
        if (map.get(keySet.get(0)).equals(map.get(keySet.get(1)))) {
            System.out.println("?");
        } else {
            System.out.println(keySet.get(0));
        }
    }
}