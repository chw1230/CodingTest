import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numCnt = 0;

        while (true) {
            String str = br.readLine();
            if (str.contains("-")) {
                return;
            }

            int stableCnt = 0; // 안정적으로 바꾸는데 필요한 연산 수

            Deque<Character> dq = new ArrayDeque<>(); // '{' 만 담는 스택
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '{') {
                    dq.addFirst(str.charAt(i));
                } else if (str.charAt(i) == '}') {
                    if (dq.isEmpty()) {
                        stableCnt++; // 바꾼 수 올리기
                        dq.addFirst('{');
                    } else {
                        dq.removeFirst();
                    }
                }
            }
            stableCnt += dq.size()/2;
            numCnt++;

            System.out.println(numCnt + ". " + stableCnt);
        }
    }
}