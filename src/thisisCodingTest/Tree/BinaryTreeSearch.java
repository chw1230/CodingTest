package thisisCodingTest.Tree;

public class BinaryTreeSearch {

    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    // 루트 노드
    TreeNode root;

    // 트리 속 data 값 찾기
    static TreeNode SearchValue(TreeNode root,int data) {
        if (root == null) return null;
        if (root.data == data) return root;

        TreeNode left = SearchValue(root.left, data); // 좌측에서 찾기
        if (left != null) return left; // 좌측에 원하는 값이 있었다면 null이 아닌 값이 반환될 거기 때문에 이와 같이 조건잡기

        return SearchValue(root.right, data); // 우측 찾기
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

        System.out.println((SearchValue(root,15)==null) ? null : SearchValue(root,15).data);
    }
}
