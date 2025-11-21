import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int max = Integer.MIN_VALUE;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        // 이동 시 다른 블록들도 함께 이동해야 한다는 사항을 잊고 있었음!
        // 단일 블럭의 이동이 아니라 전체 블럭이 이동할 수 있어야함!!
        // 아오 죽겠슈 ㅜㅜ
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i][j]);
            }
        }

        dfs(0, arr);
        System.out.println(max);
    }

    private static void dfs(int cnt, int[][] arr) {
        // max 값을 최대화
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                max = Math.max(max, arr[i][j]);
            }
        }

        if (cnt == 5) { // 종료 조건
            return;
        }

        for (int i = 0; i < 4; i++) {
            int[][] next = move(arr, i); // 배열과 이동방향
            dfs(cnt + 1, next);
        }
    }

    // arr : 현재 보드 상태, dir : 방향 (0: 위, 1: 아래, 2: 왼쪽, 3: 오른쪽)
    private static int[][] move(int[][] arr, int dir) {
        int[][] res = new int[n][n]; // 이동 결과를 담을 새로운 보드

        if (dir == 0) { // 위로 이동
            for (int c = 0; c < n; c++) {
                int[] tmpC = new int[n]; // 열 하나를 복사 시킬 배열 생성해두기

                int idx = 0;
                // 일단 0을 제외하고 따닥따닥 모아두기
                for (int r = 0; r < n; r++) {
                    if (arr[r][c] != 0) {
                        tmpC[idx++] = arr[r][c]; //  2 0 2 이렇게 있어도 일단 0을 제외 하고 2 2 이렇게 모으기
                        // 다음 더하기 부분에서 더 할 것임!
                    }
                }

                // 더하기
                for (int j = 0; j < idx - 1; j++) {
                    if (tmpC[j] != 0 && tmpC[j] == tmpC[j + 1]) { // 0이 아니고 같은 수가 맞다은 부분은
                        tmpC[j] *= 2; // 수 하나에 곱하기 2하기
                        tmpC[j + 1] = 0; // 위로 더해진 것 이니까 아래에 있는 수는 0 으로 바꿔주기
                    }
                }

                // 아래에서 위로 더해져서 공간에 0이 생김 이 0을 없애고 수를 다시 한번 위로 땡겨주기
                int[] line = new int[n];
                int q = 0;
                for (int j = 0; j < n; j++) {
                    if (tmpC[j] != 0) { // 0 만 쏙 빼고 값을 넣어 주기
                        line[q++] = tmpC[j];
                    }
                }

                // 위로 붙여진 열(line)을 결과에 반영하기
                for (int r = 0; r < n; r++) {
                    res[r][c] = line[r];
                }
            }

        } else if (dir == 1) { // 아래로 이동
            for (int c = 0; c < n; c++) {
                int[] tmpC = new int[n];

                int idx = 0;
                // 아래쪽으로 모으기
                for (int r = n - 1; r >= 0; r--) {
                    if (arr[r][c] != 0) {
                        tmpC[idx++] = arr[r][c];
                    }
                }

                // 더하기
                for (int j = 0; j < idx - 1; j++) {
                    if (tmpC[j] != 0 && tmpC[j] == tmpC[j + 1]) {
                        tmpC[j] *= 2;
                        tmpC[j + 1] = 0;
                    }
                }

                // 0 제거하고 다시 아래쪽으로 붙이기
                int[] line = new int[n];
                int q = 0;
                for (int j = 0; j < n; j++) {
                    if (tmpC[j] != 0) {
                        line[q++] = tmpC[j];
                    }
                }

                // 아래에서부터 채워 넣기
                for (int r = 0; r < n; r++) {
                    res[n - 1 - r][c] = line[r];
                }
            }

        } else if (dir == 2) { // 왼쪽으로 이동
            for (int r = 0; r < n; r++) {
                int[] tmpR = new int[n];

                int idx = 0;
                // 왼쪽으로 숫자 몰기 (0을 제외하고)
                for (int c = 0; c < n; c++) {
                    if (arr[r][c] != 0) {
                        tmpR[idx++] = arr[r][c];
                    }
                }

                // 더하기
                for (int j = 0; j < idx - 1; j++) {
                    if (tmpR[j] != 0 && tmpR[j] == tmpR[j + 1]) {
                        tmpR[j] *= 2;
                        tmpR[j + 1] = 0;
                    }
                }

                // 0 제거하고 다시 왼쪽으로 붙이기
                int[] line = new int[n];
                int q = 0;
                for (int j = 0; j < n; j++) {
                    if (tmpR[j] != 0) {
                        line[q++] = tmpR[j];
                    }
                }

                // 결과에 왼쪽부터 채우기
                for (int c = 0; c < n; c++) {
                    res[r][c] = line[c];
                }
            }

        } else if (dir == 3) { // 오른쪽으로 이동
            for (int r = 0; r < n; r++) {
                int[] tmpR = new int[n];

                int idx = 0;
                // 오른쪽 끝에서부터 모으기
                for (int c = n - 1; c >= 0; c--) {
                    if (arr[r][c] != 0) {
                        tmpR[idx++] = arr[r][c];
                    }
                }

                // 더하기
                for (int j = 0; j < idx - 1; j++) {
                    if (tmpR[j] != 0 && tmpR[j] == tmpR[j + 1]) {
                        tmpR[j] *= 2;
                        tmpR[j + 1] = 0;
                    }
                }

                // 0 제거하고 다시 오른쪽으로 붙이기
                int[] line = new int[n];
                int q = 0;
                for (int j = 0; j < n; j++) {
                    if (tmpR[j] != 0) {
                        line[q++] = tmpR[j];
                    }
                }

                // 결과에 오른쪽부터 채우기
                for (int c = 0; c < n; c++) {
                    res[r][n - 1 - c] = line[c];
                }
            }
        }
        return res;
    }
} 