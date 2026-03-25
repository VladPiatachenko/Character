package sumdu.edu.ua.dnd.character;

import java.util.Objects;

public class Damager extends Character{

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
