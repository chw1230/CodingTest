package thisisCodingTest.dynamicProgramming;

public class Fibonacci_Memoization {
    
    // 한 번 계산된 결과를 메모이제이션(Memoization)하기 위한 배열 초기화
    public static long[] TD = new long[100];
    public static long[] DP = new long[100];

    public static void main(String[] args) {
        System.out.println(fibo_TopDown(50));

        /* 반복문으로 구현(보텀업 다이나믹 프로그래밍) - 상향식*/
        // 첫 번째 피보나치 수와 두 번째 피보나치 수는 1
        DP[1] = 1;
        DP[2] = 1;
        int n = 50; // 50번째 피보나치 수를 계산

        // 피보나치 함수(Fibonacci Function) 반복문으로 구현(보텀업 다이나믹 프로그래밍)
        for (int i = 3; i <= n; i++) {
            DP[i] = DP[i - 1] + DP[i - 2]; // 그떄그떄 하나씩 채워가며 올라감!
        }
        System.out.println(DP[n]);
    }

    private static long fibo_TopDown(int n) {
        /* 재귀함수를 사용하는 탑다움 다이나믹 프로그래밍 - 하향식 */
        // 종료 조건(1 혹은 2일 때 1을 반환)
        if (n == 1 || n == 2) {
            return 1;
        }
        // 이미 계산한 적이 있어 0이 아닌 다른 값이 들어가 있다면 그대로 반환!
        if (TD[n] != 0) {
            return TD[n];
        }
        // 아직 계산하지 않은 문제라면 점화식에 따라서 피보나치 결과 반환!
        TD[n] = fibo_TopDown(n - 1) + fibo_TopDown(n - 2);
        return TD[n];
    }
    /*
    이와 같은 방식으로 구하면 시간을 획기적으로 줄일 수 있음
    이처럼 다이나믹 프로그래밍은 큰 문제를 작게 나누고, 한번 구한 값이라면 더 풀기 않고 그냥 가져오는 방식을 통해서
    효율적으로 문제를 해결하는 프로그래밍이다. 그래서 시작 복잡도는 O(N)임!!

    - 이처럼 재귀함수를 사용해 다이나믹 프로그래밍 소스코드를 작성하는 방법을,
    큰 문제를 해결하기 위해 작은 문제를 호출한다고 하여 탑다운 방식이라고 한다.

    반면, 단순히 반복문을 이용하여 소스코드를 작성하는 경우 작은 문제부터 차근차근 답을 도출한다고 하여 보텀업 방식이라고함

     */
}
