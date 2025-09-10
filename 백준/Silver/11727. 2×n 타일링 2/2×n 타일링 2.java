import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N+1];

        arr[1] = 1;
        if (N == 1) {
            System.out.println(arr[1]);
            return;
        }
        arr[2] = 3;

        for (int i = 3; i <= N; i++) {
            arr[i] = (arr[i-1] + arr[i-2] * 2)%10007;
        }
        System.out.println(arr[N]);

        /*
        * arr[i] = arr[i-1] + arr[i-2] * 2 -> 점화식을 이렇게 세운 이유
        * 1. | => 1개
        * 2. ㅁ => 3개
        * 3. ||| => |||  , ㅁ| , =| , |= , |ㅁ 이렇게 되어 있음
        * 이것을 분류 하면 
        * (1번){ || or ㅁ or = }와 같은 [i-1]번째에 도형이 추가된 형태와
        * (2번){ | }와 같은 [i-2]번째 도형에 추가된 형태로 시작 것
        * 이렇게 분류 할 수 있음!
        * (1번) [i-1] 번째 도형에 | 만 추가되는 것 이므로 [i-1]번째 도형의 개수와 동일
        * (2번) [i-2] 번째 도형에 ㅁ, = 와 같은 도형이 추가되는 것 이므로 [i-2] 도형의 개수에 2를 곱하는 식을 세울 수 있음
        */
    }
}