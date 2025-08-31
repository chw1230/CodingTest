import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 문자열 다루는 유형이 많이 부족 한 것 같다
    // 해결방안도 생각이 잘 안나고, 해결 속도도 느림
    // 문자열 문제 많이 풀어보기
    // 패턴에 대한 고민 , 무조건 자르고 확인하고 자르고 확인하는 생각에서 벗어나기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        char[] str = br.readLine().toCharArray();

        int answer = 0; // 정답 개수
        int cnt = 0; // Pn이 맞는지 확인하기 위한 변수/ OI의 연속 횟수

        for (int idx = 0; idx < M - 2; idx++) {
            if (str[idx] == 'I' && str[idx + 1] == 'O' && str[idx + 2] == 'I') {
                cnt++;
                // IOI 가 되면 cnt를 하나 키워주기
                if (cnt == N) { // cnt가 N과 같으면 요구한 Pn이 하나 만들어지는 것
                    answer++; // 정답하나 올려주기
                    cnt--; // 완성한 정답에서 IO 패턴을 버리고 나머지를 사용하기 위해서 cnt 하나 감소시켜주기
                }
                // IOI 이후에 I가 오거나 O가 올 수 있음 하지만 우리가 굳이 거기로 갈 필요 있을까?
                // 우린 정답으로만 가면 되는데 그렇다면 IOI이후에 뭐가 오는지 신경 쓰지 말고 두칸 뛰어 간 값으로 가서 IOI를 만족하는지 확인하자!
                // 그래서 여기에서 idx++ 하고 for 문에서 idx++ 해서 두칸 건너뛰어서 확인하도록 하기
                idx++;
            } else {
                // IOI 가 아니라면 IOI를 만들기 위해 쌓아온 것을 리셋!
                cnt = 0;
            }
        }
        System.out.println(answer);
    }
}