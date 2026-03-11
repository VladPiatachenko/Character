package sumdu.edu.ua.dnd;

import java.util.ArrayList;

public class Party {
    ArrayList<Character> party=new ArrayList<>();

    public ArrayList<Character> getParty() {
        return party;
    }
    public void setParty(ArrayList<Character> party) {
        this.party = party;
    }

    public Character getCharacterById(int id){
        return party.get(id);
    }

    public void printOut() {
        for(Character c:party){
            System.out.println(c.toString());
            c.getSpecies().printCreed();
        }
    }
}
