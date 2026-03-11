package sumdu.edu.ua;

import sumdu.edu.ua.dnd.Character;
import sumdu.edu.ua.dnd.DnDClass;
import sumdu.edu.ua.dnd.Party;
import sumdu.edu.ua.dnd.Species;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Party brotherhoodOfRing=new Party();

        ArrayList<Character> party=new ArrayList<>();
        party.add(new Character("Conan", DnDClass.BARBARIAN, Species.HUMAN));
        party.add(new Character("Do Urden",DnDClass.ROGUE,Species.ELF));
        party.add(new Character("Dumbledore",DnDClass.WIZARD,Species.HUMAN));

        brotherhoodOfRing.setParty(party);
        brotherhoodOfRing.printOut();

    }
}