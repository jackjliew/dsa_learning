package gmail.jackjliew.test;

import java.util.ArrayList;
import java.util.List;

public class TreeSum {
    public static void main(String[] args) {
        int[] numbers = {1, -1, 2, 3, 4, -9, 8, 11, -67};
            int count = numbers.length;
            int acc = 0;
            System.out.println("number count: " + count);
            List<List<Integer>> combinations = new ArrayList<>();
            List<List<Integer>> results = new ArrayList<>();
            for (int i = 0; i < count - 2; i++) {

                for (int j = i + 1; j < count - 1; j++) {

                    for (int k = j + 1; k < count; k++) {
                        System.out.println("[" + i + ", " + j + ", " + k + "]");
                        acc++;
                        List<Integer> item = new ArrayList<>();
                        item.add(i);
                        item.add(j);
                        item.add(k);
                        combinations.add(item);

                        if (numbers[i] + numbers[j] + numbers[k] == 0) {
                            List<Integer> zero_item = new ArrayList<>();
                            zero_item.add(numbers[i]);
                            zero_item.add(numbers[j]);
                            zero_item.add(numbers[k]);
                            results.add(zero_item);
                        }
                    }
                }
            }

        System.out.println("acc=" + acc);
        System.out.println("target=" + 9 * 8 * 7 / 6);
        System.out.println("combinations size: " + combinations.size());
        System.out.println("results size: " + results.size());

        for (List<Integer> item : results) {
            for (Integer i : item) {
                System.out.print(i + ", ");
            }
            System.out.println("");
        }
    }
}
