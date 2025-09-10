import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int[] parent;

    private static int findParent(int a) {
        if ( a == parent[a]) {
            return a;
        }
        return parent[a] = findParent(parent[a]);
    }

    private static void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a == b) return;
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N+1]; // 각자 사람의 부모를 담을 노드, 부모를 통한 연결 관계로 집합 표현하기
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken()); // 진실을 아는 사람의 수
        if (num == 0) {
            System.out.println(M);
            return;
        } else {
            int[] truth = new int[num];
            for (int i = 0; i < truth.length; i++) {
                truth[i] = Integer.parseInt(st.nextToken());
            }

            // 진실을 아는 사람든 모두 0 집합으로 넣어버리기
            for (int i = 0; i < num; i++) {
                union(0, truth[i]);
            }
        }

        List<int[]> parties = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken()); // (i+1)파티에 오는 사람 수

            int[] members = new int[num]; // (i+1) 파티에 오는 참석자 명단
            if (num > 0) {
                int first = Integer.parseInt(st.nextToken());
                members[0] = first; // 첫 사람을 저장하기
                for (int j = 1; j < num; j++) {
                    members[j] = Integer.parseInt(st.nextToken());
                    union(first, members[j]); // 첫 번째 사람과 집합 만들기
                }
            }
            parties.add(members); // 참석자 명단을 추가하기
        }

        int cnt = 0; // 거짓말 가능한 파티 수
        for (int[] party : parties) {
            boolean lie = true;
            for (int p : party) {
                if (findParent(p) == 0) { // 참석자 중 0(진실을 아는 집합에 속한다면)이 있으면 거짓말 불가능!
                    lie = false;
                    break;
                }
            }
            if (lie) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}