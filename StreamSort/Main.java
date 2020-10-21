package StreamSort;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        List<Integer> positivList = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();

        // Отфильтруйте положительные числа.
        for (int i = 0; i < intList.size(); i++) {
            if (intList.get(i) > 0) {
                positivList.add(intList.get(i));
            }
        }
        System.out.println(positivList);//    Выведите результат на экран.

        //     Найдите среди этих положительных чисел четные.
        for (int i = 0; i < positivList.size(); i++) {
            if (positivList.get(i) % 2 == 0) {
                evenList.add(positivList.get(i));
            }
        }
        System.out.println(evenList);//    Выведите результат на экран.


        //       Отсортируйте отфильтрованные числа в порядке возрастания.

        Collections.sort(evenList);

        System.out.println(evenList);//    Выведите результат на экран.

    }
}
