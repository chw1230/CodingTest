import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<work> pq = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            pq.offer(new work(i, t, s));
        }

        while (!pq.isEmpty()) {
            work w = pq.poll();
            System.out.print(w.i + " ");
        }
    }

    static class work implements Comparable<work> {
        int i;
        int t; // 시간
        int s; // 비용

        public work(int i, int t, int s) {
            this.i = i;
            this.t = t;
            this.s = s;
        }

        @Override
        public int compareTo(work o) {
            if (o.s * this.t == this.s * o.t) { // 둘의 시간대비 걸리는 비용이 같다면
                return this.i - o.i; // 작업 idx의 오름차순으로 정렬하기
            } else {
                /*
                this = (3, 4)   // t=3, s=4
                o = (1, 1000)   // t=1, s=1000
                라고 생각 해보자! 그러면
                3000 - 4 이니까 결과가 0보다 크네? 그러면 o가 this 보다 우선 순위가 높다!! 이런식으로 생각
                */
                return o.s * this.t - this.s * o.t;
            }
        }
    }
}