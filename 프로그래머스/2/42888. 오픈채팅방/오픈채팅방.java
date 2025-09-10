import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    // 마지막에 String 형식으로 바꾸는 방법이 어려웠음
    public String[] solution(String[] record) {
        String str[][] = new String[record.length][3];
        Map<String, String> map = new HashMap<>(); // 유저 아이디(고유값), 닉네임

        for (int i = 0; i < record.length; i++) { // map의 상태 최종 상태로 만들기
            // 공통으로 이용하는 부분
            str[i][0] = record[i].split(" ")[0];
            str[i][1] = record[i].split(" ")[1];

            if (str[i][0].equals("Enter") || str[i][0].equals("Change")) { // map에 추가 + 수정
                str[i][2] = record[i].split(" ")[2];
                map.put(str[i][1], str[i][2]);
            }
            /* 오답의 이유 만약에 예시로 주어진 상황은 나가고 들어왔기에 id, 닉네임 이렇게 잘 등록이 됨 하지만
            * 나갔다가 들어오지 않는 경우라면? 밑에서 map에 없는데 불러서 null이 나갔습니다. 와 같은 일이 벌어짐!
            * 그래서 나간 경우에 map에서 지우지 말고 그냥 유지 시켜 줘야 한다!
            * 그러면 없으면 출력은 id를 통해서 나갔을 때의 닉네임이 출력되고, 다시 들어왔다면 id를 통해서 닉네임이 최신화 됨!
            - 오답 부분
            else { // 삭제
                map.remove(str[i][1]);
            }
             */
        }
//        System.out.println(map);

        List<String> list = new ArrayList<>();
        for (int i = 0; i < record.length; i++) {
            if (str[i][0].equals("Enter")) {
                list.add(map.get(str[i][1]) + "님이 들어왔습니다.");
            } else if (str[i][0].equals("Leave")) {
                list.add(map.get(str[i][1]) + "님이 나갔습니다.");
            }
        }
        return list.toArray(new String[0]);
    }
}