package animalslist;

import java.util.Date;
import java.util.LinkedList;

public class Horse extends PackAnimal{

    public Horse(String name, Date dateOfBirth) {
        super(name, dateOfBirth);
    }

    public Horse(String name, Date dateOfBirth, LinkedList<String> commands) {
        super(name, dateOfBirth, commands);
    }
}
