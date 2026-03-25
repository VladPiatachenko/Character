package sumdu.edu.ua.dnd.character;

import java.util.Objects;

public class Healer extends Character{
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

}
