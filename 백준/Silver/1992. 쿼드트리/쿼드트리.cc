#include<iostream>
using namespace std;

int arr[64][64];

bool check(int y, int x, int size) {
	int first = arr[y][x];
	for (int i = y; i < y + size; i++) {
		for (int j = x; j < x + size; j++) {
			if (arr[i][j] != first) {
				cout << "(";
				return false;
			}
		}
	}
	return true;
}

void div(int y, int x, int size) {
	if (size == 1) {
		cout << arr[y][x];
		return;
	}

	if (!check(y, x, size)) {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				div(y + i * size / 2, x + j * size / 2, size / 2); // 4등분하기
			}
		}
		// 4등분 다 했으면 괄호 닫기
		cout << ")";
	}
	else {
		cout << arr[y][x];
		return;
	}

}

int main() {
	int n;
	cin >> n;

	for (int i = 0; i < n; i++) {
		string line;
		cin >> line; // 한 줄 전체 읽어오기
		for (int j = 0; j < n; j++) {
			arr[i][j] = line[j] - '0'; // 숫자로 바꾸기
		}
	}

	div(0, 0, n);
}