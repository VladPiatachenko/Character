package sumdu.edu.ua.dnd.character;

import sumdu.edu.ua.dnd.enums.DnDClass;
import sumdu.edu.ua.dnd.enums.Species;

import java.util.Objects;

public class Character {
    protected int id;
    protected static int nextid=100;
    protected static int amount=0;
    protected String name;
    protected DnDClass DNDClass;
    protected Species species;
    protected int level;
    protected int exp;

    public Character(){
        this.id = nextid;
        this.level = 1;
        this.exp = 0;
        amount++;
    }

    public Character(String name) {
        this();
        if(name.contains("@")){throw new IllegalArgumentException("Name can not be contain @");}
        this.name = name;
    }

    public Character(String name, DnDClass DNDClass, Species species) {
        this(name);
        this.DNDClass = DNDClass;
        this.species = species;
    }

    public Character(Character old){
        this();
        this.name=old.name;
        this.DNDClass=old.DNDClass;
        this.species = old.species;
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

    public DnDClass getDNDClass() {
        return DNDClass;
    }

    public void setDNDClass(DnDClass DNDClass) {
        this.DNDClass = DNDClass;
    }

    public String getName() {
        return name;
    }

    public static int getAmount() {
        return amount;
    }

    public void setName(String name) {
        if(name.contains("@")){throw new IllegalArgumentException("Name can not be contain @");}
        this.name = name;
    }

    public Species getSpecies() {
        return species;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", DNDClass='" + DNDClass.getTitle() + '\'' +
                ", DC='" + DNDClass.getStat() + '\'' +
                ", HP='" + DNDClass.getDice() + '\'' +
                ", level=" + level +
                ", exp=" + exp +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("on object level method");
        if (!(o instanceof Character character)) return false;
        return id == character.id && level == character.level && exp == character.exp && Objects.equals(name, character.name) && Objects.equals(DNDClass, character.DNDClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, DNDClass, level, exp);
    }

}
