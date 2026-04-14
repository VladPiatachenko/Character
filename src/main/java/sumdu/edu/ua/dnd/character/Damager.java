package sumdu.edu.ua.dnd.character;

import java.util.Objects;

public class Damager extends Character{
    private int damage;
    private double critChance;

    public Damager() {
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public double getCritChance() {
        return critChance;
    }

    public void setCritChance(double critChance) {
        this.critChance = critChance;
    }

    public Damager(Character character){
        super(character);
    }

    @Override
    public String toString() {
        return "Damager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", DNDClass=" + DNDClass +
                ", species=" + species +
                ", level=" + level +
                ", exp=" + exp +
                '}';
    }

}
