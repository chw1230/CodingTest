package practice;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ10250 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken()); // 호텔 층 수
            int W = Integer.parseInt(st.nextToken()); // 층당 방 수 (사용되지 않음)
            int N = Integer.parseInt(st.nextToken()); // N번째 손님

            int floor; // 배정될 층
            int room;  // 배정될 호수

            if (N % H == 0) {
                floor = H;          // 꼭대기 층
                room = N / H;       // 몫이 방 번호
            } else {
                floor = N % H;      // 나머지가 층 번호
                room = N / H + 1;   // 몫 + 1이 방 번호
            }

            bw.write(floor * 100 + room + "\n"); // 결과 출력
        }

        bw.flush();
        bw.close();
    }
}
