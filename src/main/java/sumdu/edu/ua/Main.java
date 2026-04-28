package sumdu.edu.ua;

import sumdu.edu.ua.db.DatabaseManager;
import sumdu.edu.ua.db.CharacterRepository;
import sumdu.edu.ua.dnd.Party;
import sumdu.edu.ua.dnd.character.Character;
import sumdu.edu.ua.dnd.character.Damager;
import sumdu.edu.ua.dnd.character.Healer;
import sumdu.edu.ua.dnd.character.Taunt;
import sumdu.edu.ua.dnd.enums.DnDClass;
import sumdu.edu.ua.dnd.enums.Species;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Usage: java Main app.properties");
            return;
        }

        String propertiesPath = args[0];

        try {
            DatabaseManager databaseManager = new DatabaseManager(propertiesPath);
            //databaseManager.initDatabase("src/main/resources/schema.sql");
            CharacterRepository repository = new CharacterRepository(databaseManager);
            repository.printAllCharactersStatement();

            Party gang = new Party();
            gang.setParty(repository.getAllCharactersStatement());

            System.out.println("~~~~");
            gang.printSortedCharacters();

           /* Character c1 = new Healer("Adrian", DnDClass.WIZARD, Species.ELF);
            Character c2 = new Taunt("Bromfield", DnDClass.BARBARIAN, Species.HUMAN);

            repository.insertCharacterPrepared(c1);
            repository.insertCharacterPrepared(c2);

            repository.printAllCharactersStatement();*/

        } catch (IOException e) {
            System.out.println("Error reading properties file: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}