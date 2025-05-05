package thisisCodingTest.Tree;

public class BinaryTreeTraversal {

    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    // 루트 노드
    TreeNode root;

    // 전위 순회
    static void preorder(TreeNode root){ // 루트 - 좌 - 우
        if (root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // 중위 순회
    static void inorder(TreeNode root){ // 좌 - 루트 - 우
        if (root == null) return;
        inorder(root.left); // 좌측
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // 후위 순회
    static void postorder(TreeNode root){ // 좌 - 우 - 루트
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
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

        // 전위 순회 ( 루트 , 좌 , 우 )
        preorder(root);
        System.out.println("\n");

        // 중위 순회 ( 좌 , 루트 , 우)
        inorder(root);
        System.out.println("\n");

        // 후위 순회 ( 좌 , 우 , 루트 )
        postorder(root);
    }
}
