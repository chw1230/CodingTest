import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(br.readLine());

        int room = 1; // 가장 끝 방
        int f = 1;
        while (n > room) {
            room += 6 * f;
            f++;
        }
        System.out.println(f);
    }
}