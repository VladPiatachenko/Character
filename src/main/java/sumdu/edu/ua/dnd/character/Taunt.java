package sumdu.edu.ua.dnd.character;

public class Taunt extends Character{

    private int armor;
    private double aggroMultiplier;

    public Taunt(){
        super();
    }
    public Taunt(String name){
        super(name);
    }

    public Taunt(Character character){
        super(character);
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public double getAggroMultiplier() {
        return aggroMultiplier;
    }

    public void setAggroMultiplier(double aggroMultiplier) {
        this.aggroMultiplier = aggroMultiplier;
    }

    @Override
    public String toString() {
        return "Taunt{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", DNDClass=" + DNDClass +
                ", species=" + species +
                ", level=" + level +
                ", exp=" + exp +
                '}';
    }
}
