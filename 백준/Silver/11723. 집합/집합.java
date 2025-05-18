import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
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
    }
}