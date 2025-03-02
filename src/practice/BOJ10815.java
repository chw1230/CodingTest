package practice;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ10815 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st1.nextToken());
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st2.nextToken());
            if (hashMap.get(num) == null) { // 없는 key를 조회하는 경우
                bw.append(0 + " ");
            }else {
                bw.append(1 + " ");
            }
        }
        bw.flush();
        bw.close();
    }
}
