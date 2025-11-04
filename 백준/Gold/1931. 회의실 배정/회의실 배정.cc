#include <iostream>
#include <queue>
#include <utility>
#include <vector>

using namespace std;

int N;
pair<int, int> j[1000001];

void solve() {
	int cnt = 0;
	priority_queue<
		pair<int, int>,
		vector<pair<int, int>>,
		greater<pair<int, int>> 
	> pq;

	for (int i = 0; i < N; i++) {
		pq.push(j[i]);
	}


	int start, end;
	int last = 0;
	while (!pq.empty()) {
		start = pq.top().second;
		end = pq.top().first;
		pq.pop();

		if (start >= last) {
			cnt++;
			last = end;
		}
	}
	cout << cnt << "\n";
}


int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

	cin >> N;

	for (int i = 0; i < N; i++) {
		int s, e; 
		cin >> s >> e;
		j[i] = make_pair(e, s); // 종료 시간, 시작 시간 담기
	}

	solve();
}