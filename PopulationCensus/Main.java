package PopulationCensus;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        // Найти количество несовершеннолетних (т.е. людей младше 18 лет).
        long count = persons.stream()
                .filter( p -> p.getAge() < 18)
                .count();
        System.out.println(count);

        //Получить список фамилий призывников (т.е. мужчин от 18 и до 27 лет).
    List list= persons.stream()
                .filter(p -> p.getAge() >=18 )
                .filter(p -> p.getAge() < 27 )
                 .map(p -> p.getFamily())
                .collect(Collectors.toList());
        System.out.println(list);

        //Получить отсортированный по фамилии список потенциально работоспособных людей с высшим образованием в выборке (т.е. людей с высшим образованием от 18 до 60 лет для женщин и до 65 лет для мужчин).
      List result =  persons.stream()
                .filter(p -> (p.getAge() >= 18 && p.getAge()  <= 65 && p.getSex() ==Sex.MAN) || (p.getAge() >= 18 && p.getAge()  <= 60 && p.getSex() == Sex.WOMEN))
                .map(p -> p.getFamily())
              .sorted()
              .collect(Collectors.toList());
        System.out.println(result);














    }
}
