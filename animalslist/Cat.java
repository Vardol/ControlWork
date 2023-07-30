package animalslist;

import java.util.Date;
import java.util.LinkedList;

public class Cat extends DomesticAnimal{

    public Cat(String name, Date dateOfBirth) {
        super(name, dateOfBirth);
    }

    public Cat(String name, Date dateOfBirth, LinkedList<String> commands) {
        super(name, dateOfBirth, commands);
    }
}
