package SecondSemesterWork;

import java.util.ArrayList;

public class Node implements Comparable<Node>{
    private int value;
    private int color;
    private ArrayList<Node> edges;

    public Node(int value) {
        this.value = value;
        color = 0;
        edges = new ArrayList<>();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public ArrayList<Node> getEdges() {
        return edges;
    }

    public void addEdge(Node node) {
        edges.add(node);
    }

    public String toString() {
        return value + "";
    }

    @Override
    public int compareTo(Node o) {
        return value - o.getValue();
    }
}
