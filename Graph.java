package SecondSemesterWork;

import java.util.ArrayList;
import java.util.Stack;

public class Graph {
    private int iterations = 0;
    private long sortingTime;
    private ArrayList<Node> nodes;
    private Stack<Node> stack = new Stack<>();

    public Graph(ArrayList<Node> nodes) {
        this.nodes = nodes;
    }

    public boolean sort() {
        sortingTime = System.nanoTime();
        //produce bypass in depth for each vertex by checking the graph on cyclical
        for (Node node : nodes)
            if (DFS(node))
                return false;
        //new positions for nodes
        for (int i = 1; i <= nodes.size(); i++)
            stack.pop().setValue(i);

        sortingTime = System.nanoTime() - sortingTime;
        return true;
    }

    private boolean DFS(Node node) {
        final int GREY = 1, BLACK = 2;
        iterations++;
        //finish if black
        if (node.getColor() == BLACK)
            return false;
        //if gray that means graph is cyclic
        if (node.getColor() == GREY)
            return true;

        node.setColor(GREY);
        //process the list of edges nodes
        for (Node edgeNode : node.getEdges())
            if (DFS(edgeNode))
                return true;

        stack.push(node);
        node.setColor(BLACK);
        return false;
    }

    public void printGraphData(){
        System.out.println(nodes);
        for (Node node : nodes) {
            System.out.print(node + ": ");
            System.out.println(node.getEdges());
        }
    }

    public void printSortedNodes() {
        if (sort())
            System.out.println("Sorted graph: " + nodes);
        else
            System.out.println("Cyclic graph.");

        System.out.println("Number of iterations: " + iterations);
        System.out.println("Soring time: " + sortingTime + "нс\n");
    }
}
