package thisisCodingTest.DFS_BFS;

public class Node {

    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public void show() {
        System.out.print("( 노드 : " + this.index + ", 거리 : " + this.distance + ") ");
    }
}
