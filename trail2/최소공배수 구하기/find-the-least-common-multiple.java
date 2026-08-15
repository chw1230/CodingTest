import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int r = lcm(n, m);
        System.out.println(r);
    }

    // 최대공약수
    public static int gcd(int n, int m) {
        int tmp = 0;
        while ( m != 0 ) {
            tmp = m;
            m = n % m;
            n = tmp;
        }

        return n;
    }

    // 최소공배수
    public static int lcm(int n, int m) {
        return ( n*m ) / gcd(n,m);
    }
}