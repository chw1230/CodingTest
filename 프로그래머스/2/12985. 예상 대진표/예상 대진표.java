class Solution
{
    public static int solution(int n, int a, int b)
    {
        int i;

        // 우리가 신경 써야하는 것은 그냥 오로지 a와 b 나머지는 누가 올라오든 상관이 없음!
        // 그냥 a, b 가 가장 위에서 만난다고 생각하면 됨!
        for (i = 0; a != b; i++) {
            a = (a - 1) / 2 + 1;
            b = (b - 1) / 2 + 1;
        }
        // 인덱스라고 생각해서 -1 하고 +1해주는 과정을 했는데
        /* 그냥 
        a = (a+1) / 2;
        b = (b+1) / 2;
        이렇게 해도 괜찮을 듯
         */

        return i;
    }
}