#include<iostream>
using namespace std;

int cnt_1 = 0, cnt0 = 0, cnt1 = 0;
int arr[2200][2200];

bool isSame(int y, int x, int size) { // 모두 같은 수로 이루어져 있는지 확인
	int first = arr[y][x];
	for (int i = y; i < y + size; i++) {
		for (int j = x; j < x + size; j++) {
			if (arr[i][j] != first) {
				return false;
			}
		}
	}
	return true;
}

void div(int y, int x, int size) {
	if (isSame(y, x, size)) { // 모두 같은 수로 이루어져 있는지 확인
		if (arr[y][x] == -1) {
			cnt_1++;
		}
		else if (arr[y][x] == 0) {
			cnt0++;
		}
		else {
			cnt1++;
		}
		return;
	}

	int newSize = size / 3; // 새로운 크기
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			div(y + i * newSize, x + j * newSize, newSize); // 9등분하여 재귀 호출
		}
	}
}

// 분할정복
int main() {
	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> arr[i][j];
		}
	}
	div(0, 0, n); // (y, x, size)
	cout << cnt_1 << "\n" << cnt0 << "\n" << cnt1;
	return 0;
}