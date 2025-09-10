import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 메모리 초과가 뜬다... -> 배열을 만들지 말고 풀어보자....ㅜㅜ
    // 배열에 -1 넣고 -1 인 애들만 값을 바꾸는 과정으로 문제 풀었음 -> 메모리 초과
    // 그러면 어떻게 배열 안쓰고 하지? -> 분할 과정에서 4조각 중 자기에 해당되는 것으로 가서 걔만 계산해서 구하는 방식으로 구함!
    private static int r,c;

    private static int div(int y, int x, int size) {
        if (size / 2 <= 0) {
            return 0;
        }

        if ( 0 <= y && y < size/2 && 0 <= x && x < size/2 ) {
//            System.out.println("좌측 상단");
            // 좌측 상단
            return (size / 2) * (size / 2) * 0 + div(y, x, size / 2);

        } else if ( 0 <= y && y < size/2 &&  size/2 <= x && x < size ) {
//            System.out.println("우측 상단");
            // 우측 상단
            return (size / 2) * (size / 2) * 1 + div(y, x - size / 2, size / 2);

        } else if ( size/2 <= y && y < size && 0 <= x && x < size/2 ) {
//            System.out.println("좌측 하단");
            // 촤측 하단
            return (size / 2) * (size / 2) * 2 + div(y - size / 2, x, size / 2);

        } else {
//            System.out.println("우측 하단");
            // 우측 하단
            return (size / 2) * (size / 2) * 3 + div(y - size / 2, x - size / 2, size / 2);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken()); // r행
        c = Integer.parseInt(st.nextToken()); // c열

        System.out.println(div(r, c, (int) Math.pow(2,N)));
    }
}