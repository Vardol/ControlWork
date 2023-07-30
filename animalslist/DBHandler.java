package animalslist;//Класс отвечающий за хранение данных
// в моем случае будет просто хранить список в статическом LL
// в реальности должен был бы писать данные в DB или файл и считывать с оттуда

import java.util.LinkedList;

public class DBHandler {
    private static LinkedList<Animal> animals = new LinkedList<>();

    public static void addAnimal(Animal animal) {
        DBHandler.animals.add(animal);
    }

    public static LinkedList<Animal> getAnimals() {
        return DBHandler.animals;
    }

    public static Animal fetchAnimal(String name) {
        if (DBHandler.animals != null) {
            for (Animal animal : DBHandler.animals) {
                if (animal.getName().equalsIgnoreCase(name)) {
                    return animal;
                }
            }

        }
        return null;
    }

    public static void addCommand(String name, String command) {
        if (DBHandler.fetchAnimal(name) != null) {
            DBHandler.fetchAnimal(name).addCommand(command);
        }
    }
}
