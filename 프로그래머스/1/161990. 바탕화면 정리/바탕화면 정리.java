class Solution {
    public static int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int minR = Integer.MAX_VALUE;
        int minC = Integer.MAX_VALUE;
        int maxR = Integer.MIN_VALUE;
        int maxC = Integer.MIN_VALUE;

        for (int i = 0; i < wallpaper.length; i++) {
            char[] chars = wallpaper[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '#') {
                    minR = Math.min(minR, i);
                    minC = Math.min(minC, j);
                    maxR = Math.max(maxR, i);
                    maxC = Math.max(maxC, j);
                }
            }
        }

        answer[0] = minR;
        answer[1] = minC;
        answer[2] = maxR + 1;
        answer[3] = maxC + 1;
//        for (int i : answer) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
        return answer;
    }
}