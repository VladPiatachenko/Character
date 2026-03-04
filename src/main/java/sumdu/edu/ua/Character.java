package sumdu.edu.ua;

import java.util.Objects;

public class Character {
    private int id;
    private static int nextid=1;
    private String name;
    private String DNDClass;

    public Character(){
        this.id = nextid++;
    }

    public Character(String name) {
        this();
        this.name = name;
    }

    public Character(String name, String DNDClass) {
        this();
        this.name = name;
        this.DNDClass = DNDClass;
    }

    public int getId() {
        return id;
    }

    public String getDNDClass() {
        return DNDClass;
    }

    public void setDNDClass(String DNDClass) {
        this.DNDClass = DNDClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", DNDClass='" + DNDClass + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Character character)) return false;
        return id == character.id && Objects.equals(name, character.name) && Objects.equals(DNDClass, character.DNDClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, DNDClass);
    }
}
