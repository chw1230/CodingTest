package thisisCodingTest.Tree;

public class BinaryTreeCountHeight {

    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    // 루트 노드
    TreeNode root;

    // 트리의 높이 구하기 ( 트리의 높이 : 루트에서 가장 깊은 리프 노드까지의 경로에 포함된 노드의 개수 )
    static int countHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(countHeight(root.left), countHeight(root.right));
    }

    public static void main(String[] args) {
        // 초기화 하기
        TreeNode n0 = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        n1.right = n0;

        TreeNode n2 = new TreeNode(4);
        n2.left = n1;

        TreeNode n3 = new TreeNode(16);

        TreeNode n7 = new TreeNode(3);
        TreeNode n8 = new TreeNode(100);

        TreeNode n4 = new TreeNode(25);
        n4.left = n8;
        n4.right = n7;

        TreeNode n5 = new TreeNode(20);
        n5.left = n3;
        n5.right = n4;

        TreeNode n6 = new TreeNode(15);
        n6.left = n2;
        n6.right = n5;

        TreeNode root = n6; // 루트 노드

        System.out.println("트리의 높이 : "+ countHeight(root));
    }
}
