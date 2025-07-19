import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
        // 입력된 순서를 보장하기 위해서 likedHashMap 사용!!
        // hashMap은 해시값 기반 데이터 저장이므로 입력 순서를 고려하지 않음!

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            map.put(a,map.getOrDefault(a,0)+1);
        }

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder())); // value 값 기반 정렬설정하기
        for (Map.Entry<Integer, Integer> integerIntegerEntry : entryList) {
            for (int i = 0; i < integerIntegerEntry.getValue(); i++) {
                System.out.print(integerIntegerEntry.getKey()+ " ");
            }
        }
    }
}