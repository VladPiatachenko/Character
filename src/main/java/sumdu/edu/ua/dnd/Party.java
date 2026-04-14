package sumdu.edu.ua.dnd;

import sumdu.edu.ua.dnd.character.Character;

import java.util.ArrayList;

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
        party.add(c);
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
}