package animalslist;

import java.util.Date;
import java.util.LinkedList;

public class Dog  extends DomesticAnimal{

    public Dog(String name, Date dateOfBirth) {
        super(name, dateOfBirth);
    }

    public Dog(String name, Date dateOfBirth, LinkedList<String> commands) {
        super(name, dateOfBirth, commands);
    }
}
