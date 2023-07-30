package animalslist;

import java.util.Date;
import java.util.LinkedList;

public abstract class PackAnimal extends Animal {

    public PackAnimal(String name, Date dateOfBirth) {
        super(name, dateOfBirth);
    }

    public PackAnimal(String name, Date dateOfBirth, LinkedList<String> commands) {
        super(name, dateOfBirth, commands);
    }
}
