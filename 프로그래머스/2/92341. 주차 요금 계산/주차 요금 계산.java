import java.util.TreeMap;

class Solution {
    static TreeMap<String, String> InTime; // 차량번호, 출입 시간
    static TreeMap<String, Integer> totalTime; // 차량번호, 총 이용시간
    static TreeMap<String, Integer> fee; // 차량번호, 이용 가격

    public static int[] solution(int[] fees, String[] records) {
        InTime = new TreeMap<>();
        totalTime = new TreeMap<>();
        fee = new TreeMap<>();

        int basicTime = fees[0]; // 기본 시간(분)
        int basicFee = fees[1]; // 기본 요금(원)
        int plusTime = fees[2]; // 단위 시간(분)
        int plusFee = fees[3]; // 단위 요금(원)

        for (String record : records) {
            String[] r = record.split(" "); // 공백을 기준으로 나누기
            String time = r[0]; // 시간
            String number = r[1]; // 차 번호
            String inout = r[2]; // 출, 입차 여부

            if (inout.equals("IN")) { // 들어오면
                InTime.put(number, time); // 출입에 넣기
            } else {
                // 이미 in에서 저장을 해둔 정보에 값을 더하기
                String[] t1 = InTime.get(number).split(":"); // IN으로 입력된 시간
                String[] t2 = time.split(":");  // OUT으로 입력된 시간

                int hour = Integer.parseInt(t2[0]) - Integer.parseInt(t1[0]);
                int min = Integer.parseInt(t2[1]) - Integer.parseInt(t1[1]);
                if (min < 0) {
                    hour -= 1;
                    min += 60;
                }
                min = hour * 60 + min;

                int v = totalTime.getOrDefault(number, 0); // 주차 방문이 2번 이상인 경우를 대비해서 기존 이용 시간에 더하기
                totalTime.put(number, min + v);

                InTime.remove(number); // 들어온 기록을 지우기 -> 지워야 입차하고 나가지 않는 것을 잡을 수 있음
            }
        }

        // 입차하고 나가지 않는 것 잡기
        for (String s : InTime.keySet()) {
            String intime = InTime.get(s); // 해당 차량의 입차 시간을 가져오기
            String[] t1 = InTime.get(s).split(":");

            int hour = 23 - Integer.parseInt(t1[0]);
            int min = 59 - Integer.parseInt(t1[1]);
            min = 60 * hour + min; // 분으로 변환

            int v = totalTime.getOrDefault(s, 0);
            totalTime.put(s, min + v); // 추가
        }

        // -- 시간을 가격으로 --

        for (String s : totalTime.keySet()) {
            String num = s;
            int time = totalTime.get(s);
            fee.put(num, basicFee); // 기본 요금 추가

            if (time > basicTime) { // 이용시간이 기본 시간 보다 큰 경우
                time -= basicTime;

                int overTime = time / plusTime;

                if (time % plusTime != 0) {
                    overTime += 1;
                }
                fee.put(num, basicFee + overTime * plusFee);
            }
        }
//        System.out.println(fee);

        return fee.values().stream().mapToInt(Integer::intValue).toArray();
    }
}