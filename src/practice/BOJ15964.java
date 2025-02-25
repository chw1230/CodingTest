package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15964 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

//        int형보다 큰 값을 출력할 수도 있으므로 long 사용
        Long A = (long) Integer.parseInt(st.nextToken());
        Long B = (long) Integer.parseInt(st.nextToken());
        System.out.println((A+B)*(A-B));
    }
}
