import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int arr[][] = new int[N][M];

        int maxH = Integer.MIN_VALUE;
        int minH = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                maxH = Math.max(maxH, arr[i][j]);
                minH = Math.min(minH, arr[i][j]);
            }
        }

        int minTime = Integer.MAX_VALUE; // 최소 시간 변수
        Map<Integer, Integer> map = new TreeMap<>(); // time, height
        // 최소 높이에서 최대 높이까지 루프 돌기
        for (int i = minH; i <= maxH; i++) { // i는 기준 땅을 의미
            int time = 0; //
            int b = B; // 

            for (int j = 0; j < arr.length; j++) {
                for (int k = 0; k < arr[j].length; k++) {
                    if (arr[j][k] > i) { // 땅에서 인벤으로
                        b += arr[j][k] - i;
                        time += 2 * (arr[j][k] - i);
                    } else { // 인벤에서 땅으로 
                        b += arr[j][k] - i;
                        time += -(arr[j][k] - i);
                    }
                }
            }

            if (b >= 0) { // 인벤토리가 0이상인 경우만 map에 넣기
                if (map.containsKey(time)) { // 이미 존재하는 경우
                    if (map.get(time) < i) { // 땅의 높이가 더 높은경우를 넣기
                        map.put(time, i);
                    }
                } else { // 없으면 그냥 추가
                    map.put(time, i); 
                }
                minTime = Math.min(minTime, time); // 최소 시간 저장하기
            }
        }

        bw.write(minTime + " " + map.get(minTime));
        bw.flush();
        bw.close();
    }
}