import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(div(r, c, (int) Math.pow(2,N)));
    }

    private static int div(int r, int c, int size) {
        if (size == 1) {
            return 0;
        }

        int h = size / 2;
        if (r < h && c < h) {
            return div(r, c, h);

        } else if (r < h && c >= h) {
            return h * h * 1 + div(r, c - h, h);

        } else if (r >= h && c < h) {
            return h * h * 2 + div(r - h, c, h);

        } else {
            return h * h * 3 + div(r - h, c - h, h);

        }
    }
}