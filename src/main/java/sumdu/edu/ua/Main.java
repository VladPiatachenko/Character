package sumdu.edu.ua;

import sumdu.edu.ua.dnd.character.Character;
import sumdu.edu.ua.dnd.character.Damager;
import sumdu.edu.ua.dnd.character.Healer;
import sumdu.edu.ua.dnd.character.Taunt;
import sumdu.edu.ua.dnd.enums.DnDClass;
import sumdu.edu.ua.dnd.Party;
import sumdu.edu.ua.dnd.enums.Species;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Party brotherhoodOfRing=new Party();

        ArrayList<Character> party=new ArrayList<>();
        party.add(new Character("Conan", DnDClass.BARBARIAN, Species.HUMAN));
        party.add(new Character("Do Urden",DnDClass.ROGUE,Species.ELF));
        party.add(new Character("Dumbledore",DnDClass.WIZARD,Species.HUMAN));

        ArrayList<Character> partynew=new ArrayList<>();

        for(Character character:party){
            if(character.getDNDClass()==DnDClass.WIZARD){
                Healer charact=new Healer(character);
                partynew.add(charact);
            }else if(character.getDNDClass()==DnDClass.ROGUE){
                Damager charact=new Damager(character);
                charact.setExp(100);
                partynew.add(charact);
            }
            else{
                Taunt  chacact=new Taunt(character);
                partynew.add(chacact);
            }
        }

        Character ch =new Character("Geralt",DnDClass.BARD,Species.HUMAN);
        Damager ch_clone=new Damager(ch);

        System.out.println(ch_clone.equals(ch));

        /*
        brotherhoodOfRing.setParty(party);
        brotherhoodOfRing.printOut();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
        brotherhoodOfRing.setParty(partynew);
        brotherhoodOfRing.printOut();*/
    }
}