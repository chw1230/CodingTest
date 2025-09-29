#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;
// 최소 우선순위 큐
priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq; // 기본 적으로 max heap이라서 설정 바꿔주기
vector<pair<int, int>> graph[1001];
int dist[1001];
int visited[1001];

void dijkstra(int start, int end)
{
	dist[start] = 0; // 시작점 0으로 설정
	pq.push({ 0,start });

	while (!pq.empty())
	{
		int cur = pq.top().second; // 현재 노드
		pq.pop();

		if (visited[cur]) {
			continue; // 방문 했으면 넘어가기
		}

		visited[cur] = 1; // 방문 처리
		for (int i = 0; i < graph[cur].size(); i++)
		{
			int next = graph[cur][i].second; // 다음 노드
			int weight = graph[cur][i].first; // 가중치
			if (dist[next] > dist[cur] + weight) {
				dist[next] = dist[cur] + weight; // 최신화
				pq.push({ dist[next],next }); // 다음 노드 푸쉬
			}
		}
	}
	cout << dist[end];
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(0);

	int N, M;
	cin >> N;
	cin >> M;


	for (int  i = 0; i < M; i++)
	{
		int a, b, weight;
		cin >> a >> b >> weight;
		graph[a].push_back({ weight, b }); // 가중치, 노드 로 넣기!!
	}

	for (int i = 1; i <= N; i++)
	{
		sort(graph[i].begin(), graph[i].end()); // 오름차순 정렬
		dist[i] = 1e8; // 무한대 설정
	}
	int start, end;
	cin >> start >> end;
	dijkstra(start, end);
	return 0;
}