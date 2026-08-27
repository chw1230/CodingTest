class Solution {
    public static int solution(int[] wallet, int[] bill) {
        int answer = 1;

        // 지갑
        int wRow = wallet[0]; // 가로
        int wCol = wallet[1]; // 세로
        
        // 안 접고도 가능한 경우
        if ((bill[0] <= wRow && bill[1] <= wCol) || (bill[0] <= wCol && bill[1] <= wRow)) {
            return 0;
        } 

        // 접기 시작한 경우
        while (true) {
            // 지갑에 들어가니?
            if (check(wRow, wCol, bill)) {
                break;
            }
            answer++;
        }
        return answer;
    }

    private static boolean check(int wRow, int wCol, int[] bill) {
        if (bill[0] < bill[1]) {
            bill[1] /= 2;
        } else {
            bill[0] /= 2;
        }
        int bRow = bill[0];
        int bCol = bill[1];
        if (bRow <= wRow && bCol <= wCol) {
            return true;
        } else if (bRow <= wCol && bCol <= wRow) {
            return true;
        } else {
            return false;
        }
    }
}