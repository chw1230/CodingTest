import java.util.ArrayList;
import java.util.List;
class Solution {
    static int[][] answer;
    static int j; // 순회하는데 필요한 변수

    static class TreeNode {
        int dataX;
        int dataY;
        int a; // 입력된 순서
        TreeNode left; // 좌측 노드
        TreeNode right; // 우측 노드

        TreeNode(int dataX, int dataY, int a) {
            this.dataX = dataX;
            this.dataY = dataY;
            this.a = a;
        }

        void insert(TreeNode child) {
            if (child.dataX < this.dataX) { // 매개변수로 전달된 노드의 x가 더 작으면 좌측에 추가
                if (this.left == null) { // 좌측에 없으면 바로 추가
                    this.left = child;
                } else { // 있으면 따라 내려가기
                    this.left.insert(child);
                }
            } else {
                if (this.right == null) {
                    this.right = child;
                } else {
                    this.right.insert(child);
                }
            }
        }

        // 전위 순회
        void preorder(TreeNode node) {
            if (node == null) {
                return;
            }
            answer[0][j++] = node.a;
            preorder(node.left);
            preorder(node.right);
        }

        // 후위 순회
        void postorder(TreeNode node) {
            if (node == null) {
                return;
            }
            postorder(node.left);
            postorder(node.right);
            answer[1][j++] = node.a;
        }
    }

    public static int[][] solution(int[][] nodeinfo) {
        answer = new int[2][nodeinfo.length];

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            list.add(new int[]{nodeinfo[i][0], nodeinfo[i][1], i + 1}); // x좌표, y좌표, 입력된 순서로 만들기
        }

        // 1. y 좌표 내림차순 우선, 2. y 좌표가 동일하다면 x 좌표 오름차순
        list.sort((a, b) -> {
            if (a[1] != b[1]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        // 트리 만들기
        TreeNode root = new TreeNode(list.get(0)[0], list.get(0)[1], list.get(0)[2]); // 정렬된 리스트에서 루트 노드의 정보 넘기기
        for (int i = 1; i < list.size(); i++) {
            root.insert(new TreeNode(list.get(i)[0], list.get(i)[1], list.get(i)[2]));
        }

        // 순회
        j = 0;
        root.preorder(root);
        j = 0;
        root.postorder(root);

        return answer;
    }
}