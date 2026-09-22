import java.util.ArrayList;
import java.util.List;

class Solution {
    public static int solution(int[] picks, String[] minerals) {
        int answer = 0;

        int diaCnt = 0;
        int ironCnt = 0;
        int stoneCnt = 0;
        List<Group> list = new ArrayList<>();

        int totalPicks = picks[0] + picks[1] + picks[2];
        int len = Math.min(totalPicks * 5, minerals.length);
        // 5개씩 자르기
        for (int i = 0; i < len; i++) {
            if (minerals[i].equals("diamond")) {
                diaCnt++;
            } else if (minerals[i].equals("iron")) {
                ironCnt++;
            } else if (minerals[i].equals("stone")) {
                stoneCnt++;
            }

            // 5개가 모이면
            if ((i + 1) % 5 == 0 || i == len - 1) {
                list.add(new Group(diaCnt, ironCnt, stoneCnt));

                // 다음 뭉탱이를 위한 초기화
                diaCnt = 0;
                ironCnt = 0;
                stoneCnt = 0;
            }

        }
        list.sort((a, b) -> b.v - a.v);

        // 여기까지 오면 정렬된 그룹이 들어가 있음!
        // 무조건 다이아 - 철 - 돌 순으로
        int idx = 0; // 뭉탱이를 순서대로 꺼내기위하 인덱스
        for (int i = 0; i < 3; i++) {
            if (idx >= list.size()) {
                break;
            }

            if (picks[i] == 0) {
                continue;
            }

            Group g = list.get(idx++);

            if (i == 0 && picks[i] > 0) { // 다이아 도구가 있는 경우
                if (g == null) {
                    break;
                }
                answer += g.dia + g.iron + g.stone;
            }
            if (i == 1 && picks[i] > 0) { // 철 도구가 있는 경우
                if (g == null) {
                    break;
                }
                answer += g.dia * 5 + g.iron + g.stone;
            }
            if (i == 2 && picks[i] > 0) { // 돌 도구가 있는 경우
                if (g == null) {
                    break;
                }
                answer += g.v;
            }

            picks[i]--; // 도구 사용 정리
            if (picks[i] > 0) { // 남아잇으면 한번 더
                i--;
            }
        }

        return answer;
    }

    public static class Group implements Comparable<Group> {
        int dia;
        int iron;
        int stone;
        int v; // 5개 뭉탱ㅇ이의 가치 -> 정렬에 사용

        // 중요도 계산
        public Group(int dia, int iron, int stone) {
            this.dia = dia;
            this.iron = iron;
            this.stone = stone;
            this.v = dia * 25 + iron * 5 + stone;
        }

        // 중요도로 정렬
        @Override
        public int compareTo(Group o) {
            // 피로도가 높은 순서대로 (내림차순) 정렬
            return o.v - this.v;
        }

        @Override
        public String toString() {
            return "dia: " + dia + ", iron: " + iron + ", stone: " + stone;
        }
    }
}