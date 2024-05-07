package org.uzum.iggytoto.javacore_streams;

import org.uzum.iggytoto.javacore_streams.model.Person;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * Класс для реализации домашнего задания номер три, часть 2.
 */
public class Homework3_2 {

    /**
     * Реализовать метод при помощи {@link java.util.stream.Stream} который:
     * - группирует заданых персон по возрасту
     * - фильтрует по минимальному возрасту
     * - Убирает дубликаты персон по имени
     * @param persons - заданный список персон
     * @param minimalAgeFilter - указанный минимальный возраст
     * @param removeDupes - флаг отвечающий за исключение дубликатов из результата
     * @return словарь где ключ возраст а значение лист персон с этим возрастом
     */
    public Map<Integer, List<Person>> groupByAge(List<Person> persons, int minimalAgeFilter,  boolean removeDupes) {
        Stream<Person> personStream = persons.stream();

        Map<Integer, List<Person>> groupedByAge = persons.stream()
                .filter(person -> minimalAgeFilter <= 0 || person.getAge() >= minimalAgeFilter)
                .collect(Collectors.groupingBy(Person::getAge));

        if (removeDupes) {
            groupedByAge.replaceAll((age, personList) ->
                    personList.stream()
                            .collect(Collectors.toMap(Person::getName, p -> p, (existing, replacement) -> existing))
                            .values()
                            .stream()
                            .collect(Collectors.toList())
            );
        }

        return groupedByAge;
    }
}
