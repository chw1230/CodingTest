import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int len = jobs.length;
        // ps - Process 요청 시간 순으로 정렬한 배열
        Process[] ps = new Process[len];
        for (int i = 0; i < len; i++) {
            ps[i] = new Process(i, jobs[i][0], jobs[i][1]);
        }
        // 요청 순으로 정렬
        Arrays.sort(ps, (a, b) -> Integer.compare(a.start, b.start));

        // pq - 특정 시간이 되었을 때 작업 가능한 Process 중 누굴 가져와서 작업을 할지 담을 PQ
        PriorityQueue<Process> pq = new PriorityQueue<>();
        int time = 0; // 현 시간
        int idx = 0; // 다음으로 PS에서 가져와서 대기열에 넣을 작업의 위치
        int complete = 0; // 완료한 작업 수
        long sum = 0; // 반환 시간 합

        while (complete < len) {
            // 특정 시간이 되었을 때, 작업 가능 한 애들을 PQ로 가져오기!
            while (idx < len && ps[idx].start <= time) {
                pq.add(ps[idx++]);
            }

            // 작업 가능 한 애가 있는 곳으로 시간을 이동 시켜 버리기 -> 유휴 시간은 스킵 해버리는 것!
            if (pq.isEmpty()) {
                time = ps[idx].start;
                continue;
            }

            Process p = pq.poll();
            time += p.time;
            sum += time - p.start;
            complete++; // Process 작업 완료
        }

        return (int) (sum / len);

    }

    class Process implements Comparable<Process> {
        int num;
        int start;
        int time;

        public Process(int num, int start, int time) {
            this.num = num;
            this.start = start;
            this.time = time;
        }

        @Override
        public int compareTo(Process o) {
            // 소요 시간 짧 - 오름
            if (this.time != o.time) {
                return Integer.compare(this.time, o.time);
            }

            // 요청 시간 짧 - 오름
            if (this.start != o.start) {
                return Integer.compare(this.start, o.start);
            }

            // 번호 - 오름
            if (this.num != o.num) {
                return Integer.compare(this.num, o.num);
            }

            return 0;
        }
    }
}