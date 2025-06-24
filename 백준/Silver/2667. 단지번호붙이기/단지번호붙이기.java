import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 좌, 우, 하, 상
    static int moveX[] = {-1, 1, 0, 0};
    static int moveY[] = {0, 0, -1, 1};
    static int arr[][];
    static int N;
    static List<Integer> list;
    static int cnt = 0;
   
    public static int DFS(int x, int y){
        if (x <= -1 || y <= -1 || x >= N || y >= N) {
            return 0; // 벗어나는 경우
        }

        if (arr[y][x] == 1){ // 집이 발견되면 
            arr[y][x]++; // 방문 처리
            cnt++; // 집의 수 키우기
            for (int i = 0; i < 4; i++) {
                DFS(x+moveX[i], y+moveY[i]);
            }
            return cnt; // 집의 수를 반환하기
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        list = new LinkedList<>();

        for (int i = 0; i < N; i++) { // 배열 만들기
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int n = DFS(j, i);
                if (n != 0){ // DFS가 집의 수를 반환하도록 하고, 이 수가 0이면 패스 아니면 리스트에 저장 
                    list.add(n);
                    cnt = 0; // 한 단지에 해당하는 집의 수 초기화
                }
            }
        }

        Collections.sort(list); // 오름 차순 정렬
        System.out.println(list.size()); // 단지 수 출력
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i)); // 한 단지에 해당하는 집의 수 출력 
        }
    }
}