package ru.netology.AndreyS;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


public class Main4 {
    public static void main(String[] args) throws IOException {

        //Задача: Есть файл в котором содержится страница книги.
        // Необходимо считать файл ***
        // и сформировать отсортированную структуру Map.
        // В качестве ключей выступает частота с которой встречается слово.
        // А в качестве значения само слово.


        try (InputStream in = Files.newInputStream(Path.of("pageOfBook"))) {
            List<String> list = new ArrayList<>();
            Scanner scanner = new Scanner(in);
            while (scanner.hasNext()) {
                list.add(scanner.next("\\s*,\\s*\\s*."));


                Map<String, Integer> map = new HashMap<>(); // для подсчёта вхождений
                Map.Entry<String, Integer> maxEntry = null; // будет хранить слово с максимальным числом вхождений


                // "Подсчёт слов" с помощью hashmap
                for (String val : list) { // обходим некоторую коллекцию
                    if (map.containsKey(val)) { // если "слово" уже есть
                        map.put(val, (map.get(val) + 1)); // наращиваем счётчик для данного слова
                    } else {// если такое слово не известно
                        map.put(val, (1)); // добавляем в индекс со значением = 1

                    }

                    // не видит???
                    map.toString(); // не видит???
                    System.out.println(map); // не видит???

                    // не видит???
                    for (Map.Entry<String, Integer> entry : map.entrySet()) {
                        System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
                    }
                }


                // обойдём коллекцию и найдём максимальное значение
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    // если максимум не определен или очередное значение ещё больше
                    if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                        maxEntry = entry; // то присваиваем максимуму новое значение
                    }
                } // после завершения цикла в maxEntry лежит элемент с максимальным value (значением)
            }
        }
    }

}

