package animalslist;

import java.util.Date;
import java.util.LinkedList;

public abstract class Animal {
    private String name;
    private Date dateOfBirth;
    private LinkedList<String> commands = new LinkedList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LinkedList<String> getCommands() {
        return commands;
    }

    public boolean addCommand(String newCommand){
        return this.commands.add(newCommand);
    }

    public Animal(String name, Date dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public Animal(String name, Date dateOfBirth, LinkedList<String> commands) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.commands = commands;
    }
}
