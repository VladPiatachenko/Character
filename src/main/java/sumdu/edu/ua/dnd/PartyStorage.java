package sumdu.edu.ua.dnd;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import sumdu.edu.ua.dnd.Party;
import sumdu.edu.ua.dnd.character.Character;

import java.io.File;
import java.io.IOException;

public class PartyStorage {
    private static final String FILE_NAME = "party.json";
    private static final ObjectMapper mapper = new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT);

    public static Party loadParty() {
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return new Party();
        }

        try {
            Party party = mapper.readValue(file, Party.class);
            fixCharacterCounters(party);
            return party;
        } catch (IOException e) {
            System.out.println("Error while reading file: " + e.getMessage());
            return new Party();
        }
    }

    public static void saveParty(Party party) {
        try {
            mapper.writeValue(new File(FILE_NAME), party);
        } catch (IOException e) {
            System.out.println("Error while saving file: " + e.getMessage());
        }
    }

    private static void fixCharacterCounters(Party party) {
        int maxId = 99;
        int count = 0;

        for (Character c : party.getParty()) {
            count++;
            if (c.getId() > maxId) {
                maxId = c.getId();
            }
        }

        Character.setAmount(count);
        Character.setNextid(maxId + 1);
    }
}