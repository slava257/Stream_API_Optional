package me.slava.safronov;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(14);
        list.add(48);
        list.add(51);
        list.add(54);
        list.add(147);
        list.add(169);
        list.add(1);
        System.out.println("Task 1");
        findMinMax(list.stream().parallel(), Integer::compareTo, ((integer, integer2) -> System.out.println(integer + " " + integer2)));
        System.out.println("Task 2");
        System.out.println(printTheNumberOfEvenNumbers(list) + " количество четных чисел");

    }

    //Задание 1
    //Напишите метод public static void findMinMax, который будет находить в стриме минимальный и максимальный элементы в соответствии с порядком, заданным Comparator'ом.
    //Данный метод принимает на вход 3 элемента:
    //Stream <? extends T> stream
    //Comparator <? super T> order
    //BiConsumer <? super T, ? super T> minMaxConsumer
    //Найденные минимальный и максимальный элементы передавайте в
    //minMaxConsumer
    // следующим образом:
    //minMaxConsumer.accept(min, max);
    //Если стрим не содержит элементов, то вызывайте:
    //minMaxConsumer.accept(null, null);
    public static <T> void findMinMax(Stream<? extends T> stream, Comparator<? super T> order, BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<? extends T> list = stream.toList();
        minMaxConsumer.accept(list.stream().min(order).orElse(null), list.stream().max(order).orElse(null));

    }

    //Задание 2
//Реализуйте метод, который принимает на вход список целых чисел,
// определяет в списке количество четных чисел и выводит их в консоль.
// Решите задание именно с применением Stream API.
    public static long printTheNumberOfEvenNumbers(List<Integer> list) {
        return list.stream().filter(i -> i % 2 == 0).count();
    }
}