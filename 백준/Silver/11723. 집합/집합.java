import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 비트 마스크 이용해서 다시 풀어보기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        int S = 0; // 공집합 상태

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();

            if (op.equals("add")) {
                int x = Integer.parseInt(st.nextToken());
                S |= (1 << x); // 00000001의 1을 x만큼 좌측으로 이동해서 OR 연산 -> S에 있었으면 OR니까 어차피 1, 없었어도 1
            } else if (op.equals("remove")) {
                int x = Integer.parseInt(st.nextToken());
                S &= ~(1 << x);
                // 00000001의 1을 x만큼 좌측으로 이동해서 AND 연산 -> ~을 이용해서 입력한 숫자의 비트를 0으로 만들기
                // 이후 AND연산을 통해서 S에 존재한다면 (1&0 = 0)0으로 없애버림
            } else if (op.equals("check")) {
                int x = Integer.parseInt(st.nextToken());
                sb.append((S & (1 << x)) != 0 ? "1\n" : "0\n"); // 존재하면 1, 존재않으면 0
            } else if (op.equals("toggle")) {
                int x = Integer.parseInt(st.nextToken());
                S ^= (1 << x); // XOR 적용시키기 (1)있으면 (0)없도록, (0)없으면 (1)있도록
            } else if (op.equals("all")) {
                S = (1 << 21) - 1; // 100000000000000000000 - 000000000000000000001 = 011111111111111111111 비트 연산 이용!!
            } else if (op.equals("empty")) {
                S = 0; // 공집합으로 만들기
            }
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int x;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if (s.equals("add") || s.equals("remove") || s.equals("check") || s.equals("toggle")) {
                x = Integer.parseInt(st.nextToken());
            }else {
                x = 0;
            }
            if (s.equals("add")) {
                set.add(x);
            } else if (s.equals("remove")) {
                set.remove(x);
            } else if (s.equals("check")) {
                sb.append(set.contains(x) ? "1\n" : "0\n");
            }else if (s.equals("toggle")) {
                if (set.contains(x)) {
                    set.remove(x);
                }else {
                    set.add(x);
                }
            }else if (s.equals("all")) {
                for (int j = 1; j <= 20; j++) {
                    set.add(j);
                }
            }else {
                for (int j = 1; j <= 20; j++) {
                    set.remove(j);
                }
            }
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
        */
    }
}