package animalslist;

import java.util.Date;
import java.util.LinkedList;

public class Hamster extends DomesticAnimal{
    public Hamster(String name, Date dateOfBirth) {
        super(name, dateOfBirth);
    }

    public Hamster(String name, Date dateOfBirth, LinkedList<String> commands) {
        super(name, dateOfBirth, commands);
    }
}
