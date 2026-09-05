class Solution {
    static int[] sale = new int[]{10, 20, 30, 40};
    static int[] curSale;
    static int maxSubscriber = 0;
    static int maxCost = 0;

    public static int[] solution(int[][] users, int[] emoticons) {
        // 현재 n번째 이모티콘에 어떤 할인을 적용했는지 나타낼 배열
        curSale = new int[emoticons.length];


        // 첫번째 이모티콘부터 -> 0
        dfs(0, users, emoticons);

        int[] answer = new int[]{maxSubscriber, maxCost};

        for (int i : answer) {
            System.out.println(i);
        }

        return answer;
    }

    // DFS 탐색 시작 , 첫 번째 이모지부터 시작
    private static void dfs(int i, int[][] users, int[] emoticons) {
        // 마지막 이모지까지 다 돈 경우
        if (i == emoticons.length) {

            int cost = 0;
            int subscriber = 0;
            // 이모티콘당 할인률이 다 매칭이 되었을 것임!
            for (int j = 0; j < users.length; j++) {
                // j 번째 사람의 구매합!
                int sum = 0;
                for (int k = 0; k < emoticons.length; k++) {
                    // 현재 할당된 할인률이 내가 계획한 할인률보다 큰 경우에만 이모티콘을 구매
                    if (curSale[k] >= users[j][0]) {
                        sum += emoticons[k] * (100 - curSale[k]) / 100;
                    }
                }

                // 총합이 특정 금액 보다 크면
                if (sum >= users[j][1]) {
                    subscriber++;
                } else {
                    cost += sum;
                }
            }

            // 구독자수와 이용금액 모두 최대가 되는 것이 목표
            if (subscriber > maxSubscriber) {
                maxSubscriber = subscriber;
                maxCost = cost;
            } else if (subscriber == maxSubscriber) { // 구독은 같은데
                maxCost = Math.max(maxCost, cost); // 비용도 최대로 최신화
            }
            return;
        }

        for (int j = 0; j < 4; j++) {
            curSale[i] = sale[j]; // 할인률을 하나로 특정하고
            dfs(i + 1, users, emoticons); // 다음 이모티콘으로 넘어가기
            // row가 이모티콘, col이 할인률인 배열이라고 생각해보기
        }
    }
}