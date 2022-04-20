package ru.netology.AndreyS;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main1 {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "Hello ";
        Consumer<Integer> consumer = t -> System.out.println("Принято число:" + t);
        System.out.println(supplier.get());
        consumer.accept(5);

        // Function - переход от одного типа к дрегому
        Function<Integer, String> hp = dmg -> 100 - dmg + " Процентов здоровья";
        System.out.println(hp.apply(5));

        //Predicate - соблюдение условия

        Predicate<Integer> level = t -> t >= 0;
        System.out.println(level.test(5) + " Пока еще жив"); // hp - нельзя записать
        
    }
}
