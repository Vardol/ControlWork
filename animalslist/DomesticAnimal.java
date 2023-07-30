package animalslist;

import java.util.Date;
import java.util.LinkedList;

public abstract class DomesticAnimal extends Animal{
    public DomesticAnimal(String name, Date dateOfBirth) {
        super(name, dateOfBirth);
    }

    public DomesticAnimal(String name, Date dateOfBirth, LinkedList<String> commands) {
        super(name, dateOfBirth, commands);
    }
}
