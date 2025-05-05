package thisisCodingTest.Tree;

public class BinaryTreeCountNode {

    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    // 루트 노드
    TreeNode root;

    // 노드의 개수 세기
    static int countNode(TreeNode root) {
        if ( root == null){return 0;}
        return 1 + countNode(root.left) + countNode(root.right); // 이 코드가 실행될때의 루트 노드(1개) + 루트의 자식(좌) + 루트의 자식(우)
    }

    // 리프 노드의 개수 세기
    static int countLeafNode(TreeNode root) {
        if ( root == null){return 0;} // 트리가 비었으면 리프 없음
        else if ((root.left == null) && (root.right == null)) {
            return 1; // 리프 노드 -> 자식 노드가 없는 경우
        }
        return countLeafNode(root.left) + countLeafNode(root.right);
    }

    // Non 리프 노드의 개수 세기
    static int countNonLeafNode(TreeNode root) {
        if ( root == null){return 0;}
        if (root.left == null && root.right == null) {return 0;}  // 리프 노드는 제외
        return 1 + countNonLeafNode(root.left) + countNonLeafNode(root.right);
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

        System.out.println("노드의 개수 : "+countNode(root));
        System.out.println("리프 노드의 개수 : "+countLeafNode(root));
        System.out.println("비(非) 리프 노드의 개수 : "+countNonLeafNode(root));
    }
}
