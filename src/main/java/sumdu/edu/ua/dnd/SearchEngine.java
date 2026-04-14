package sumdu.edu.ua.dnd;

import java.util.ArrayList;
import sumdu.edu.ua.dnd.character.Character;
import sumdu.edu.ua.dnd.enums.DnDClass;

public class SearchEngine {

    public Character searchById(int id, ArrayList<Character> characters) {
      //  ArrayList<Character> result = new ArrayList<>();
        for(Character c : characters) {
            if(c.getId()==id){
                return c;
            }
        }
        return null;
    }

    public ArrayList<Character> searchByLevelLimit(int lvl, ArrayList<Character> characters) {
        ArrayList<Character> result = new ArrayList<>();
        for(Character c : characters) {
            if(c.getLevel()<=lvl){
                result.add(c);
            }
        }
        return result;
    }

    public ArrayList<Character> searchByName(String name, ArrayList<Character> characters) {
        ArrayList<Character> result = new ArrayList<>();
        for(Character c : characters) {
            /*if(c.getName().equalsIgnoreCase(name)){
                result.add(c);
            }*/
            if(c.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(c);
            }
        }
        return result;
    }


}
