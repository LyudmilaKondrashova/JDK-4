package HomeWork4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ArrayList<Person> persons = new ArrayList<Person>(
                List.of(
                        new Person(1, "123456", "Alex", 10),
                        new Person(2, "495860", "Carl", 12),
                        new Person(3, "111111", "Alex", 20),
                        new Person(4, "895602029847", "Mark", 2),
                        new Person(5, "444", "Olga", 23),
                        new Person(6, "937475", "Marina", 1),
                        new Person(7, "3947", "Carl", 10)
                )
        );

        System.out.println("СПИСОК ВСЕХ СОТРУДНИКОВ:");
        persons.forEach(System.out::println);
        System.out.println();

        System.out.println("------Поиск сотрудников по стажу:------");
        String[] experPersons = findByExperience(persons, 10);
        System.out.println("Сотрудники со стажем 10 лет: ");
        printPersons(experPersons);
        experPersons = findByExperience(persons, 12);
        System.out.println("Сотрудники со стажем 12 лет: ");
        printPersons(experPersons);
        experPersons = findByExperience(persons, 33);
        System.out.println("Сотрудники со стажем 33 года: ");
        printPersons(experPersons);
        System.out.println();

        System.out.println("------Поиск телефонов сотрудников по имени:------");
        String[] personByName = findPhoneByName(persons, "Alex");
        System.out.println("Телефоны сотрудников с именем Alex:");
        printPersons(personByName);
        personByName = findPhoneByName(persons, "Peter");
        System.out.println("Телефоны сотрудников с именем Peter:");
        printPersons(personByName);
        personByName = findPhoneByName(persons, "Marina");
        System.out.println("Телефоны сотрудников с именем Marina:");
        printPersons(personByName);
        System.out.println();

        addNewPerson(persons, "49857657", "Max", 22);
        addNewPerson(persons, "12847", "Tom", 0);
        System.out.println("СПИСОК ВСЕХ СОТРУДНИКОВ ПОСЛЕ ДОБАВЛЕНИЯ НОВЫХ:");
        persons.forEach(System.out::println);
        System.out.println();

        System.out.println("------Поиск сотрудника по табельному номеру:------");
        System.out.println("Сотрудник с табельным номером 2:");
        printPerson(findById(persons, 2));
        System.out.println("Сотрудник с табельным номером 8:");
        printPerson(findById(persons, 8));
        System.out.println("Сотрудник с табельным номером 13:");
        printPerson(findById(persons, 13));

    }

    // Поиск сотрудника по стажу
    static String[] findByExperience(List<Person> list, int experience) {
        return list.stream().filter(p -> p.getExperience() ==
                experience).map(p -> p.toString()).toArray(String[]::new);
    }

    // Поиск телефонов сотрудников по имени
    static String[] findPhoneByName(List<Person> list, String name) {
        return list.stream().filter(p -> p.getName().equalsIgnoreCase(name))
                .map(p -> p.getPhone()).toArray(String[]::new);
    }

    // Добавление нового сотрудника
    static void addNewPerson(List<Person> list, String phone, String name, int experience) {
        int lastId = list.stream().mapToInt(Person::getPersonId).max().getAsInt();
        list.add(new Person(lastId + 1, phone, name, experience));
    }

    // Поиск сотрудника по табельному номеру
    static Person findById(List<Person> list, int id) {
        var findPerson = list.stream().filter(p -> p.getPersonId() ==
                id).findAny();
        if (findPerson.isPresent()) {
            return findPerson.get();
        }
        return null;
    }

    // Печать найденного списка сотрудников
    static void printPersons(String[] list) {
        if (list.length == 0) {
            System.out.println("    No find such persons!");
        } else {
            for (String person : list) {
                System.out.println("    " + person);
            }
        }
    }

    // Печать отдельного сотрудника
    static void printPerson(Person person) {
        if (person == null) {
            System.out.println("    No find such person!");
        } else {
            System.out.println(person.toString());
        }
    }

}