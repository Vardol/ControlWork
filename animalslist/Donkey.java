package animalslist;

import java.util.Date;
import java.util.LinkedList;

public class Donkey extends PackAnimal{

    public Donkey(String name, Date dateOfBirth) {
        super(name, dateOfBirth);
    }

    public Donkey(String name, Date dateOfBirth, LinkedList<String> commands) {
        super(name, dateOfBirth, commands);
    }
}
