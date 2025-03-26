package thisisCodingTest.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 주어진 문자열을 최소 횟수로 뒤집기
진짜로 바꾸는 과정을 하지 않고 2개의 그룹(0->1을 인식하는 그룹, 1->0을 인식하는 그룹)을 만들어서 변화되는 지점을 찾아 값 키워주기
두 값 비교 후 작은 값 출력
 */
public class BOJ1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // 그룹을 생성 0그룹과 1그룹으로 나누기
        int cntZero = 0;
        int cntOne = 0;

        char c = str.charAt(0);

        // 문자를 모두 돌며 그룹이 바뀔 때마다 수를 올려주기
        for (int i = 1; i < str.length(); i++) {
            if (c != str.charAt(i)) { // 이전 그룹과 지금 그룹을 비교
                if (str.charAt(i) == '1') {  // 이전 그룹과 반대되는 그룹의 수를 올려주기  0->1 , 1->0 이런 상황!
                    cntZero++;
                } else{
                    cntOne++;
                }
            }
            c = str.charAt(i); // 다음 문자로 옮기기 전에 c에 지금 문자 저장
        }

        // 마지막 문자 그룹은 그냥 끝나기 때문에 비교 대상이 없으므로 마지막 그룹을 대상으로 그룹 개수 하나 올려주기
        if (c == '0') {
            cntZero++;
        } else {
            cntOne++;
        }

//        System.out.println(cntOne);
//        System.out.println(cntZero);
        System.out.println((cntOne > cntZero) ? cntZero : cntOne);
    }

}
