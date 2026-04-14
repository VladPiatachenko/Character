package sumdu.edu.ua.dnd.character;

import java.util.Objects;

public class Healer extends Character{

    private int healingPower;
    private boolean hasRevive;

    public Healer(){
        super();
    }
    public Healer(String name){
        super(name);
    }
    public Healer (Character character){
        super(character);
    }

    @Override
    public String toString() {
        return "Healer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", DNDClass=" + DNDClass +
                ", species=" + species +
                ", level=" + level +
                ", exp=" + exp +
                '}';
    }

    public int getHealingPower() {
        return healingPower;
    }

    public void setHealingPower(int healingPower) {
        this.healingPower = healingPower;
    }

    public boolean isHasRevive() {
        return hasRevive;
    }

    public void setHasRevive(boolean hasRevive) {
        this.hasRevive = hasRevive;
    }
}
