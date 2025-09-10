import java.util.HashSet;

class Solution {
// x좌표 이동, y좌표 이동
    static int U[] = {0, 1};
    static int D[] = {0, -1};
    static int L[] = {-1, 0};
    static int R[] = {1, 0};

    public static int solution(String dirs) {

        int current[] = {0, 0}; // 현재위치 좌표 -> 초기값(0,0) => (x,y)
        int newX;
        int newY;

        HashSet<String> answerSet = new HashSet<>();
        for (int i = 0; i < dirs.length(); i++) { // 움직이기
            if (dirs.charAt(i) == 'U') {
                newX = current[0];
                newY = current[1] + U[1];
            } else if (dirs.charAt(i) == 'D') {
                newX = current[0];
                newY = current[1] + D[1];
            } else if (dirs.charAt(i) == 'R') {
                newX = current[0] + R[0];
                newY = current[1];
            } else {
                newX = current[0] + L[0];
                newY = current[1];
            }

            if (-5 <= newX && newX <= 5 && -5 <= newY && newY <= 5) { // 반영
                answerSet.add(current[0] + "," + current[1] + "/" + newX + "," + newY); // x,y 에서 nX,nY 로 이동
                answerSet.add(newX + "," + newY + "/" + current[0] + "," + current[1]); // nX,nY 에서 x,y 로 이동
                // 둘다 넣는 이유? => 0,0에서 1,0 가는 경우랑 1,0에서 0,0으로 가는 경우에 1개로 인식해야함!
                // 그래야 문제에서 요구하는 중복된 경우를 처리할 수 있음
                // set을 이용하니까!

                // 이동한 좌표에 대해서 최신화
                current[0] = newX;
                current[1] = newY;
            }
        }

        return answerSet.size() / 2; // a->b , b->a 둘 다 추가된 상태이기에 나누기 2하기
    }
}