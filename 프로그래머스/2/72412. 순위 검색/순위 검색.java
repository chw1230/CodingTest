import java.util.*;

class Solution {
    
    // 나올 수 있는 문자열과 점수 리스트를 저장할 map
    static HashMap<String, ArrayList<Integer>> map;

    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        map = new HashMap<>();

        for (String i : info) {
            String[] p = i.split(" ");
            makeInfo("", 0, p);
        }

        // 점수의 경우 이분 탐색을 하기 위해서 점수들을 정렬하기
        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }

        // 사람을 찾을려는 쿼리에서 "and"를 ""으로 바꾸기
        for (int i = 0; i < query.length; i++) {
            query[i] = query[i].replaceAll(" and ", ""); // 문자열 붙이기
            String[] q = query[i].split(" "); // 문자와 점수를 분리

            String key = q[0]; // 문자
            int target = Integer.parseInt(q[1]); // 점수

            // 조건에 맞는 리스트가 있다면 이분 탐색
            if (map.containsKey(key)) {
                ArrayList<Integer> list = map.get(key); // 점수 리스트
                int left = 0;
                int right = list.size();

                while (left < right) {
                    int mid = left + (right - left) / 2;

                    if (list.get(mid) >= target) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                answer[i] = list.size() - left;
            } else {
                answer[i] = 0;
            }
        }

        return answer;
    }

    // 나오는 경우의 수를 모두 다 생성하기
    private static void makeInfo(String str, int depth, String[] info) {
        if (depth == 4) {
            // 4가지 조건(언어, 직군, 경력, 소울푸드) 을 모두 넣은 경우라면
            if (!map.containsKey(str)) {
                map.put(str, new ArrayList<>());
            }
            // Map에 점수(info[4]) 저장
            map.get(str).add(Integer.parseInt(info[4]));
            return;
        }

        // 직접 명시되는 경우와 '-'를 통해서 찾을 수 있는 경우 둘로 나누어 생각하기

        // 직접 명시되는 경우
        makeInfo(str + info[depth], depth + 1, info);
        // '-'를 통해서 찾을 수 있는 경우
        makeInfo(str + "-", depth + 1, info);
    }
}