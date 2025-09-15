#include <iostream>

using namespace std;

int arr[1025][1025];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M;
    cin >> N >> M;

    for (int i = 1; i <= N; ++i) {
        for (int j = 1; j <= M; ++j) {
            int value;
            cin >> value;
            arr[i][j] = value + arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1];
        }
    }

    int K;
    cin >> K;

    while (K--) {
        int x1, y1, x2, y2;
        cin >> x1 >> y1 >> x2 >> y2;

        int sum = arr[x2][y2] - arr[x2][y1 - 1] - arr[x1 - 1][y2] + arr[x1 - 1][y1 - 1];
        
        cout << sum << "\n";
    }

    return 0;
}