#include <iostream>
#include <algorithm>
using namespace std;

int arr[10001];
long long K,N;

bool decision(long long cur) { // cur 길이로 몇개 만들 수 있는지 구하기
    long long cnt = 0;
    for (int i = 0; i < K; i++) {
        cnt += arr[i] / cur;
    }

    return cnt >= N;
    /* 
    802
    743
    457
    539
    ------
    만약 1600이라면 0 0 0 0 -> 0개
    만약 800이라면 1 0 0 0 -> 1개
    만약 400이라면 2 1 1 1 -> 5개
    만약 200이라면 4 3 2 2 -> 11개 이런식으로!!
    */
}

long long maximization() {
    long long lo = 1; // 가장 작은 길이
    long long hi = (1<<31) - 1; // 가장 큰 길이

    while (lo <= hi) {
        long long mid = (lo + hi + 1) / 2; // 중간 구하기 -> 왜? +1을 해야하는가? -> lo = mid에서 무한루프 도는 경우가 생김!

        // 구한 중간 값으로 몇개를 만들 수 있는지 확인하기
        if ( decision(mid) ) { // mid 길이로 N개 이상 만들 수 있으면
            lo = mid + 1; // 더 큰 길이로 탐색
        } else {
            hi = mid - 1; // 더 작은 길이로 탐색
        }
    }
    return hi;
}

int main () {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    cin >> K >> N;

    for (int i = 0; i < K; i++) {
        cin >> arr[i];
    }

    cout << maximization();
    return 0;
}