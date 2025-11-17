#include <iostream>
using namespace std;

int n;
int a[301];
int dp[301];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr); 
	cin >> n;

	for (int i = 1; i <= n; i++) {
		cin >> a[i];
	}

	if ( n == 1) {
		cout << a[1];
		return 0;
	}

	if ( n == 2) {
		cout << a[1] + a[2];
		return 0;
	}

	if ( n == 3) {
		cout << max(a[1] + a[3], a[2] + a[3]);
		return 0;
	}

	dp[1] = a[1];
	dp[2] = a[1] + a[2];
	dp[3] = max(a[1] + a[3], a[2] + a[3]); // 3개쭉 밟을 수 없음

	for (int i = 4; i <=  n; i++) { // i 라는 칸에 왔을 때 있을 수 있는 상태 -> 연속 1칸 밟고 온 경우, 연속 2칸 밟고 온 경우
		dp[i] = max(dp[i - 2] + a[i], dp[i - 3] + a[i - 1] + a[i]);
	}

	cout << dp[n];
	return 0;
}