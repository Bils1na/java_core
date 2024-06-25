package org.example.jdk_sem4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
В рамках выполнения задачи необходимо:
1. Создайте коллекцию мужских и женских имен с помощью интерфейса List
2. Отсортируйте коллекцию в алфавитном порядке
3. Отсортируйте коллекцию по количеству букв в слове
4. Разверните коллекцию
 */

public class Task1 {
    public static void main(String[] args) {
        List<String> names = createListNames();
        System.out.println(names);
        System.out.println(sortByAlphabet(names));
        System.out.println(sortByLengthLine(names));
        System.out.println(reverseList(names));
    }

    private static List<String> sortByAlphabet(List<String> list){
//        List<String> result = new ArrayList<>(list);
//        result.sort(null);
//        return result;
        return list.stream().sorted().toList();
    }

    private static List<String> sortByLengthLine(List<String> list){
//        List<String> result = new ArrayList<>(list);
//        result.sort((o1, o2) -> o1.length() - o2.length());
//        return result;
        return list.stream().sorted((o1, o2) -> o1.length() - o2.length()).toList();
    }

    private static List<String> reverseList(List<String> list){
        List<String> result = new ArrayList<>(list);
        Collections.reverse(result);
        return result;
//        return list.stream().sorted(Comparator.reverseOrder()).toList();
    }

    private static List<String> createListNames(){
        List<String> list = new ArrayList<>();
        list.add("Костя");
        list.add("Василий");
        list.add("Семен");
        list.add("Кирилл");
        list.add("Артем");
        list.add("Сергей");

        return list;
    }
}