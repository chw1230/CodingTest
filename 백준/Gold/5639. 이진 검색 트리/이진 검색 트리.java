import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static class Node {
        int n;
        Node left, right;

        // 초기 루트 설정하기
        public Node(int n) {
            this.n = n;
        }

        public Node(int n, Node left, Node right) {
            this.n = n;
            this.left = left;
            this.right = right;
        }

        public void insert(int num) {
            if (num < this.n) {
                if (this.left == null) {
                    this.left = new Node(num);
                } else {
                    this.left.insert(num);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(num);
                } else {
                    this.right.insert(num);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));
        String str;
        while (true) {
            str = br.readLine();
            if (str == null || str.equals("")) {
                break;
            }
            root.insert(Integer.parseInt(str));
        }
        postOrder(root);
    }

    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }

        postOrder(root.left); // 좌
        postOrder(root.right); // 우
        System.out.println(root.n); // 루트
    }
}