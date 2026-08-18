class Solution {
    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        // 가로가 세로보다 길다 + 노란색 격자의 수는 1이상 이다 -> 그러면 세로의 최소 길이는 3이다 => 양쪽에 있으니까 6

        int width = 0;
        int height = 3; // 최소 3부터 시작

        int Y = 0;
        while (true) {
            Y = (height - 2) * ((brown - height * 2) / 2);
            if ( Y == yellow) {
                break;
            }
            height++;
        }
        width = (((brown - height * 2) / 2) + 2);

//        System.out.println("width: " + width + " height: " + height);
        answer[0] = width;
        answer[1] = height;
        return answer;
    }
}