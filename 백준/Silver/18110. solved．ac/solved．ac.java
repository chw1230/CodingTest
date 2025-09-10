import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int a = (int) Math.round((double) n * 15 / 100);
        double sum = 0;

        for (int i = a; i <= arr.length - a - 1; i++) {
            sum += arr[i];
        }

        System.out.println(Math.round(sum / (arr.length - a*2)));
    }
}