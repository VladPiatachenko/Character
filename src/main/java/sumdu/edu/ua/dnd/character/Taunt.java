package sumdu.edu.ua.dnd.character;

public class Taunt extends Character{
    public Taunt(){
        super();
    }
    public Taunt(String name){
        super(name);
    }

    public Taunt(Character character){
        super(character);
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

    @Override
    void perform() {

    }
}
