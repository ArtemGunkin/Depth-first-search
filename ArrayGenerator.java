package SecondSemesterWork;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class ArrayGenerator {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("graphArrays.txt");
        ArrayList<Integer> list;
        int count = 10;

        while (count <= 100) {
            list = new ArrayList<>();
            for (int i = 0; i < count; i++)
                list.add(i);
            list.sort(new RandomComparator());
            for (int number: list)
                writer.write(number + " ");
            writer.write("\n");
            count += 5;
        }

        writer.flush();
        writer.close();
    }

    private static class RandomComparator implements java.util.Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            Random random = new Random();
            int a = random.nextInt(10) - 5;
            if (a > 0)
                return 1;
            if (a < 0)
                return -1;
            return 0;
        }
    }
}
