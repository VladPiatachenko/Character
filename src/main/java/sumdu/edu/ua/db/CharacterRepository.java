package sumdu.edu.ua.db;

import sumdu.edu.ua.dnd.character.Character;
import sumdu.edu.ua.dnd.character.Damager;
import sumdu.edu.ua.dnd.character.Healer;
import sumdu.edu.ua.dnd.character.Taunt;
import sumdu.edu.ua.dnd.enums.DnDClass;
import sumdu.edu.ua.dnd.enums.Species;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CharacterRepository {
    private final DatabaseManager databaseManager;

    public CharacterRepository(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    public void insertCharacterPrepared(Character character) throws SQLException {
        String sql = "INSERT INTO characters " +
                "(id, type, name, dnd_class, species, level, exp, damage) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = databaseManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, character.getId());
            preparedStatement.setString(2, getType(character));
            preparedStatement.setString(3, character.getName());

            if (character.getDNDClass() != null) {
                preparedStatement.setString(4, character.getDNDClass().name());
            } else {
                preparedStatement.setNull(4, java.sql.Types.VARCHAR);
            }

            if (character.getSpecies() != null) {
                preparedStatement.setString(5, character.getSpecies().name());
            } else {
                preparedStatement.setNull(5, java.sql.Types.VARCHAR);
            }

            preparedStatement.setInt(6, character.getLevel());
            preparedStatement.setInt(7, character.getExp());

            if (character instanceof Damager) {
                Damager damager = (Damager) character;
                preparedStatement.setInt(8, damager.getDamage());
            } else {
                preparedStatement.setNull(8, java.sql.Types.INTEGER);
            }

            preparedStatement.executeUpdate();
        }
    }

    public void printAllCharactersStatement() throws SQLException {
        String sql = "SELECT * FROM characters";

        try (Connection connection = databaseManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Character character = mapRow(resultSet);
                System.out.println(character);
                Character.setNextid(character.getId()+1);
            }
        }
    }
    public ArrayList<Character> getAllCharactersStatement() throws SQLException {
        String sql = "SELECT * FROM characters";
        ArrayList<Character> enlisted=new ArrayList<>();
        try (Connection connection = databaseManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Character character = mapRow(resultSet);
               enlisted.add(character);
                Character.setNextid(character.getId()+1);
            }
        }
        return enlisted;
    }

    public void updateNamePrepared(int id, String newName) throws SQLException {
        String sql = "UPDATE characters SET name = ? WHERE id = ?";

        try (Connection connection = databaseManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, newName);
            preparedStatement.setInt(2, id);

            int rowsUpdated = preparedStatement.executeUpdate();
            System.out.println("Updated rows: " + rowsUpdated);
        }
    }

    public void deleteByIdPrepared(int id) throws SQLException {
        String sql = "DELETE FROM characters WHERE id = ?";

        try (Connection connection = databaseManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            int rowsDeleted = preparedStatement.executeUpdate();
            System.out.println("Deleted rows: " + rowsDeleted);
        }
    }

    public void selectByTypePrepared(String typeValue) throws SQLException {
        String sql = "SELECT * FROM characters WHERE type = ?";

        try (Connection connection = databaseManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, typeValue);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Character character = mapRow(resultSet);
                    System.out.println(character);
                }
            }
        }
    }

    private Character mapRow(ResultSet resultSet) throws SQLException {
        String type = resultSet.getString("type");
        Character character;

        if ("Damager".equalsIgnoreCase(type)) {
            Damager damager = new Damager();
            int damage = resultSet.getInt("damage");
            if (!resultSet.wasNull()) {
                damager.setDamage(damage);
            }
            character = damager;
        } else if ("Healer".equalsIgnoreCase(type)) {
            character = new Healer();
        } else if ("Taunt".equalsIgnoreCase(type)) {
            character = new Taunt();
        } else {
            throw new IllegalArgumentException("Unknown character type: " + type);
        }

        character.setId(resultSet.getInt("id"));
        character.setName(resultSet.getString("name"));

        String dndClassValue = resultSet.getString("dnd_class");
        if (dndClassValue != null) {
            character.setDNDClass(DnDClass.valueOf(dndClassValue));
        }

        String speciesValue = resultSet.getString("species");
        if (speciesValue != null) {
            character.setSpecies(Species.valueOf(speciesValue));
        }

        character.setLevel(resultSet.getInt("level"));
        character.setExp(resultSet.getInt("exp"));

        return character;
    }

    private String getType(Character character) {
        if (character instanceof Damager) {
            return "Damager";
        }
        if (character instanceof Healer) {
            return "Healer";
        }
        if (character instanceof Taunt) {
            return "Taunt";
        }
        return "Character";
    }
}