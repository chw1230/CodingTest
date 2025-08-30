import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int arr[] = new int[4];

        arr[0] = 1;
        arr[3] = 2;

        int tmp;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == 'A') {
                tmp = arr[0];
                arr[0] = arr[1];
                arr[1] = tmp;
            } else if (c == 'B') {
                tmp = arr[0];
                arr[0] = arr[2];
                arr[2] = tmp;
            } else if (c == 'C') {
                tmp = arr[0];
                arr[0] = arr[3];
                arr[3] = tmp;
            } else if (c == 'D') {
                tmp = arr[1];
                arr[1] = arr[2];
                arr[2] = tmp;
            } else if (c == 'E') {
                tmp = arr[1];
                arr[1] = arr[3];
                arr[3] = tmp;
            } else {
                tmp = arr[2];
                arr[2] = arr[3];
                arr[3] = tmp;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                System.out.println(i+1);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                System.out.println(i+1);
            }
        }
    }
}