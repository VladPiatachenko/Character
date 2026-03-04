package sumdu.edu.ua;

import java.util.Objects;

public class Character {
    private int id;
    private static int nextid=100;
    private String name;
    private String DNDClass;
    private int level;
    private int exp;

    public Character(){
        this.id = nextid++;
        this.level = 1;
        this.exp = 0;
    }

    public Character(String name) {
        this();
        if(name.contains("@")){throw new IllegalArgumentException("Name can not be contain @");}
        this.name = name;
    }

    public Character(String name, String DNDClass) {
        this(name);
        this.DNDClass = DNDClass;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        if(exp<0){throw new IllegalArgumentException("Experience can not be negative!");}
        this.exp += exp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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
        if(name.contains("@")){throw new IllegalArgumentException("Name can not be contain @");}
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", DNDClass='" + DNDClass + '\'' +
                ", level=" + level +
                ", exp=" + exp +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Character character)) return false;
        return id == character.id && level == character.level && exp == character.exp && Objects.equals(name, character.name) && Objects.equals(DNDClass, character.DNDClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, DNDClass, level, exp);
    }
}
