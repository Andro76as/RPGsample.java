package ru.netology.AndreyS;

import org.w3c.dom.Text;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;

import static java.time.temporal.TemporalAdjusters.next;

public class Main3 {
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
            }

            Map<String, Integer> map = new HashMap<>(); // для подсчёта вхождений

        }
    }

}