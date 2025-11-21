#include <bits/stdc++.h>
using namespace std;

int n, m;
int arr[500][500];
bool visited[500][500];
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, -1, 0, 1};
int maxVal = INT_MIN;

// 범위 체크
bool inRange(int x, int y) {
    return (0 <= x && x < n && 0 <= y && y < m);
}

// DFS(백트래킹)
void dfs(int x, int y, int sum, int cnt) {
    if (cnt == 4) { // 블럭 4개 선택한 경우 합으로 최대값 최신화하기
        maxVal = max(maxVal, sum);
        return;
    }

    for (int dir = 0; dir < 4; dir++) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (!inRange(nx, ny)) continue;
        if (visited[nx][ny]) continue;

        // ㅗ 모양 처리를 위해서 개수 가 2개인 경우에 위치를 고정한 상태에서 dfs 실시하기
        if (cnt == 2) {
            /*
                 ㅁ
              ㅁ  O  ㅁ
              여기서 O가 (x, y)이고,
              세 방향으로 뻗어나가는 모양을 만들기 위해
              (x, y)는 고정한 채로 nx, ny만 더해주는 구조
            */
            visited[nx][ny] = true;
            dfs(x, y, sum + arr[nx][ny], cnt + 1);
            visited[nx][ny] = false;
        }

        // 일반적인 DFS 진행 (길쭉한 한줄 형태들로 이어지는 모양, ㅗ 모양 x)
        visited[nx][ny] = true;
        dfs(nx, ny, sum + arr[nx][ny], cnt + 1);
        visited[nx][ny] = false;
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> arr[i][j];
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            visited[i][j] = true;
            dfs(i, j, arr[i][j], 1); // 시작 칸 포함해서 시작위치, 시작 위치의 값, cnt = 1 전달
            visited[i][j] = false;
        }
    }

    cout << maxVal << '\n';
    return 0;
}
