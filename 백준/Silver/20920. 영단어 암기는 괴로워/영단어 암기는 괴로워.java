import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String,Integer[]> map = new HashMap<String,Integer[]>(); // 단어,[빈도,길이]
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() >= M) {
                Integer[] value = map.getOrDefault(word, new Integer[]{0, word.length()});
                map.put(word, new Integer[]{value[0] + 1, value[1]});
            }
        }

        List<Map.Entry<String, Integer[]>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((a, b) -> {
            int compare1 = b.getValue()[0].compareTo(a.getValue()[0]); // 빈도 내림차순
            if (compare1 != 0) return compare1;

            int compare2 = b.getValue()[1].compareTo(a.getValue()[1]); // 길이 내림차순
            if (compare2 != 0) return compare2;

            return a.getKey().compareTo(b.getKey()); // 사전순 오름차순
        });

        for (Map.Entry<String, Integer[]> entry : entryList) {
            bw.write(entry.getKey()+"\n");
        }
        bw.flush();
        bw.close();
    }
}