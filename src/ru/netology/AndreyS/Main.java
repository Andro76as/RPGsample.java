package ru.netology.AndreyS;

import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        // аннонимный внутренний класс от Huntner которы переопределяет функцию attack
        Hunter dima = new Hunter("dima"){
            // можно добавить любые поля и методы
            @Override
            public void attack(Unit target) {
                super.attack(target);
                System.out.println(getName() + " Произвел атаку");
            }
        };
        Hunter roma = new Hunter("roma");
        roma.attack(dima);
        // Вешаем обработчик на событие изменения здоровья через лямбду (аргументы -> возвращаемое значение)
        dima.setOnHpChangeListener(newValue -> System.out.println(dima.getName() + ": Осталось здоровья " + newValue));
        dima.move(3, 4);
        dima.attack(roma);
        dima.attack(dima);
        System.out.println("Осталось здоровья " + roma.getHp());// тест на дальность
        dima.target(roma);
        roma.target(roma);
        roma.attack(dima);
        roma.attack(dima);

        //Сделали подмену цели у цели (ретаргетинг через одного)
        dima.getTarget().target(dima);
        System.out.println(dima);
        System.out.println(roma.getTarget());
        // Проверка входит ли в иерархию наследования
        System.out.println(dima.getTarget() instanceof Target);
        //Жесткая проверка на равенсто классов
        System.out.println("Жесткая проверка " + dima.getClass().equals(Target.class));
        Unit unit = new Unit.Builder()
                .withName("dima")
                .withHp(100)
                .withDmg(5)
                .withLevel(1)
                .build();
        Server server = Server.getInstance();
        Server server1 = Server.getInstance();
        System.out.println(server.equals(server1));
        System.out.println(server);
        System.out.println(server1);


    }


//    Predicate<Integer> isPositive = x -> x >= 0;
//    System.out.println(isPositive.test(5)); // true

}
