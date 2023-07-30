package animalslist;

import java.util.Date;
import java.util.LinkedList;

public class Camel extends PackAnimal{

    public Camel(String name, Date dateOfBirth) {
        super(name, dateOfBirth);
    }

    public Camel(String name, Date dateOfBirth, LinkedList<String> commands) {
        super(name, dateOfBirth, commands);
    }
}
