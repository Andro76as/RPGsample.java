package ru.netology.AndreyS;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ru.netology.AndreyS.Main2.genName;
import static ru.netology.AndreyS.Main2.r;

public class StreamAPI {
    public static void main(String[] args) {
        Stream<Integer> stream1 = Stream.of(1, 10, 1);  //поток чисел
        List<Integer> list = stream1.collect(Collectors.toList());
        System.out.println(list);
        System.out.println(stream1.hashCode());

//        Optional<Integer> max = stream1.max(Integer::compareTo);
//        max.ifPresent(i -> System.out.println(i));

        List<String> names = new ArrayList<>();
        names.add("Oly");
        names.add("Pety");
        names.add("Stas");
        names.add("Alex");
        List<String> filtredList = names.stream().filter(i -> i.length() > 3).collect(Collectors.toList());
        System.out.println(filtredList);
        System.out.println(names);
        System.out.println(names.stream().map(i -> i.length()).collect(Collectors.toList()));
        System.out.println(names.stream().sorted(String::compareTo).collect(Collectors.toList()));
        System.out.println(names.stream().allMatch(i -> i.length() >= 3));
        System.out.println(names.stream().anyMatch(it -> it.equals("Oly")));
        names.stream().forEach(it -> System.out.println(it));
        System.out.println(names.stream().count());


        Stream<Unit> unitStream = Stream.of(genUnit(), genUnit(), genUnit(), genUnit());
        List<Unit> unitList = unitStream.toList();
        System.out.println(unitList);

        Optional<Unit> unit = aiTarget(unitList);
        unit.ifPresent(it -> System.out.println(it));
        System.out.println(unit.stream().count());


        List<Unit> unitSort = sortByLevel(unitList);
        unitSort.forEach(it -> System.out.println(it));

        main1(args);
    }

    private static Optional<Unit> aiTarget(List<Unit> unitList) {       // Optional или List
        return unitList.stream().min(Comparator.comparing(Unit::getHp));

    }

    private static List<Unit> sortByLevel(List<Unit> unitList) {   // Optional или List
        return unitList.stream().sorted(Comparator.comparing(Unit::getLevel)).collect(Collectors.toList());

    }

    private static Unit genUnit() {
        return new Unit(genName(), r.nextInt(20), r.nextInt(100), r.nextInt(10));

    }

    public static void main1(String[] args) {
        //Сформировать структуру MAP гле в качестве ключей выступают Level Unit .
        // а в качестве значений будет количество их с таким Level

        Map<Integer, Long> map;
        Stream<Unit> unitStream = Stream.of(genUnit(), genUnit(), genUnit(), genUnit());
        List<Unit> unitList = unitStream.toList();
        System.out.println(unitList);

        map = unitList.stream().collect(Collectors.groupingBy(Unit::getLevel, Collectors.counting()));
        System.out.println(map);



        //Сформировать структуру MAP гле в качестве ключей выступают Level Unit . а в качестве значений эти самые Unit
        Map<Integer, List<String>> map1;
        Stream<Unit> unitStream1 = Stream.of(genUnit(), genUnit(), genUnit(), genUnit());
        List<Unit> unitList1 = unitStream1.toList();
        System.out.println(unitList1);

        map1 = unitList1.stream().collect(Collectors.groupingBy(Unit::getLevel, Collectors.mapping(Unit::getName,Collectors.toList())));
        System.out.println(map1);

    }

}

