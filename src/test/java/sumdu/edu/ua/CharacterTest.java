package sumdu.edu.ua;

import org.junit.jupiter.api.Test;
import sumdu.edu.ua.dnd.Character;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterTest {

    @Test
    void succesfullCharacterCreationTest(){
        sumdu.edu.ua.dnd.Character testCharacterEmpty = new sumdu.edu.ua.dnd.Character();
        sumdu.edu.ua.dnd.Character clonedCharacter =testCharacterEmpty;
        sumdu.edu.ua.dnd.Character testCharacterNamed = new sumdu.edu.ua.dnd.Character("Bilbo");
        sumdu.edu.ua.dnd.Character testCharacterDefined = new sumdu.edu.ua.dnd.Character("Aragorn","Ranger");

        assertEquals(100,testCharacterEmpty.getId());
        assertEquals(101,testCharacterNamed.getId());
        assertEquals(102,testCharacterDefined.getId());

        assertEquals(1,testCharacterEmpty.getLevel());
        assertEquals(1,testCharacterNamed.getLevel());
        assertEquals(1,testCharacterDefined.getLevel());

        assertEquals(clonedCharacter,testCharacterEmpty);

        assertNull(testCharacterEmpty.getName());
        assertNotNull(testCharacterNamed.getName());

        assertNotEquals(0,testCharacterEmpty.getLevel());
        assertNotEquals(0,testCharacterNamed.getLevel());

        assertTrue(testCharacterEmpty.getId()>0);

        testCharacterEmpty.setName("Frodo");
        assertEquals("Frodo",testCharacterEmpty.getName());
    }

    @Test
    void setIllegalExpTest(){
        sumdu.edu.ua.dnd.Character TNO = new sumdu.edu.ua.dnd.Character();
        IllegalArgumentException exception=assertThrows(IllegalArgumentException.class,()->{TNO.setExp(-1);});
        assertEquals("Experience can not be negative!",exception.getMessage());
        assertDoesNotThrow(()->{TNO.setExp(5);});
    }

    @Test
    void setIllegalNameTest(){
        sumdu.edu.ua.dnd.Character TNO = new sumdu.edu.ua.dnd.Character();
        assertThrows(IllegalArgumentException.class,()->{TNO.setName("bronzeghoste@gmail.com");});
        assertThrows(IllegalArgumentException.class,()->{new Character("bronzeghoste@gmail.com");});

    }

}
