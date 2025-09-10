import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        String[] arr = new String[3];
        int num = 0;
        for (int i = 0; i < 3; i++) {
            String s = br.readLine();
            arr[i] = s;

            if (s.equals("Fizz")) {

            } else if (s.equals("Buzz")) {

            } else if (s.equals("FizzBuzz")){

            } else{
                num = (Integer.parseInt(s) + 3 - i);
            }
        }

        if (num % 3 == 0 && num % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (num % 3 == 0) {
            System.out.println("Fizz");
        } else if (num % 5 == 0) {
            System.out.println("Buzz");
        } else{
            System.out.println(num);
        }
    }
}