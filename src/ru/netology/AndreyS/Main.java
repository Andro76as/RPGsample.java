package ru.netology.AndreyS;

import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        Hunter dima = new Hunter("dima");
        Hunter roma = new Hunter("roma");

        dima.move(3,4);
        dima.attack(roma);
        dima.attack(dima);
        System.out.println("Осталось здоровья " + roma.getHp());// тест на дальность
        System.out.println("Осталось здоровья " + dima.getHp());// тест на урон самого себя
    }

//    Predicate<Integer> isPositive = x -> x >= 0;
//    System.out.println(isPositive.test(5)); // true

}
