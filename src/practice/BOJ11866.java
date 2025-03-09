package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ11866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("<"); // <가 붙은 채로 시작하기!
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        while (deque.size() != 1) {
            for (int i = 1; i < K; i++) {
                deque.offer(deque.poll()); //  앞에서 뺴와서 뒤로 넣어주기! k-1번! 시행
            }
            sb.append(deque.poll()+", "); // 빼줘야 하는것은 sb에 저장!
        }
        sb.append(deque.poll() + ">"); // 출력을 위해 마직막 나오는 것은 while 문 밖에서 저장!
        System.out.println(sb);
    }
}
