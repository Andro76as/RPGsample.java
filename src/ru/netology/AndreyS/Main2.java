package ru.netology.AndreyS;

import java.util.*;

public class Main2 {
    static Random r = new Random();

    static String genName() {
        String result = "";
        //StringBuilder result = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            char symbol = (char) (97 + r.nextInt(25));
            result += symbol;
        }
        return result;

    }

    public static void main(String[] args) {
        List<Unit> unitList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            unitList.add(new Unit(genName(), r.nextInt(20), r.nextInt(100), r.nextInt(10)));
            System.out.println(unitList.get(i));
        }
        // System.out.println(unitList.get(0));

        unitList.sort((o1, o2) -> {
            if (o1.getHp() > o2.getHp()) {
                return 1;

            } else if (o1.getHp() < o2.getHp()) {
                return -1;
            }
            return 0;
        });
        //System.out.println(unitList);
        unitList.toString();  // ? не сортирует
        // System.out.println(unitList.toString());

//        Queue<String> unitQueue = new ArrayDeque<>();
//        unitQueue.offer("Dima");
//        unitQueue.offer("Oleg");
//        unitQueue.offer("Slava");
//        System.out.println(unitQueue.toString());
//        unitQueue.poll();
//        System.out.println(unitQueue);

        Map<String,Integer> unitHashMap = new HashMap<>();
        unitHashMap.put("Dima",27);
        unitHashMap.put("Oleg",33);
        unitHashMap.put("Slava",40);
        unitHashMap.put("Igor",50);
        unitHashMap.remove("Oleg");
        System.out.println(unitHashMap.get("Slava"));
        System.out.println(unitHashMap.containsValue(27)); // вернет true если значение есть
        System.out.println(unitHashMap.size());
        System.out.println(unitHashMap.entrySet());
        System.out.println(unitHashMap.keySet());
        System.out.println(unitHashMap.values());
        System.out.format("Возраст Игоря %d лет %n", unitHashMap.get("Igor"));

        Map<Unit,Integer> unitMap = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            unitMap.put(new Unit(genName(),1,1,1), r.nextInt(10));
            System.out.println(unitMap); // как вернуть одно значение при одном прохождении цикла
        }
        System.out.println(unitMap.entrySet());
        for (Integer name :
                unitMap.values()) {
            System.out.println(unitMap.entrySet());
        }
        Map<Unit,Long> testMap = new HashMap<>();
        Unit unit1 = new Unit("Dima",1,1,1);
        Unit unit2 = new Unit("Dima",1,1,1);

        testMap.put(unit1,1L);
        testMap.put(unit2,2L);


        System.out.println(testMap);





    }
}
