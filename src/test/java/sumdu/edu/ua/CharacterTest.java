package sumdu.edu.ua;

import org.junit.jupiter.api.Test;
import sumdu.edu.ua.dnd.enums.DnDClass;
import sumdu.edu.ua.dnd.character.Character;
import sumdu.edu.ua.dnd.enums.Species;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterTest {

    @Test
    void succesfullCharacterCreationTest(){
        Character testCharacterEmpty = new Character();
        Character clonedCharacter =testCharacterEmpty;
        Character testCharacterNamed = new Character("Bilbo");
        Character testCharacterDefined = new Character("Aragorn", DnDClass.BARD, Species.HUMAN);

        assertEquals(100,testCharacterEmpty.getId());
        assertEquals(101,testCharacterNamed.getId());
        assertEquals(102,testCharacterDefined.getId());

        assertEquals(1,testCharacterEmpty.getLevel());
        assertEquals(1,testCharacterNamed.getLevel());
        assertEquals(1,testCharacterDefined.getLevel());

        assertEquals(DnDClass.BARD,testCharacterDefined.getDNDClass());

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
        Character TNO = new Character();
        IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,()->{TNO.setExp(-1);});
        assertEquals("Experience can not be negative!",exception.getMessage());
        assertDoesNotThrow(()->{TNO.setExp(50);});
    }

    @Test
    void setIllegalNameTest(){
        Character TNO = new Character();
        Exception exp=assertThrows(IllegalArgumentException.class,()->{TNO.setName("bronzeghoste@gmail.com");});
        assertEquals("Name can not be contain @",exp.getMessage());
        assertThrows(IllegalArgumentException.class,()->{new Character("bronzeghoste@gmail.com");});

    }

}