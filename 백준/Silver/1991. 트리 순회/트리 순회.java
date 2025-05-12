import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class TreeNode {
        char data;
        TreeNode left;
        TreeNode right;

        public TreeNode(char data) {
            this.data = data;
        }
    }

    static TreeNode[] nodes = new TreeNode[100];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            char b = st.nextToken().charAt(0);
            char c = st.nextToken().charAt(0);

            if (nodes[a - 'A'] == null) {
                nodes[a - 'A'] = new TreeNode(a);
            }

            if (b != '.') {
                if (nodes[b - 'A'] == null) {
                    nodes[b - 'A'] = new TreeNode(b);
                }
                nodes[a - 'A'].left = nodes[b - 'A'];
            }

            if (c != '.') {
                if (nodes[c - 'A'] == null) {
                    nodes[c - 'A'] = new TreeNode(c);
                }
                nodes[a - 'A'].right = nodes[c - 'A'];
            }
        }

        TreeNode root = nodes[0];
        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
    }

    // 전위 순회
    public static void preorder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data);
        preorder(node.left);
        preorder(node.right);
    }

    // 중위 순회
    public static void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.data);
        inorder(node.right);
    }

    //후위 순회
    public static void postorder(TreeNode node) {
        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data);
    }
}