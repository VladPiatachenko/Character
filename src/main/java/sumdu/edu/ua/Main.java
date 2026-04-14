package sumdu.edu.ua;

import sumdu.edu.ua.db.DatabaseManager;
import sumdu.edu.ua.db.CharacterRepository;
import sumdu.edu.ua.dnd.character.Character;
import sumdu.edu.ua.dnd.character.Damager;
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
            databaseManager.initDatabase("src/main/resources/schema.sql");
            CharacterRepository repository = new CharacterRepository(databaseManager);

            Character c1 = new Character("Aria", DnDClass.WIZARD, Species.ELF);
            Character c2 = new Damager(new Character("Brom", DnDClass.BARBARIAN, Species.HUMAN));

            repository.insertCharacterPrepared(c1);
            repository.insertCharacterPrepared(c2);

            repository.printAllCharactersStatement();

        } catch (IOException e) {
            System.out.println("Error reading properties file: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}