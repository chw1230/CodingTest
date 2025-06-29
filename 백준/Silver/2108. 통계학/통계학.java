import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // set을 쓸까 list를 쓸까 고민 했었는데 순서(2번째) 때문에 lsit를 쓰는게 맞다고 생각했지만
    // 일단 set을 써서 해본게 한번에 맞추지 못한 이유 같음
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double sum = 0;
        int arr[] = new int[N];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int maxCnt = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
            sum += arr[i];
            // map에 arr[i]가 있으면 해당 key의 value 가져오고, 아니면 0 가져오기
            map.put(arr[i],map.getOrDefault(arr[i],0) + 1);
            maxCnt = Math.max(maxCnt, map.get(arr[i])); // 최빈값 value
        }
        Arrays.sort(arr);


        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxCnt) { // 최빈값에 해당하는 key들을 리스트에 넣기
                list.add(entry.getKey());
            }
        }
        // 리스트 정렬하기 -> 두번째로 작은 수 찾아야 하기 때문에
        Collections.sort(list);


        System.out.println(Math.round(sum / N)); // 산술평균
        System.out.println(arr[N/2]); // 중앙값
        System.out.println(list.size() > 1 ? list.get(1) : list.get(0)); // 최빈값
        // 최빈값이 오직 하나일 경우에는 리스트의 사이즈가 1 이니까 get(0)으로 출력
        // 최빈값이 여러개이면 리스트의 사이즈가 1보다 크니까 두번째(get(1)) 이용해서 출력
        System.out.println(max - min); // 범위
    }
}