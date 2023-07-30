package animalslist;

import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static Animal generateAnimal(String type, String name, String dateOfBirth, LinkedList<String> commands) {
        type = type.toLowerCase();
        switch (type) {
            case "dog":
                return new Dog(name, new Date(dateOfBirth), commands);
            case "cat":
                return new Cat(name, new Date(dateOfBirth), commands);
            case "hamster":
                return new Hamster(name, new Date(dateOfBirth), commands);
            case "horse":
                return new Horse(name, new Date(dateOfBirth), commands);
            case "camel":
                return new Camel(name, new Date(dateOfBirth), commands);
            case "donkey":
                return new Donkey(name, new Date(dateOfBirth), commands);
            default:
                return null;
        }
    }

    public static Animal generateAnimal(String type, String name, String dateOfBirth) {
        type = type.toLowerCase();
        switch (type) {
            case "dog":
                return new Dog(name, new Date(dateOfBirth));
            case "cat":
                return new Cat(name, new Date(dateOfBirth));
            case "hamster":
                return new Hamster(name, new Date(dateOfBirth));
            case "horse":
                return new Horse(name, new Date(dateOfBirth));
            case "camel":
                return new Camel(name, new Date(dateOfBirth));
            case "donkey":
                return new Donkey(name, new Date(dateOfBirth));
            default:
                return null;
        }
    }

    public static void showAnimal(Animal animal) {
        if (animal instanceof Dog) {
            System.out.print("dog ");
        }

        if (animal instanceof Cat) {
            System.out.print("cat ");
        }

        if (animal instanceof Hamster) {
            System.out.print("hamster ");
        }

        if (animal instanceof Horse) {
            System.out.print("horse ");
        }

        if (animal instanceof Camel) {
            System.out.print("camel ");
        }

        if (animal instanceof Donkey) {
            System.out.print("donkey ");
        }

        System.out.print(animal.getName() + ", born on " + animal.getDateOfBirth() + ". ");
        System.out.print("Known commands:");
        if (animal.getCommands() != null) {
            for (String command : animal.getCommands()) {
                System.out.print(" " + command + ",");
            }
            System.out.println("");
        } else {
            System.out.println(" -");
        }
    }


    private static void printHelp() {
        System.out.println("Список доступных команд:");
        System.out.println("- show -> отображение всех животных.");
        System.out.println("- find -> поиск животного по имени и отображение его данных.");
        System.out.println("- add -> добавление животного.");
        System.out.println("- command -> добавление команды животному.");
        System.out.println("- help -> вывод списка команд.");
        System.out.println("- exit -> выход.");
    }

    static String checkQuit(String input) {
        String[] QUITVALUES = {"quit", "exit", "close", "stop"};
        if (input == null || input.length() == 0) {
            return input;
        }
        for (String string : QUITVALUES) {
            if (string.equalsIgnoreCase(input)) {
                System.exit(0);
            }
        }
        return input;
    }

    public static void main(String[] args) {

        System.out.println("Добро пожаловать в реестр животных.");
        printHelp();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nВведите команду. Для выхода - exit.");

            String command = checkQuit(scanner.nextLine()).toLowerCase();
            if (command.length() == 0) {
                System.out.println("Пустой ввод.\n");
                continue;
            }

            switch (command) {
                case "add":
                    System.out.print("Что это будет за животное (dog/cat/hamster/horse/donkey/camel) - ");
                    String animalType = checkQuit(scanner.nextLine()).toLowerCase();

                    System.out.print("Кличка животного - ");
                    String animalName = checkQuit(scanner.nextLine()).toLowerCase();

                    System.out.print("Дата рождения (в формате MM/DD/YYYY) - ");
                    String animalDate = checkQuit(scanner.nextLine());

                    try {
                        Animal newAnimal = generateAnimal(animalType, animalName, animalDate);
                        if (newAnimal != null) {
                            DBHandler.addAnimal(newAnimal);
                            System.out.println("Успешно.");
                            break;
                        } else {
                            System.out.println("некорректный ввод!");
                            break;
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("некорректный ввод!");
                        break;
                    }

                case "command":
                    System.out.print("введите кличку (имя) животного для добавления команды - ");
                    String name = checkQuit(scanner.nextLine());
                    if (DBHandler.fetchAnimal(name) == null) {
                        System.out.println("Животное не найдено");
                        break;
                    } else {
                        System.out.print("введите новую команду - ");
                        String newCommand = checkQuit(scanner.nextLine()).toLowerCase();
                        DBHandler.addCommand(name, newCommand);
                        System.out.println("Успешно.");
                        break;
                    }

                case "find":
                    System.out.print("введите кличку (имя) искомого животного - ");
                    String searchedName = checkQuit(scanner.nextLine()).toLowerCase();
                    if (DBHandler.fetchAnimal(searchedName) == null) {
                        System.out.println("Животное не найдено");
                        break;
                    } else {
                        showAnimal(DBHandler.fetchAnimal(searchedName));
                    }
                    break;

                case "show":
                    if (DBHandler.getAnimals() != null && DBHandler.getAnimals().size() > 0) {
                        for (Animal animal : DBHandler.getAnimals()) {
                            showAnimal(animal);
                        }
                        break;
                    } else {
                        System.out.println("Пока нет животных!");
                        break;
                    }

                case "help":
                    printHelp();
                    break;

                default:
                    System.out.println("Нераспознанная команда.");
                    break;
            }
            System.out.println("");
            System.out.println("---------------");
            System.out.println("");

        }


    }
}
