package SecondSemesterWork;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GraphGenerator {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Graph> graphs = new ArrayList<>();
        ArrayList<Node> nodes;

        Scanner scanner = new Scanner(new File("arrays.txt"));
        while (scanner.hasNext()) {
            nodes = new ArrayList<>();
            //считываем вершины и добавляем в список
            for (String number : scanner.nextLine().split(" "))
                nodes.add(new Node(Integer.valueOf(number)));
            //генерируем смежные вершины
            for (int i = 0; i <= nodes.size() - nodes.size() / 3; i++)
                for (int j = 2; j < nodes.size() / 3; j++)
                    nodes.get(i).addEdge(nodes.get(i + j));
            //создаем граф из вершин и добавляем в список графов
            graphs.add(new Graph(nodes));
        }
        //выводим данные о сортировке для кажждого графа
        for (Graph graph : graphs)
            graph.printSortedNodes();
    }
}
