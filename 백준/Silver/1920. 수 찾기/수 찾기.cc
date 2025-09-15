#include <iostream>
#include <algorithm>

using namespace std;
int arr[100001];

int binary_search(int v, int size) { // 찾을 값, 크기 받기
    int lo = 0;
    int hi = size - 1;

    while (lo <= hi) {
        int mid = (lo + hi) / 2; // 중간 구하기

        if (arr[mid] == v) { // 중간값이 찾는 값과 같으면
            return mid; // 성공
        } else if (arr[mid] < v) { 
            lo = mid + 1; 
        } else {
            hi = mid - 1;
        }
    }
    return -1;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int n = 0;
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    sort(arr, arr + n); // 정렬

    int input = 0, cnt = 0; // 찾을 값, 개수
    cin >> cnt;
    for (int i = 0; i < cnt; i++) {
        cin >> input;
        if (binary_search(input, n) == -1) {
            cout << "0\n";
        } else {
            cout << "1\n";
        }
    }

    return 0;
}