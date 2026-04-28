package sumdu.edu.ua.dnd;

import sumdu.edu.ua.dnd.character.Character;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Party {
    private ArrayList<Character> party = new ArrayList<>();

    public Party() {
    }

    public ArrayList<Character> getParty() {
        return party;
    }

    public void setParty(ArrayList<Character> party) {
        this.party = party;
    }

    public void addCharacter(Character c) {
        if(containsCharacter(c)){
            System.out.println(c.toString()+"is already in list");
            return;}
        else{
        party.add(c);}
    }

    public Character getCharacterById(int id) {
        for (Character c : party) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public void printOut() {
        for (Character c : party) {
            System.out.println(c);
            if (c.getSpecies() != null) {
                c.getSpecies().printCreed();
            }
        }
    }
    public void printSortedCharacters() {
        if (party.isEmpty()) {
            System.out.println("Список персонажів порожній.");
            return;
        }

        List<Character> sorted = new ArrayList<>(party);
        Collections.sort(sorted);

        for (Character character : sorted) {
            System.out.println(character);
        }
    }
    private boolean containsCharacter(Character c) {
        for(Character cl: party) {
            if (cl.equals(c)) {
                return true;
            }
        }
        return false;
        //return party.contains(c);
    }
}